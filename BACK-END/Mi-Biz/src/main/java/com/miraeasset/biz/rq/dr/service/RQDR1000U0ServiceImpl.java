package com.miraeasset.biz.rq.dr.service;

import java.sql.Clob;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.miraeasset.biz.common.util.*;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.ExcelReadOption;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.common.util.excel.ExcelUpload;
import com.miraeasset.biz.common.util.mail.MailUtil;
import com.miraeasset.biz.common.util.massage.MsgSenService;

import com.miraeasset.biz.common.aprv.dao.AprvDao;
import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

import com.miraeasset.biz.common.meta.vo.AprvWrrptInVO;
import com.miraeasset.biz.common.meta.vo.GA09N607InVO;
import com.miraeasset.biz.common.meta.vo.GA09N501VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U01VO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U03VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0VO;
import com.miraeasset.biz.rq.dr.vo.*;

import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.ss.zs.dao.SSZS2000U0Dao;
import com.miraeasset.biz.rq.dr.dao.RQDR1000U0Dao;
import com.miraeasset.biz.rq.cr.dao.RQCR1000U0Dao;
import com.miraeasset.biz.rq.rr.dao.RQRR1000U0Dao;


@Service
@Transactional
public class RQDR1000U0ServiceImpl implements RQDR1000U0Service {

	private final RQDR1000U0Dao daoRQDR1000U0;

	@Autowired
	public RQDR1000U0ServiceImpl(RQDR1000U0Dao daoRQDR1000U0) { this.daoRQDR1000U0 = daoRQDR1000U0; }

	@Autowired
	RQCR1000U0Dao RQCR1000U0Dao;

	@Autowired
	RQRR1000U0Dao RQRR1000U0Dao;

	@Autowired
	AprvDao AprvDao;

	@Autowired
	CodeDao CodeDao;

	@Autowired
	ExcelUpload ExlUp;

	@Autowired
	AprvWrrpt aprvWrrpt;

	@Autowired
	MailUtil mailUtil;

	@Autowired
	MsgSenService msgService;

	@Autowired
	RQAM1000U0Dao rqamDao;

	@Autowired
	SSZS2000U0Dao sszsUDao;


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final String strAPRV_PCD = "09";		// 문서신청

	private final String strPSIT_MENU_ID = "RQDR1000m0";		// 문서신청 화면 ID


	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장

	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중

	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료
	private final String CD_RQS_SCD_EMAL     = "15"; // 메일전송완료
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려

	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회

	private final String CD_RQS_SCD_CMPN     = "99"; // 완료


	private final String RQS_TCD_Storing = "090101";
	private final String RQS_TCD_Restoring = "090102";
	private final String RQS_TCD_Unstoring_Scan = "090201";
	private final String RQS_TCD_Unstoring_Box = "090202";
	private final String RQS_TCD_Modify_Info = "090301";
	private final String RQS_TCD_Modify_Storing = "090401";
	private final String RQS_TCD_Modify_Dispose = "090402";
	private final String RQS_TCD_Modify_Date = "090403";
	private final String RQS_TCD_Dispose = "090501";
	private final String RQS_TCD_StoringToDispose = "090502";


	@Value("${SYSTEM_NAME}")
	private String SYSTEM_NAME;


	/**
	 * 문서 신청 - 입력 타입 별 처리
	 * 타입 = 0901 : 입고, 0902 : 출고, 0903 : 박스정보정정, 0904 : 신청정정, 0905 : 폐기
	 */
	@Override
	public GA01N601VO insertGA01N601AndN604(GA01N601VO vo, LoginOutVO loginVo) {

		boolean bfRegiYn = false;
		int iRtn = 0;
		// String newApprtNo = "";
		String strRctNo = vo.getRctNo();
		String strRqsScd = vo.getRqsScd();
		String strUnifRqsPcd = vo.getUnifRqsPcd();
		String strUnifRqsDlPcd = vo.getUnifRqsDlPcd();
		String strUnifRqsTcd = vo.getUnifRqsTcd();

		// ======= Validation 시작 =======

		try{
			// 문서 신청 타입 체크
			if( !strUnifRqsPcd.contains(strAPRV_PCD) || !strUnifRqsDlPcd.contains(strAPRV_PCD) || !strUnifRqsTcd.contains(strAPRV_PCD) ){
				throw new CustomBadRequestException("신청 유형 정보를 확인해주세요.", ErrorCode.BAD_REQUEST);
			}

			if( !DateUtil.byteCheck(vo.getDlLocDesc(), 20) ){
				// log.info("상세위치설명 : {}", vo.getDlLocDesc().getBytes().length);
				throw new CustomBadRequestException("상세위치설명을 20 Byte(한글:2byte, 영문:1byte) 내로 입력해주세요.", ErrorCode.BAD_REQUEST);
			}
			if( !DateUtil.byteCheck(vo.getRqsTtlNm(), 50) ){
				// log.info("신청명 : {}", vo.getRqsTtlNm().getBytes().length);
				throw new CustomBadRequestException("신청명을 50 Byte(한글:2byte, 영문:1byte) 내로 입력해주세요.", ErrorCode.BAD_REQUEST);
			}


			// 090202 : 박스출고, 090402 : 폐기정정, 090501 : 폐기, 090301 : 박스정보정정 - 선택 되는 문서 박스 신청 중 인지 확인
			if( strUnifRqsTcd.equals(RQS_TCD_Unstoring_Box) || strUnifRqsTcd.equals(RQS_TCD_Dispose) ||
				strUnifRqsTcd.equals(RQS_TCD_Modify_Dispose) || strUnifRqsTcd.equals(RQS_TCD_Modify_Info) ) {
				if( StringUtils.isBlank(vo.getStrArrDocBoxSqncNo()) ) {
					throw new CustomBadRequestException("문서(Box) 정보가 없어요.", ErrorCode.BAD_REQUEST);
				}

				Map<String,Object> rtnMap = daoRQDR1000U0.selectGA01N603ValidationCnt(vo);
				if( Integer.parseInt(rtnMap.get("cnt").toString()) > 0 ){
					// 기 신청건 존재
					throw new CustomBadRequestException("신청중인 문서가 있어요.", ErrorCode.BAD_REQUEST);
				}
			}

			// 090402 : 폐기정정, 090501 : 폐기 : 문서 박스의 폐기 년도 Validation
			if( strUnifRqsTcd.equals(RQS_TCD_Modify_Dispose) || strUnifRqsTcd.equals(RQS_TCD_Dispose) ) {
				if( StringUtils.isBlank(vo.getStrArrDocBoxSqncNo()) ) {
					throw new CustomBadRequestException("문서(Box) 정보가 없어요.", ErrorCode.BAD_REQUEST);
				}

				GA01N602SchVO inDisVo = new GA01N602SchVO();
				inDisVo.setStrArrDocBoxSqncNo(vo.getStrArrDocBoxSqncNo());
				List<GA01N602SchVO> lstDisVo = selectGA01N602Sch(inDisVo);

				int iYear = Integer.parseInt(DateUtil.getTodayString("yyyy"));
				int iDYear;

				// 폐기 년도 체크
				for (GA01N602SchVO disVo : lstDisVo) {
					if( disVo.getDsusYr().equals("영구") ){
						throw new CustomBadRequestException("영구기간 문서는 폐기 할 수 없어요.", ErrorCode.BAD_REQUEST);
					}

					iDYear = Integer.parseInt(disVo.getDsusYr());
					if (iDYear == 0 || iYear <= iDYear) {
						throw new CustomBadRequestException(disVo.getDocBoxNm() + " 는 폐기년도 확인이 필요해요.", ErrorCode.BAD_REQUEST);
					}
				}
			}

			if( strUnifRqsDlPcd.equals("0904") ){
				// 정정 신청 시 기존 접수 번호 체크 해서 35 인지 99 인지 신청 유형 별로 Validation 적용
				if( StringUtils.isBlank(vo.getNteCn()) ) {
					throw new CustomBadRequestException("정정대상 접수번호를 확인해주세요.", ErrorCode.BAD_REQUEST);
				}

				GA01N601VO tmpInVo = new GA01N601VO();
				tmpInVo.setRctNo(vo.getNteCn());
				RQCR1000U01VO tmpVo = daoRQDR1000U0.selectGA01N101(tmpInVo);

				if( tmpVo.getUnifRqsTcd().equals(RQS_TCD_Storing) || tmpVo.getUnifRqsTcd().equals(RQS_TCD_Restoring) ){
					if( !vo.getUnifRqsTcd().equals(RQS_TCD_Modify_Storing) || !tmpVo.getRqsScd().equals("35") ){
						// 입고정정 은 입고, 재입고 가 철회 된 다음 신청 가능
						throw new CustomBadRequestException("정정 대상이 아니예요. \r\n (입고정정 은 [입고,재입고] 철회 후 신청 가능)", ErrorCode.BAD_REQUEST);
					}
				}
				else if( tmpVo.getUnifRqsTcd().equals(RQS_TCD_Dispose) || tmpVo.getUnifRqsTcd().equals(RQS_TCD_StoringToDispose) ){
					if( !vo.getUnifRqsTcd().equals(RQS_TCD_Modify_Dispose) || !tmpVo.getRqsScd().equals("35") ){
						// 폐기정정 은 입고후폐기, 폐기 가 철회 된 다음 신청 가능
						throw new CustomBadRequestException("정정 대상이 아니예요. \r\n (폐기정정 은 [입고후폐기,폐기] 철회 후 신청 가능)", ErrorCode.BAD_REQUEST);
					}
				}
				else if( tmpVo.getUnifRqsTcd().equals(RQS_TCD_Unstoring_Box) ){
					if( !vo.getUnifRqsTcd().equals(RQS_TCD_Modify_Date) || !tmpVo.getRqsScd().equals("99") ){
						// 입고정정 은 입고, 재입고 가 철회 된 다음 신청 가능해요.
						throw new CustomBadRequestException("정정 대상이 아니예요. \r\n (연장신청 은 [출고] 완료 후 신청 가능)", ErrorCode.BAD_REQUEST);
					}
				}
				else {
					throw new CustomBadRequestException("정정 대상이 아니예요. \r\n (정정대상 접수번호를 확인해주세요)", ErrorCode.BAD_REQUEST);
				}
			}
			else if( strUnifRqsTcd.equals(RQS_TCD_Storing) || strUnifRqsTcd.equals(RQS_TCD_StoringToDispose) || strUnifRqsTcd.equals(RQS_TCD_Modify_Storing) ){
				// 엑셀 업로드 건 Box 체크 Skip
			}
			else
			{
				if( StringUtils.isBlank(vo.getStrArrDocBoxSqncNo()) ) {
					throw new CustomBadRequestException("문서(Box) 정보가 없어요.", ErrorCode.BAD_REQUEST);
				}

				GA01N602SchVO inVo = new GA01N602SchVO();
				inVo.setStrArrDocBoxSqncNo(vo.getStrArrDocBoxSqncNo());
				List<GA01N602SchVO> lst602Vo = selectGA01N602Sch(inVo);
				if (lst602Vo.size() < 1) {
					throw new CustomBadRequestException("문서(Box) 정보가 없어요.", ErrorCode.BAD_REQUEST);
				}

				if(strUnifRqsTcd.equals(RQS_TCD_Restoring)){
					// 재입고
					// 입력 된 Box Seq 가 대출 상태 인지 확인
					if( lst602Vo.stream().anyMatch(fitVo -> !fitVo.getDocBoxScd().contains("20")) ){
						throw new CustomBadRequestException("문서(Box) 대출 상태를 확인해주세요.", ErrorCode.BAD_REQUEST);
					}
				}
				else if( strUnifRqsTcd.equals(RQS_TCD_Unstoring_Scan) || strUnifRqsTcd.equals(RQS_TCD_Unstoring_Box) || strUnifRqsTcd.equals(RQS_TCD_Modify_Info) || strUnifRqsTcd.equals(RQS_TCD_Dispose) ) {
					// 입력 된 Box Seq 가 입고 상태 인지 확인
					if( lst602Vo.stream().anyMatch(fitVo -> !fitVo.getDocBoxScd().contains("10")) ){
						throw new CustomBadRequestException("문서(Box) 입고 상태를 확인해주세요.", ErrorCode.BAD_REQUEST);
					}
				}

				// 박스출고, 폐기 신청 건 입력 시 Validation 추가_20231019
				/*
				if (strUnifRqsTcd.equals(RQS_TCD_Unstoring_Box) || strUnifRqsTcd.equals(RQS_TCD_Dispose)) {
					Map<String,Object> rtnMap = daoRQDR1000U0.selectGA01N603ValidationCnt(vo);
					if( Integer.parseInt(rtnMap.get("cnt").toString()) > 0 ){
						// 기 신청건 존재
						throw new CustomBadRequestException("신청중인 문서가 있어요.", ErrorCode.BAD_REQUEST);
					}
				}
				*/

			}
		} catch (CustomBadRequestException exC) {
			throw exC;
		} catch (Exception ex) {
			String strErr = CommonUtil.getCauseFirst(ex);
			log.error("== 문서 신청 Validation 진행 중  : " + strErr);
			log.error("{}", vo);
			throw new CustomBadRequestException(strErr, ErrorCode.BAD_REQUEST);
		}

		// ======= Validation 완료 =======

		// 임시 저장, 신청 때 항상 오늘 일자로 갱신
		vo.setRqsDt(DateUtil.getTodayString("yyyyMMdd"));

		if(!StringUtils.isBlank(strRctNo)) {
			bfRegiYn = true;
		}
		else {
			GaSrno00In00VO rctVo = new GaSrno00In00VO();
			rctVo.setCdKndNo("CHAEBUN");
			rctVo.setCmnCdVl(strAPRV_PCD);
			rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);

			strRctNo = rctVo.getRpbzGnoSrno();
			vo.setRctNo(strRctNo);
		}

		RQCR1000U01VO n101Vo = new RQCR1000U01VO();
		n101Vo.setRqsDt(vo.getRqsDt());
		n101Vo.setRctNo(vo.getRctNo());

		n101Vo.setUnifRqsPcd(vo.getUnifRqsPcd());
		n101Vo.setUnifRqsDlPcd(vo.getUnifRqsDlPcd());
		n101Vo.setUnifRqsTcd(vo.getUnifRqsTcd());

		n101Vo.setRqsOrzCd(vo.getOprtOrzCd());
		n101Vo.setRqsEpno(vo.getRqsEpno());

		n101Vo.setRqsTtlNm(vo.getRqsTtlNm());
		n101Vo.setRqsRsnCn(vo.getRqsRsnCn());
		n101Vo.setHopeDt(vo.getHopeDt());
		n101Vo.setCmpnDt(vo.getCmpnDt());
		n101Vo.setRqsScd(vo.getRqsScd());

		// 신청자 메일 주소 암호화
		vo.setEmpEmalAdrEcpVl(loginVo.getEmalAdr());

		if(bfRegiYn)
		{
			// 결재선 생성 여부 확인
			RQCR1000U01VO tmpVo = daoRQDR1000U0.selectGA01N101(vo);
			if(tmpVo == null){
				throw new CustomBadRequestException("신청 정보를 찾을 수 없습니다.", ErrorCode.BAD_REQUEST);
			}

			// Case - 임시 저장 후 신청
			RQCR1000U03VO n10103Vo = new RQCR1000U03VO();
			ObjectCopyUtil.copyFields(vo, n10103Vo);

			// 1. Update - GA01N101
			RQCR1000U0Dao.updateRqcr(n10103Vo);

			// 2. Update - GA01N601 (문서신청관리)
			daoRQDR1000U0.updateGA01N601(vo);
		}
		else
		{
			// Case - 임시 저장 or 신청

			// 1. Insert - GA01N101
			RQCR1000U0Dao.insertRqcr(n101Vo);

			// 2. Insert - GA01N601 (문서신청관리)
			iRtn = daoRQDR1000U0.insertGA01N601(vo);
		}

		// 3. Set - GA01N602 (박스관리), GA01N603 (문서신청별박스) 입력

		// 박스정보정정 (090301), 연장신청 (090403), 폐기정정 (090402)
		if(strUnifRqsTcd.equals(RQS_TCD_Modify_Info) || strUnifRqsTcd.equals(RQS_TCD_Modify_Dispose) || strUnifRqsTcd.equals(RQS_TCD_Modify_Date))
		{
			try {
				if (strUnifRqsTcd.equals(RQS_TCD_Modify_Dispose) || strUnifRqsTcd.equals(RQS_TCD_Modify_Date)) {
					List<GA01N602ModVO> tmpLst = new ArrayList<>();

					for (long docBoxSqncNo : vo.getArrDocBoxSqncNo()) {
						GA01N602ModVO tmp = new GA01N602ModVO();
						tmp.setDocBoxSqncNo(docBoxSqncNo);
						tmpLst.add(tmp);
					}

					vo.setInputGrd(tmpLst);
				}
				else{
					// Set - 입력 받은 docBoxSqncNo
					vo.setArrDocBoxSqncNo(vo.getInputGrd().stream().map(GA01N602ModVO::getDocBoxSqncNo).collect(Collectors.toList()));
				}

				// 기존 입력 된 데이터 삭제
				iRtn = daoRQDR1000U0.deleteGA01N603n604(vo);

				// docBoxSqncNo 기준 603 입력
				iRtn = daoRQDR1000U0.insertGA01N603byGA01N602(vo);

				// 위의 603 기준 - 604 입력
				iRtn = daoRQDR1000U0.insertGA01N604byGA01N603(vo);

				// Box Data Grid 형식 으로 Reqeust, 변경 데이터 업데이트
				for (GA01N602ModVO insVo : vo.getInputGrd()) {
					// 케이스에 따라 수정 예정 데이터 변경
					insVo.setDocRqsSqncNo(vo.getDocRqsSqncNo());

					if (strUnifRqsTcd.equals(RQS_TCD_Modify_Date)) {
						// 연장신청 (090403) - 자동 으로 + 30일 연장
						insVo.setWtdwDt(DateUtil.getTodayString("yyyyMMdd"));
					}
					else {
						// 박스정보정정 (090301)
						insVo.setWtdwDt("");
					}

					daoRQDR1000U0.updateGA01N604(insVo);
				}
			} catch (Exception ex) {
				log.error(ex.getMessage());

				throw new CustomBadRequestException(ex.getMessage(), ErrorCode.BAD_REQUEST);
			}
		}
		else if( strUnifRqsTcd.equals(RQS_TCD_Restoring) || strUnifRqsTcd.equals(RQS_TCD_Dispose) || strUnifRqsDlPcd.equals("0902") ){
			// 재입고 (090102), 출고 - 스캔출고 (090201), 박스출고 (090202), 폐기 (090501)
			try {
				// 기존 입력 된 데이터 삭제
				iRtn = daoRQDR1000U0.deleteGA01N603n604(vo);

				// 603 입력
				iRtn = daoRQDR1000U0.insertGA01N603byGA01N602(vo);
			} catch (Exception ex) {
				log.error(ex.getMessage());

				throw new CustomBadRequestException(ex.getMessage(), ErrorCode.BAD_REQUEST);
			}
		}
		else
		{
			// 입고 (090101), 입고 후 폐기 (090502), 신청정정 - 입고정정 (090401)
			try {
				MultipartFile exlFile = vo.getFileExcel();

				if (exlFile != null && !exlFile.isEmpty() && exlFile.getSize() > 5) {
					// log.info(" === Excel === getOriginalFilename : " + exlFile.getOriginalFilename());
					// log.info(" === Excel === getSize : " + exlFile.getSize());
					// log.info(" === Excel === getContentType : " + exlFile.getContentType());
					// List<Map<String, Object>> list = ExlUp.excelFileUpload(exlFile, null, 1, GA01N602VO.class);

					// 업로드 컬럼명 매핑
					Map<String, String> cols = new HashMap<>();
					cols.put("생산조직코드","prdtOrzCd");
					cols.put("문서박스명","docBoxNm");
					cols.put("박스문서내용","boxDocCn");
					cols.put("생산시작일자","prdtStrtDt");
					cols.put("생산종료일자","prdtEndDt");
					cols.put("보존년한","prsvYrVl");
					cols.put("폐기년도","dsusYr");
					cols.put("법인명","corpNm");
					cols.put("비고내용","nteCn");

					ExcelReadOption ERO = new ExcelReadOption();
					ERO.setStartRow(1);
					ERO.setExcelFile(exlFile);
					ERO.setCols(cols);
					List<Map<String, Object>> list = ExlUp.excelFileUploadTyp2(ERO);

					List<GA01N602VO> convertVo = ConvertUtils.convertToValueObjects(list, GA01N602VO.class);

					if (strRqsScd.equals(CD_RQS_SCD_APV_ING) && convertVo.size() < 1) {
						throw new CustomBadRequestException("엑셀 업로드 대상 데이터를 확인해주세요.", ErrorCode.BAD_REQUEST);
					}

					//기존 Key 값이 있는데, docRqsSqncNo 가 0 으로 입력 되는 경우
					if( !StringUtils.isBlank(vo.getStrArrDocBoxSqncNo()) && vo.getDocRqsSqncNo() < 1 ) {
						throw new CustomBadRequestException("필수 입력 값을 확인해주세요. [docRqsSqncNo]", ErrorCode.BAD_REQUEST);
					}

					// 엑셀 파일 로딩이 완료 되면, 기존 데이터는 삭제 후 입력
					iRtn = daoRQDR1000U0.deleteGA01N603n602(vo);

					for (GA01N602VO insVo : convertVo) {
						// 생산 조직 코드
						// insVo.setPrdtOrzCd(vo.getOprtOrzCd());
						// 관리 조직 코드
						insVo.setMtOrzCd(vo.getOprtOrzCd());
						// 바코드 생성 예정
						insVo.setDocBoxScd("00");

						// GA01N602 데이터 입력
						iRtn = daoRQDR1000U0.insertGA01N602(insVo);
						vo.setDocBoxSqncNo(insVo.getDocBoxSqncNo());

						// GA01N603 데이터 입력
						iRtn = daoRQDR1000U0.insertGA01N603(vo);
					}

				}

			} catch (CustomBadRequestException exC) {
				throw exC;
			} catch (Exception ex) {
				log.error(ex.getMessage());

				throw new CustomBadRequestException(ex.getMessage(), ErrorCode.BAD_REQUEST);
			}
		}


		/*
		if(strRqsScd.equals("05")) {
			newApprtNo = aprvWrrpt.aprvWrrpt(strRctNo, vo.getRqsEpno(), vo.getRqsOrzCd(), strAPRV_PCD, strPSIT_MENU_ID);
		}
		*/

		// 4. Set - 결재선 생성
		List<AprvWrrptInVO> aprvlList =  vo.getAprvl();

		/*
		// 결재선 임시 - 테스트 용
		if( aprvlList == null) {
			aprvWrrpt.aprvWrrpt(strRctNo, vo.getRqsEpno(), vo.getRqsOrzCd(), strAPRV_PCD, strPSIT_MENU_ID);
		}
		else
		{
		}
		*/
		if(strRqsScd.equals(CD_RQS_SCD_APV_ING) && aprvlList == null) {
			throw new CustomBadRequestException("결재선 정보를 확인해주세요.", ErrorCode.BAD_REQUEST);
		}

		if( aprvlList != null) {
			GA09N607InVO aprvVo = new GA09N607InVO();
			aprvVo.setRctNo(strRctNo);
			aprvVo.setAprvl(aprvlList);
			aprvWrrpt.aprvWrrpt(aprvVo);
		}

		if(iRtn < 1){
			// 저장 건이 없는 경우 처리?
			log.info(String.valueOf(iRtn));
		}

		// Reset
		vo.setFileExcel(null);
		// log.info(newApprtNo);

		return vo;
	}



	/**
	 * 문서 신청 - 완료 처리
	 */
	@Override
	public int updateGA01N601AndN604(GA01N601VO vo) {
		int iRtn;
		String strRctNo = vo.getRctNo();
		String strRqsScd = vo.getRqsScd();
		String strCmpnDt = vo.getCmpnDt();

		if( StringUtils.isBlank(strCmpnDt) ){
			throw new CustomBadRequestException("완료일자를 확인해주세요.", ErrorCode.BAD_REQUEST);
		}

		// 메일 전송에 필요한 데이터 조회
		GA01N601SchVO schVo = new GA01N601SchVO();
		schVo.setRctNo(strRctNo);

		List<GA01N601SchVO> n601 = daoRQDR1000U0.selectGA01N601AndN101(schVo);
		schVo = n601.get(0);

		vo.setUnifRqsDlPcd(schVo.getUnifRqsDlPcd());
		vo.setUnifRqsTcd(schVo.getUnifRqsTcd());
		vo.setDocRqsSqncNo(schVo.getDocRqsSqncNo());
		vo.setRqsEpno(schVo.getRqsEpno());

		String strUnifRqsTcd = vo.getUnifRqsTcd();

		// 임시로 승인 완료 or 메일 전송 완료 시 완료 처리 가능
		if( schVo.getRqsScd().equals(CD_RQS_SCD_APV_CMPN) || schVo.getRqsScd().equals(CD_RQS_SCD_EMAL) ){
			// 메일 전송 완료 시 완료 처리 가능
			log.info(" === 완료 요청 - " + strRctNo);
		}
		else if ( schVo.getUnifRqsTcd().equals(RQS_TCD_Unstoring_Scan) && schVo.getRqsScd().equals(CD_RQS_SCD_APV_CMPN) ) {
			// 스캔 출고 이면서, 승인 완료 일 때 완료 처리 가능
			log.info(" === 완료 요청 - " + strRctNo);
		}
		else {
			// 그 외 불가
			throw new CustomBadRequestException("메일전송완료 상태만 완료 처리 가능해요.", ErrorCode.BAD_REQUEST);
		}

		if (!strRqsScd.equals(CD_RQS_SCD_CMPN)) {
			throw new CustomBadRequestException("필수입력항목[신청상태코드] 오류. 입력 값을 확인하세요["+strRqsScd+"]", ErrorCode.BAD_REQUEST);
		}

		if( strUnifRqsTcd.equals(RQS_TCD_Storing) || strUnifRqsTcd.equals(RQS_TCD_Modify_Storing) ) {
			// 입고 (090101), 입고정정 (090401)
			try {

				MultipartFile exlFile = vo.getFileExcel();

				if (exlFile != null) {
					List<Map<String, Object>>list = ExlUp.excelFileUpload(exlFile, null, 1, GA01N602VO.class);

					// 값 있는 데이터만 필터링
					List<GA01N602VO> convertVo = new ArrayList<>();
					for (GA01N602VO tmpVo : ConvertUtils.convertToValueObjects(list, GA01N602VO.class)) {
						if( tmpVo.getDocBoxSqncNo() > 0 && !StringUtils.isBlank(tmpVo.getDvceNo()) && !StringUtils.isBlank(tmpVo.getBcdNo()) ){
							convertVo.add(tmpVo);
						}
					}
					// 입고 (090101) vs 입고정정 (090401) 분리?

					// DB 건수 vs 엑셀 건수 비교
					GA01N602VO vo602 = new GA01N602VO();
					vo602.setRctNo(strRctNo);
					List<GA01N602VO> n602 = daoRQDR1000U0.selectGA01N602byRctNo(vo602);

					if( n602.size() != convertVo.size() ){
						throw new CustomBadRequestException("신청 대상 건수가 다릅니다. 문서정보를 확인하세요[Count : "+n602.size()+"]", ErrorCode.BAD_REQUEST);
					}

					for (GA01N602VO insVo : convertVo) {
						// 보관 - 이관
						insVo.setDocBoxScd("10");
						insVo.setCmpnDt(strCmpnDt);

						// GA01N602 데이터 업데이트
						iRtn = daoRQDR1000U0.updateGA01N602BcdByBoxNo(insVo);
						if (iRtn < 1) {
							// 없는 Key 가 참조 된 경우
							throw new CustomBadRequestException("문서박스가 존재하지않습니다. 문서정보를 확인하세요[docBoxSqncNo : "+insVo.getDocBoxSqncNo()+"]", ErrorCode.BAD_REQUEST);
						}
					}
				}
				else {
					throw new CustomBadRequestException("엑셀 파일을 첨부해주세요.", ErrorCode.BAD_REQUEST);
				}

			} catch (CustomBadRequestException exC) {
				throw exC;
			} catch (Exception ex) {
				log.error(ex.getMessage());
				throw new CustomBadRequestException(ex.getMessage(), ErrorCode.BAD_REQUEST);
			}
		}
		else {
			// Set - 유형에 따라 Box Status 변경
			if(strUnifRqsTcd.equals(RQS_TCD_Modify_Info) || strUnifRqsTcd.equals(RQS_TCD_Modify_Dispose) || strUnifRqsTcd.equals(RQS_TCD_Modify_Date))
			{
				// 604 테이블 사용 - 박스정보정정 (090301), 연장신청 (090403), 폐기정정 (090402)

				// Set - 604 to 602 Update - by docRqsSqncNo
				iRtn = daoRQDR1000U0.updateGA01N604byGA01N602(vo);
			}
			else
			{
				// 602 테이블 사용 - 090102 : 재입고, 090201 : 스캔출고, 090202 : 박스출고, 090501 : 폐기, 090502 : 입고 후 폐기
				log.info(strUnifRqsTcd);
			}

			// 완료 처리
			vo.setRqsScd(CD_RQS_SCD_CMPN);

			// Set - 602 Status Update
			iRtn = daoRQDR1000U0.updateGA01N602BoxScdByRctNo(vo);
		}

		// Set - 신청 Status 완료 처리
		RQRR1000U0VO n101 = new RQRR1000U0VO();
		n101.setRctNo(vo.getRctNo());
		n101.setRqsScd(vo.getRqsScd());
		n101.setCmpnDt(vo.getCmpnDt());
		iRtn = RQRR1000U0Dao.updateRqsScd(n101);

		// 알림 메시지 전송 - 완료
		msgService.sendMsgEnrollNoti(vo.getRqsEpno(), vo.getRctNo(), "PROC_COMP", "", "");

		return iRtn;
	}


	/**
	 * 문서 신청 - 그리드 데이터 변경
	 */
	@Override
	public int updateGA01N602byList(List<GA01N602VO> lstVo) {
		return daoRQDR1000U0.updateGA01N602byList(lstVo);
	}


	/**
	 * 문서 신청 - 신청 내역 리스트, 상세
	 */
	@Override
	public List<GA01N601SchVO> selectGA01N601AndN101(GA01N601SchVO vo) {
		GA01N601SchVO tmp = daoRQDR1000U0.selectGA01N601AndN101_Cnt(vo);
		vo.setTotCnt(tmp.getTotCnt());

		return daoRQDR1000U0.selectGA01N601AndN101(vo);
	}

	/**
	 * 문서 신청 - 신청 내역 리스트 Status 요약
	 */
	@Override
	public Map<String, Object> selectGA01N601AndN101_RqsStat(GA01N601SchVO vo) {
		return daoRQDR1000U0.selectGA01N601AndN101_RqsStat(vo);
	}


	/**
	 * 문서 신청 - 문서(Box) 리스트 Status 요약
	 */
	@Override
	public Map<String, Object> selectGA01N602Sch_RqsStat(GA01N602SchVO vo) {
		return daoRQDR1000U0.selectGA01N602Sch_RqsStat(vo);
	}


	@Override
	public List<GA01N602VO> selectGA01N602byRctNo(GA01N602VO vo) {
		return daoRQDR1000U0.selectGA01N602byRctNo(vo);
	}


	/**
	 * 문서(Box) 관리 - 문서(Box) 리스트, 상세
	 */
	@Override
	public List<GA01N602SchVO> selectGA01N602Sch(GA01N602SchVO vo) {
		String strTmp = vo.getDocBoxScd();
		if(!StringUtils.isBlank(strTmp)){
			vo.setArrDocBoxScd(Arrays.asList(vo.getDocBoxScd().split("\\s*,\\s*")));
		}

		strTmp = vo.getNotDocBoxScd();
		if(!StringUtils.isBlank(strTmp)){
			vo.setArrNotDocBoxScd(Arrays.asList(vo.getNotDocBoxScd().split("\\s*,\\s*")));
		}

		strTmp = vo.getStrArrDocBoxSqncNo();
		if(!StringUtils.isBlank(strTmp)){
			vo.setArrDocBoxSqncNo(Pattern.compile("\\s*,\\s*").splitAsStream(strTmp).map(Long::parseLong).collect(Collectors.toList()));
		}

		GA01N602SchVO tmp = daoRQDR1000U0.selectGA01N602Sch_Cnt(vo);
		vo.setTotCnt(tmp.getTotCnt());

		return daoRQDR1000U0.selectGA01N602Sch(vo);
	}


	/**
	 * 문서(Box) 관리 - 접수 번호 기준, 변경 될 문서(Box) 상세 정보
	 */
	@Override
	public List<GA01N602SchVO> selectGA01N604SchByRctNo(GA01N602SchVO vo) {
		return daoRQDR1000U0.selectGA01N604SchByRctNo(vo);
	}


	@Override
	public String sendDocMailWithExcel(String strRctNo) {
		return sendDocMailWithExcel(strRctNo, "0");
	}

	/**
	 * 문서 신청 - 해당 신청 건, 엑셀 파일 전송
	 */
	@Override
	public String sendDocMailWithExcel(String strRctNo, String updFlag) {
		String strRtn;

		try {

			// 메일 전송에 필요한 데이터 조회
			GA01N601SchVO vo = new GA01N601SchVO();
			vo.setRctNo(strRctNo);

			List<GA01N601SchVO> n601 = daoRQDR1000U0.selectGA01N601AndN101(vo);
			vo = n601.get(0);

			// 신청자 메일 주소
			String strEmpEmalAdr = vo.getEmpEmalAdrEcpVl();

			// 메일 컨텐츠 생성
			String strEmailSubject = "[미래에셋증권] " + vo.getUnifRqsTcdNm() + "_" + vo.getRctNo() + "_" + vo.getRqsTtlNm();
			String strRqsTtlNm = vo.getRqsTtlNm();
			String strRqsDocNm = vo.getRqsDocNm();

			if (!SYSTEM_NAME.equals("real")) {
				strEmailSubject = String.format("[%s] %s", SYSTEM_NAME, strEmailSubject);
			}

			// 화면 담당자 정보
			Map<String,Object> map = new HashMap<>();
			map.put("psitMenuId", strPSIT_MENU_ID);
			Map<String,Object> psitMap = daoRQDR1000U0.selectCB01N310byMenuId(map);

			// 총무팀 담당자 사번
			String psitEpNo = "3329432";
			String psitOrzCd = "S03001";
			if(psitMap.get("epNo") != null) {
				psitEpNo = psitMap.get("epNo").toString();
				psitOrzCd = psitMap.get("orzCd").toString();
			}

			// 엑셀 데이터 조회
			GA01N602VO vo602 = new GA01N602VO();
			vo602.setRctNo(strRctNo);
			vo602.setUnifRqsTcd(vo.getUnifRqsTcd());
			List<GA01N602VO> n602 = daoRQDR1000U0.selectGA01N602byRctNoToExcel(vo602);


			// 스캔 출고 (090201) 의 경우, 지금은 메일 발송 막아야 함. Skip 처리 필요
			if(vo.getUnifRqsTcd().equals(RQS_TCD_Unstoring_Scan)){
				// 알림 메시지 로딩
				GA09N501VO vo501 = new GA09N501VO();
				vo501.setIprtMsgCd("AL0099");
				vo501 = sszsUDao.selectGA09N501(vo501);

				String strSndCn = vo501.getMsgSndCn();
				String strSndCnDesc = "";

				// 총무담당자 알림 시 내용 추가
				if( n602.size() > 0 ) {
					GA01N602VO tmp602Vo = n602.get(0);

					strSndCnDesc = "보관장소 : " + tmp602Vo.getCstdPlcCn() + "<br>"
							+ "디바이스번호 : " + tmp602Vo.getDvceNo() + "<br>"
							+ "바코드번호 : " + tmp602Vo.getBcdNo();
				}

				// 문서 신청 담당자 계정 으로 알림 전송
				msgService.sendMessageAsync(""
						, psitEpNo
						, vo501.getIprtMsgTtlNm()
						, String.format(strSndCn
								,vo.getRctNo()
								, vo.getRqsTtlNm()
								, vo.getRqsOrzCdNm()
								, vo.getRqsEpnoNm()
								, strSndCnDesc
						)
						, ""
						, ""
						, vo501.getIprtMsgCd()
						, psitOrzCd
						, psitEpNo
						, vo.getRctNo()
						, ""
				);

				return "success 실패 : 스캔 출고 메일 발송 불가";
			}

			// 업체 메일 주소 - 함상 암호화?
			String strChprEmalAdr = "";
			if( psitMap.get("chprEmalVl") != null ){
				strChprEmalAdr = psitMap.get("chprEmalVl").toString();
				if(!StringUtils.isBlank(strChprEmalAdr)) {
					try{
						strChprEmalAdr = CryptoUtil.getDecryption(strChprEmalAdr);
						// log.info(strChprEmalAdr);
					} catch(Exception ignored) {
						// 복호화 실패 시 우선 하드 코딩
						strChprEmalAdr = "wh@tong-in.com";
					}
				}
			}

			// 업체 메일 주소 로딩 실패 시 우선 하드 코딩
			if(StringUtils.isBlank(strChprEmalAdr)) {
				strChprEmalAdr = "wh@tong-in.com";
			}

			String saveFilePath = "";
			String fileName = "문서신청정보_" + (new SimpleDateFormat("yyyy-MM-dd_HHmmss_SSSSSS").format(new Date())) + ".xlsx";

			try {
				// fileName = URLEncoder.encode(fileName, "UTF-8");
				ExcelFile<GA01N602VO> excelFile = new OneSheetExcelFile<>(n602, GA01N602VO.class, new DefaultDataFormatDecider());
				saveFilePath = excelFile.createXlsEnc(fileName);
			} catch(Exception ignored){}

			mailUtil.setDefaultProperties();

			String sendId = "";
			String sendPw = "";
			String strMsg = "";

			// mi-square-dev
			if( SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") ) {
				sendId = "jeongjun.lee@miraeassetdev.com";
				sendPw = "wjdwns03#";

				strChprEmalAdr = "jeongjun.lee@miraeassetdev.com";
			}
			else {
				// 운영
				sendId = "mail_S03001@miraeasset.com";
				sendPw = "mirae@23";
			}

			/*
			// 검증계 임시 테스트 진행
			sendId = "jeongjun.lee@miraeasset.com";
			sendPw = "wjdwns04$";

			strChprEmalAdr = "jeongjun.lee@miraeasset.com";
			*/


			if( psitMap.get("msgSndCn") != null ) {
				try {
					strMsg = DateUtil.getCLOB((Clob)psitMap.get("msgSndCn"));
				} catch(Exception ignored) {
					strMsg = psitMap.get("msgSndCn").toString();
				}
			}
			else {
				strMsg = "";
			}

			String strHopeDt;
			try{
				strHopeDt = DateUtil.getDateString(new SimpleDateFormat("yyyyMMdd").parse(vo.getHopeDt()), "yyyy-MM-dd");
			} catch(Exception ignored) {
				strHopeDt = vo.getHopeDt();
			}

			// "epNm"	"stdNm"	"tlNo"	"epEmal"	"chprEmalVl"	"iprtMsgCd"	"msgSndCn"
			// "이름(부서)", "폰번호", "박스출고", "3", "신청명", "신청 사유", "신청주소", "상세위치", "기타요청사항", "희망일자", "이름", "직책", "회사 전화 번호", "이메일 주소"
			String content = String.format(strMsg,
					vo.getRqsEpnoNm() + "(" + vo.getRqsOrzCdNm() + ")", vo.getRqsHndpTlno(), vo.getUnifRqsTcdNm(), String.valueOf(n602.size()),
					vo.getRqsTtlNm(), vo.getRqsRsnCn(), vo.getRqsAdr(), vo.getDlLocDesc(), vo.getEtcCn(), strHopeDt,
					psitMap.get("epNm").toString(), psitMap.get("stdNm").toString(), psitMap.get("tlNo").toString(), psitMap.get("epEmal").toString()
			);

			List<String> filePathList = new ArrayList<>();
			filePathList.add(saveFilePath);

			strRtn = mailUtil.sendMailWithFiles(sendId, sendPw, strChprEmalAdr, strEmailSubject, content, filePathList);

			// log.info(" === 메일 전송 진행 완료 === ");
			// log.info(strRtn);
			// log.info(updFlag);

			if (updFlag.equals("1")) {
				if(strRtn.contains("success")) {
					// 메일 전송 성공 - Status Update
					RQRR1000U0VO n101 = new RQRR1000U0VO();
					n101.setRctNo(vo.getRctNo());
					n101.setRqsScd(CD_RQS_SCD_EMAL);
					n101.setCmpnDt(null);
					RQRR1000U0Dao.updateRqsScd(n101);
				}
			}

			try {
				// 업체 메일 발송 진행 후 총무팀 담당자 메일로 한번 더 발송
				mailUtil.sendMailWithFiles(sendId, sendPw, psitMap.get("epEmal").toString(), strEmailSubject, content, filePathList);
			} catch(Exception ignored) {}

			/* [20231026E] 메일 발송시 strRtn이 NULL인 케이스 */
			if(strRtn == null) { strRtn = "fail"; }

			if (!strRtn.contains("success")) {
				// 알림 메시지 로딩
				GA09N501VO vo501 = new GA09N501VO();
				vo501.setIprtMsgCd("AL0098");
				vo501 = sszsUDao.selectGA09N501(vo501);

				String strSndCn = vo501.getMsgSndCn();

				// 문서 신청 담당자 계정 으로 알림 전송
				msgService.sendMessageAsync(""
						, psitEpNo
						, String.format(vo501.getIprtMsgTtlNm(), vo.getUnifRqsTcdNm())
						, String.format(strSndCn
								, vo.getUnifRqsTcdNm()
								, vo.getRctNo()
								, vo.getRqsTtlNm()
								, vo.getRqsOrzCdNm()
								, vo.getRqsEpnoNm()
						)
						, ""
						, ""
						, vo501.getIprtMsgCd()
						, psitOrzCd
						, psitEpNo
						, vo.getRctNo()
						, ""
				);
			}

		} catch(Exception ex) {
			strRtn = ex.getMessage();
		}

		return strRtn;
	}


	/**
	 * 문서 신청 -  반려 처리
	 */
	@Override
	public int updateGA01N602RejectByDocNo(String strRctNo) {
		int iRtn = 0;

		//반려 대상 데이터 조회
		GA01N601SchVO schVo = new GA01N601SchVO();
		schVo.setRctNo(strRctNo);
		List<GA01N601SchVO> n601 = daoRQDR1000U0.selectGA01N601AndN101(schVo);

		GA01N601VO vo = new GA01N601VO();
		ObjectCopyUtil.copyFields(n601.get(0), vo);

		// 반려 처리
		vo.setRqsScd(CD_RQS_SCD_RTRN);

		// Set - 602 Status Update
		iRtn = daoRQDR1000U0.updateGA01N602BoxScdByRctNo(vo);

		return iRtn;
	}


	@Override
	public int deleteGA01N601(GA01N601VO vo) {
		int iRtn = 0;
		GA01N601SchVO schVo = new GA01N601SchVO();

		try {
			schVo.setRctNo(vo.getRctNo());

			List<GA01N601SchVO> n601 = daoRQDR1000U0.selectGA01N601AndN101(schVo);
			schVo = n601.get(0);
			ObjectCopyUtil.copyFields(schVo, vo);
 		} catch(Exception ex) {
			log.error(ex.getMessage());
			throw new CustomBadRequestException("접수 번호를 확인해주세요.", ErrorCode.BAD_REQUEST);
		}

		if (vo.getRqsScd().equals(CD_RQS_SCD_TMP_STRG)) {
			String strAprvNo = String.valueOf(schVo.getAprvWrrptMtNo());

			iRtn = daoRQDR1000U0.deleteGA01N601(vo);
			iRtn = rqamDao.deleteAprvl(strAprvNo);
		}
		else {
			throw new CustomBadRequestException("임시저장 신청 건만 삭제 가능해요.", ErrorCode.BAD_REQUEST);
		}

		return 1;
	}


	/**
	 * 문서 신청 -  철회 처리
	 */
	@Override
	public int updateGA01N602WithDrawByDocNo(String strRctNo) {
		int iRtn;

		//철회 대상 데이터 조회
		GA01N601SchVO schVo = new GA01N601SchVO();
		schVo.setRctNo(strRctNo);
		List<GA01N601SchVO> n601 = daoRQDR1000U0.selectGA01N601AndN101(schVo);

		GA01N601VO vo = new GA01N601VO();
		ObjectCopyUtil.copyFields(n601.get(0), vo);

		String strRqsScd = vo.getRqsScd();
		String strUnifRqsPcd = vo.getUnifRqsPcd();
		String strUnifRqsDlPcd = vo.getUnifRqsDlPcd();
		String strUnifRqsTcd = vo.getUnifRqsTcd();
		String strDocBoxScd;

		if ( !(strRqsScd.equals(CD_RQS_SCD_APV_CMPN) || strRqsScd.equals(CD_RQS_SCD_EMAL) || strRqsScd.equals(CD_RQS_SCD_CMPN)) ) {
			throw new CustomBadRequestException("[신청상태코드] 오류. 신청 가능 상태코드를 확인하세요["+strRqsScd+"]", ErrorCode.BAD_REQUEST);
		}

		/*
		// 090301 : 박스정보정정, 090403 : 연장신청 - 철회 불가
		if ( strUnifRqsTcd.equals("090301") || strUnifRqsTcd.equals("090403") ) {
			throw new CustomBadRequestException("[박스정보정정][연장신청] 신청 유형은 철회 하실 수 없어요.", ErrorCode.BAD_REQUEST);
		}
		*/

		// --- 아래 케이스는 쿼리 처리로 변경 - 필요 없으면 제거 예정

		// Set -- 00 : 바코드 생성 예정, 10 : 이관, 20 : 대출, 90 : 폐기, 99 : 입고철회
		if( strUnifRqsTcd.equals(RQS_TCD_Storing) || strUnifRqsTcd.equals(RQS_TCD_Modify_Storing) || strUnifRqsTcd.equals(RQS_TCD_StoringToDispose) ){
			// 090101 : 입고, 090401 : 입고정정, 090502 : 입고 후 폐기
			// Set - 입고철회
		}
		else if( strUnifRqsTcd.equals(RQS_TCD_Restoring) ){
			// 090102 : 재입고
			// Set - 대출
		}
		else if( strUnifRqsTcd.equals(RQS_TCD_Modify_Dispose) || strUnifRqsTcd.equals(RQS_TCD_Dispose) || strUnifRqsTcd.equals(RQS_TCD_Unstoring_Box) ){
			// 090402 : 폐기정정, 090501 : 폐기, 090202 : 박스출고
			// Set - 이관
		}
		else {
			// 090201 : 스캔출고, 090403 : 연장신청
			// Set - 그대로
		}

		// 철회 처리
		vo.setRqsScd(CD_RQS_SCD_WDRAL);

		// Set - 602 Status Update
		iRtn = daoRQDR1000U0.updateGA01N602BoxScdByRctNo(vo);

		return iRtn;
	}



	@Override
	public Map<String, Object> insertGA01N601ReApplyByRctNo(String prevRctNo, LoginOutVO loginVo) {

		GaSrno00In00VO rctVo = new GaSrno00In00VO();
		rctVo.setCdKndNo("CHAEBUN");
		rctVo.setCmnCdVl(strAPRV_PCD);
		rctVo = CodeDao.prbzSrnoGnoCrn(rctVo);
		String strRctNo = rctVo.getRpbzGnoSrno();

		Map<String, Object> map = new HashMap<>();
		map.put("rctNo", strRctNo);
		map.put("prevRctNo", prevRctNo);

		map.put("optrId", loginVo.getEpno());
		map.put("oprtChnlCd", loginVo.getOprtChnlCd());
		map.put("oprtOrzCd", loginVo.getOprtOrzCd());
		map.put("oprtIpAdr", loginVo.getOprtIpAdr());

		int rtn = daoRQDR1000U0.insertGA01N601ReApplyByRctNo(map);

		return map;
	}



}
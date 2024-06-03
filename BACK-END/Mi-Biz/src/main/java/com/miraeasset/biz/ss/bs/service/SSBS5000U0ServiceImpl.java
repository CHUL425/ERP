/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS5000U0ServiceImpl.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 화면관리 ServiceImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA09N204VO;
import com.miraeasset.biz.common.meta.vo.GA09N208VO;
import com.miraeasset.biz.common.meta.vo.GA09N209VO;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS1000V0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS5000U0Dao;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In03VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;

@Service
@Transactional
public class SSBS5000U0ServiceImpl implements SSBS5000U0Service {
	
	@Autowired
	SSBS5000U0Dao SSBS5000U0Dao;
	
	@Autowired
	RQSR1000U0Dao RQSR1000U0Dao;
	
	@Autowired
	CommonDao CommonDao;	
	
	@Autowired
	CodeDao CodeDao;
	
	@Autowired
	AprvWrrpt aprvWrrpt;		
	
	private final String PSIT_MENU_ID_92 = "SSBS7000m0";
	private final String PSIT_MENU_ID_91 = "SSBS7100m0";

	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료 
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	
    /* 화면관리 목록조회*/
	@Override
	public List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS5000U0Dao.selectListGA09N204(vo);
	}
	
    /* 화면관리 상세조회*/
	@Override
	public SSBS5000U0Out01VO selectGA09N204(SSBS5000U0In01VO vo) {
		// TODO Auto-generated method stub
		GA09N204VO GA09N204VO = new GA09N204VO();
		SSBS5000U0Out01VO outVo = new SSBS5000U0Out01VO();
		// 입력 데이터 카피
		ObjectCopyUtil.copyFields(vo, GA09N204VO);	

		GA09N204VO = SSBS5000U0Dao.selectGA09N204PK(GA09N204VO);
		
		if(GA09N204VO != null ) {
			// 출력 데이터 카피
			ObjectCopyUtil.copyFields(GA09N204VO,outVo);	
		}
		
		return outVo;
	}
	
	
	/* 화면관리 신규/수정/삭제 다건 */	
	@Override
	public int reqRegiListGA09N204(SSBS5000U0In03VO vo) {
		// 변수 초기화
		String prcTp = ""; /* 처리구분 N-신규 U-수정 D-삭제 */
	    String psitMenuId  = null;  /*포털사이트메뉴ID*/
	    String scrnNm      = null;  /*화면명          */
	    String scrnPcd     = null;  /*화면유형코드    */
	    String urlAdr      = null;  /*URL주소         */
	    String useYn       = null;  /*사용여부        */
	    String scrnOputSqn = null;  /*화면출력순서    */
	    String epno1 = null;  /*화면담당자1  */
	    String epno2 = null;  /*화면담당자2    */
	    String epno3 = null;  /*화면담당자3    */
	    String mchprYn1 = null; /*정담당자여부1 */	    
	    String mchprYn2 = null; /*정담당자여부2 */	    
	    String mchprYn3 = null; /*정담당자여부3 */	    
	    String kwrdCn = null; /*키워드내용 */	    

		// 채번vo
		String rqsEpno = null; // 신청사원번호
		String rqsOrzCd = null; // 신청조직코드		
		int cnt = 0;
		int mCnt = 0;
		
		List<GA09N204VO> gridGA09N204 = null;    /* 화면관리 다건내역 */		
		GA09N204VO GA09N204VO = null; /* 화면관리 */
		GA09N209VO GA09N209VO = null; /* 화면_담당사원 */
		GA09N208VO GA09N208VO = null; /* 화면_키워드 */
		
		// 전처리 : 입력값 체크
		{
			rqsEpno  = vo.getRqsEpno();
			rqsOrzCd = vo.getRqsOrzCd();

			if(rqsEpno == null || rqsEpno.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청사원번호] 오류. 입력값을 확인하세요["+rqsEpno+"]", ErrorCode.BAD_REQUEST);		
			}			
			if(rqsOrzCd == null || rqsOrzCd.equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[신청조직코드] 오류. 입력값을 확인하세요["+rqsOrzCd+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 입력값 체크
			gridGA09N204 = vo.getGridGA09N204();
			if(gridGA09N204 != null && gridGA09N204.size() > 0) {
				for(int i=0;i<gridGA09N204.size();i++) {
					GA09N204VO = gridGA09N204.get(i);
					
					prcTp = GA09N204VO.getPrcTp(); /* 처리구분 N-신규 U-수정 D-삭제 */
					
				    psitMenuId  = GA09N204VO.getPsitMenuId();  /*포털사이트메뉴ID*/
				    scrnNm      = GA09N204VO.getScrnNm();  /*화면명          */
				    scrnPcd     = GA09N204VO.getScrnPcd();  /*화면유형코드    */
				    urlAdr      = GA09N204VO.getUrlAdr();  /*URL주소         */
				    useYn       = GA09N204VO.getUseYn();  /*사용여부        */
				    scrnOputSqn = GA09N204VO.getScrnOputSqn();  /*화면출력순서    */
				    epno1 = GA09N204VO.getEpno1();  /*화면담당자1  */
				    epno2 = GA09N204VO.getEpno2();  /*화면담당자2  */
				    epno3 = GA09N204VO.getEpno3();  /*화면담당자3  */
				    mchprYn1 = GA09N204VO.getMchprYn1(); /*정담당자여부1 */
				    mchprYn2 = GA09N204VO.getMchprYn2(); /*정담당자여부2 */
				    mchprYn3 = GA09N204VO.getMchprYn3(); /*정담당자여부3 */
				    
					if(prcTp == null || prcTp.equals("") ) {
				        throw new CustomBadRequestException("필수입력항목[처리구분코드] 오류. 입력값을 확인하세요["+prcTp+"]", ErrorCode.BAD_REQUEST);		
					}

					if (!Arrays.asList("N","U","D").contains(prcTp)) {
				        throw new CustomBadRequestException("처리구분코드 입력오류 ["+prcTp+"] - (N:신규 U:수정 D:삭제) ", ErrorCode.BAD_REQUEST);								
					}					    

					
					// 화면id 필수 체크
					if(psitMenuId == null || "".equals(psitMenuId) ) {
				        throw new CustomBadRequestException("필수입력항목 화면관리[화면id] 오류. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
					}
					
					// 신규/수정시 내용 필수 입력체크
					if (Arrays.asList("N","U").contains(prcTp)) {
						// 화면명 필수 체크
						if(scrnNm == null || "".equals(scrnNm) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[화면명] 오류. 입력값을 확인하세요["+scrnNm+"]", ErrorCode.BAD_REQUEST);		
						}

						// 화면유형코드 필수 체크
						if(scrnPcd == null || "".equals(scrnPcd) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[화면유형코드] 오류. 입력값을 확인하세요["+scrnPcd+"]", ErrorCode.BAD_REQUEST);		
						}
						// 사용여부 필수 체크
						if(useYn == null || "".equals(useYn) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[사용여부] 오류. 입력값을 확인하세요["+useYn+"]", ErrorCode.BAD_REQUEST);		
						}
						
						// 화면담당자1 필수 체크
						if(epno1 == null || "".equals(epno1) ) {
					        throw new CustomBadRequestException("필수입력항목 화면관리[화면담당자1] 오류. 입력값을 확인하세요["+epno1+"]", ErrorCode.BAD_REQUEST);		
						}else {
							// 정담당자여부1 필수 체크
							if(mchprYn1 == null || "".equals(mchprYn1) ) {
						        throw new CustomBadRequestException("필수입력항목 화면관리[정담당자여부1] 오류. 입력값을 확인하세요["+mchprYn1+"]", ErrorCode.BAD_REQUEST);	
							}
						}
						
						// 화면담당자2 정합성체크
						if(epno2 != null && !epno2.equals("")) {
							// 정담당자여부2 필수 체크
							if(mchprYn2 == null || "".equals(mchprYn2) ) {
						        throw new CustomBadRequestException("화면담당자2 에 대한 정담당자여부2는 필수항목입니다. 입력값을 확인하세요["+mchprYn2+"]", ErrorCode.BAD_REQUEST);	
							}
						}
						
						// 화면담당자3 정합성체크
						if(epno3 != null && !epno3.equals("")) {
							// 정담당자여부3 필수 체크
							if(mchprYn3 == null || "".equals(mchprYn3) ) {
						        throw new CustomBadRequestException("화면담당자3 에 대한 정담당자여부3는 필수항목입니다. 입력값을 확인하세요["+mchprYn3+"]", ErrorCode.BAD_REQUEST);	
							}
						}						
					}

					// 기등록 중복 체크
					{
	
						GA09N204VO = SSBS5000U0Dao.selectGA09N204PK(GA09N204VO);
						
						// 신규체크 -> 기등록건체크
						if(prcTp.equals("N")){
							if(GA09N204VO != null) {
						        throw new CustomBadRequestException("[신규등록체크] 기등록 데이터가 존재합니다. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
							}
						}

						// 수정/삭제 -> 기등록건체크
						if(prcTp.equals("U") || prcTp.equals("D")){
							if(GA09N204VO == null) {
						        throw new CustomBadRequestException("[수정/삭제ㅔ체크] 기등록 데이터가 존재하지않습니다. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
							}
						}
					}
				}
			}else {
		        throw new CustomBadRequestException("처리대상 입력 건수가 없습니다. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);		
			}

		}

		// 등록/수정/삭제처리 
		{
			cnt = 0;
			gridGA09N204 = vo.getGridGA09N204();
			if(gridGA09N204 != null && gridGA09N204.size() > 0) {
				for(int i=0;i<gridGA09N204.size();i++) {
					GA09N204VO = gridGA09N204.get(i);
					
					prcTp = GA09N204VO.getPrcTp(); /* 처리구분 N-신규 U-수정 D-삭제 */
				    psitMenuId  = GA09N204VO.getPsitMenuId();  /*포털사이트메뉴ID*/
				    scrnNm      = GA09N204VO.getScrnNm();  /*화면명          */
				    scrnPcd     = GA09N204VO.getScrnPcd();  /*화면유형코드    */
				    urlAdr      = GA09N204VO.getUrlAdr();  /*URL주소         */
				    useYn       = GA09N204VO.getUseYn();  /*사용여부        */
				    scrnOputSqn = GA09N204VO.getScrnOputSqn();  /*화면출력순서    */
				    epno1 = GA09N204VO.getEpno1();  /*화면담당자1  */
				    epno2 = GA09N204VO.getEpno2();  /*화면담당자2  */
				    epno3 = GA09N204VO.getEpno3();  /*화면담당자3  */
				    mchprYn1 = GA09N204VO.getMchprYn1(); /*정담당자여부1 */	    
				    mchprYn2 = GA09N204VO.getMchprYn2(); /*정담당자여부2 */	    
				    mchprYn3 = GA09N204VO.getMchprYn3(); /*정담당자여부3 */	  
				    kwrdCn = GA09N204VO.getKwrdCn(); /*키워드내용 태그*/
					// 신규등록처리
					if(prcTp.equals("N")){
						mCnt = SSBS5000U0Dao.insertGA09N204(GA09N204VO);
					// 수정처리
					}else if(prcTp.equals("U")){
						mCnt = SSBS5000U0Dao.updateGA09N204(GA09N204VO);
						
					// 삭제처리
					}else if(prcTp.equals("D")){
						mCnt = SSBS5000U0Dao.deleteGA09N204(GA09N204VO);
						
						GA09N209VO = new GA09N209VO();
						GA09N209VO.setPsitMenuId(psitMenuId);
						// 화면담당자 화면번호기준 삭제
						mCnt = SSBS5000U0Dao.deleteGA09N209ByMenuId(GA09N209VO);
					}
					if(mCnt == 0) {
				        throw new CustomBadRequestException("화면관리 신규등록/수정/삭제 오류. 입력값을 확인하세요", ErrorCode.BAD_REQUEST);								
					}		
					
					// 화면담당자 삭제등록 처리
					if(mCnt > 0 ) {
						if(prcTp.equals("N") || prcTp.equals("U")){
							GA09N209VO = new GA09N209VO();
							GA09N209VO.setPsitMenuId(psitMenuId);
							
							// 화면담당자 화면번호기준 삭제
							mCnt = SSBS5000U0Dao.deleteGA09N209ByMenuId(GA09N209VO);
							if(epno1 != null && !epno1.equals(""))
							{
								GA09N209VO.setEpno(epno1);
								GA09N209VO.setMchprYn(mchprYn1);
								mCnt = SSBS5000U0Dao.insertGA09N209(GA09N209VO);
							}
							if(epno2 != null && !epno2.equals(""))
							{
								GA09N209VO.setEpno(epno2);
								GA09N209VO.setMchprYn(mchprYn2);
								mCnt = SSBS5000U0Dao.insertGA09N209(GA09N209VO);
							}
							if(epno3 != null && !epno3.equals(""))
							{
								GA09N209VO.setEpno(epno3);
								GA09N209VO.setMchprYn(mchprYn3);
								mCnt = SSBS5000U0Dao.insertGA09N209(GA09N209VO);
							}
							
						}
						
					}
					
					// 화면_키워드 삭제등록 처리
					{
						/* 2023.10.27 수정건이 빈값으로 진행될경우  */
//						if(kwrdCn !=null && !kwrdCn.equals("")) {
						if(kwrdCn !=null) {
							String[] kwrdLst = null;
							kwrdLst = kwrdCn.split(",");
							GA09N208VO = new GA09N208VO();
							GA09N208VO.setPsitMenuId(psitMenuId);
							
							// 화면id 기준 키워드 삭제
							mCnt = SSBS5000U0Dao.deleteGA09N208ByMenuId(GA09N208VO);
							
							log.info("kwrdCn ["+kwrdCn+"]");
							log.info("kwrdLst.length ["+kwrdLst.length+"]");
							for(int j=0;j<kwrdLst.length;j++) {
								//log.info("kwrdLst[j] ["+kwrdLst[j]+"]");
								if(!"".equals(kwrdLst[j].trim()) ){
									GA09N208VO = new GA09N208VO();
									GA09N208VO.setPsitMenuId(psitMenuId);
									GA09N208VO.setScrnSrchKwrdVl(kwrdLst[j]);

									// 화면키워드 신규등록
									mCnt = SSBS5000U0Dao.insertGA09N208(GA09N208VO);
								}
							}
						}
					}
				}
				cnt++;
			}
		}
		return cnt;
	}	 
	

	
}

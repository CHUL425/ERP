package com.miraeasset.biz.ga.rm.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.basic.service.BasicService;
import com.miraeasset.biz.common.basic.vo.BasicOrg01In00VO;
import com.miraeasset.biz.common.basic.vo.BasicOrg01Out00VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.ConvertUtils;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.StringUtils;
import com.miraeasset.biz.ga.rm.dao.GARM2000V0Dao;
import com.miraeasset.biz.ga.rm.vo.GARM2000ExcelVO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out02VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0Out00VO;

@Service
@Transactional
public class GARM2000V0ServiceImpl implements GARM2000V0Service {

	private final BasicService basicService; // 조직 주소 가져오기
	private final GARM2000V0Dao GARM2000Dao;

	public GARM2000V0ServiceImpl(BasicService basicService, GARM2000V0Dao garm2000Dao) {
		this.basicService = basicService;
		this.GARM2000Dao = garm2000Dao;
	}

	/* 렌탈관리내역(복합기) 조회 */
	@Override
	public List<GARM2000V0Out00VO> selectList00GA01N003(GARM2000V0In00VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getExccYm(), "").equals("")) {
			throw new CustomBadRequestException("정산년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		List<GARM2000V0Out00VO> list = GARM2000Dao.selectList00GA01N003(vo);
		return list;
	}
	
	/* 렌탈관리요약정보(복합기) 조회 */
	@Override
	public List<GARM2000V0Out01VO> selectList01GA01N003(GARM2000V0In01VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getExccYm(), "").equals("")) {
			throw new CustomBadRequestException("정산년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		List<GARM2000V0Out01VO> list = GARM2000Dao.selectList01GA01N003(vo);
		return list;
	}
	
	/* 렌탈관리내역(복합기) 조회(합계포함) */
	@Override
	public GARM2000V0Out02VO selectList04GA01N003(GARM2000V0In00VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getExccYm(), "").equals("")) {
			throw new CustomBadRequestException("정산년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		GARM2000V0Out02VO gridList = new GARM2000V0Out02VO();
		List<GARM2000V0Out00VO> list = null;
		list = GARM2000Dao.selectList00GA01N003(vo);
		if (list == null || list.size() == 0) {
		} else {
			gridList.setGridList(list);
		}
		GARM2000V0In01VO tot_vo = new GARM2000V0In01VO();
		ObjectCopyUtil.copyFields(vo, tot_vo);
		List<GARM2000V0Out01VO> totlist = GARM2000Dao.selectList01GA01N003(tot_vo);
		if (totlist == null || totlist.size() == 0) {
		} else {
			gridList.setSmarList(totlist);
		}
		return gridList;
	}
	
	/* 연간렌탈료 정산(계산) 조회 */
	@Override
	public List<GARM2010V0Out00VO> selectList02GA01N003(GARM2010V0In00VO vo) {
		if(StringUtils.empty(vo.getExccYm(), "").equals("")) {
			throw new CustomBadRequestException("기준년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		List<GARM2010V0Out00VO> list = GARM2000Dao.selectList02GA01N003(vo);
		return list;
	}
	
	/* 연간렌탈료 정산(계산) 수정 */
	@Override
	public int update00GA01N003(GARM2010V0In01VO vo) {
		// TODO Auto-generated method stub
		int update = GARM2000Dao.update00GA01N003(vo);
		return update;
	}

	/* 렌탈관리 엑셀업로드 - 복합기 */
	@Override
	public int excelUpload(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		int arryCnt = 0;
		int cnt = 0;
		List<GARM2000ExcelVO> convertVo = ConvertUtils.convertToValueObjects(list, GARM2000ExcelVO.class);
		GARM2000ExcelVO setVo = new GARM2000ExcelVO();

		/* [2023-09-07] 엑셀 업로드시 해당 정산년월 전체삭제 */
		List<String> deletedExccYm = new ArrayList<>();
		List<Integer> duplicatedRowNum = new ArrayList<>();
		for (int i=0; i < convertVo.size(); i++) {
			arryCnt++;
			setVo = convertVo.get(i);

			// 조직 주소 가져오기
			String orzCd = setVo.getMtOrzCd();
			BasicOrg01In00VO basicOrg01In00VO = new BasicOrg01In00VO();
			basicOrg01In00VO.setOrzCd(orzCd);
			List<BasicOrg01Out00VO> basicOrg01Out00VOList = basicService.selectOrg01(basicOrg01In00VO);
			if(basicOrg01Out00VOList.size() > 0) {
				setVo.setIstPlcNm(basicOrg01Out00VOList.get(0).getAdr());
			}

//			setVo.setOptrId("000000");
//			setVo.setOprtChnlCd("000");
//			setVo.setOprtOrzCd("000000");
//			setVo.setOprtIpAdr("000000");
			// 기존데이터 삭제후 등록
			/* [2023-09-07] 엑셀 업로드시 해당 정산년월 전체삭제 */
			//GARM2000Dao.delete00GA01N003(setVo);
			if(!deletedExccYm.contains(setVo.getExccYm())) {
				deletedExccYm.add(setVo.getExccYm());
				GARM2000Dao.delete01GA01N003(setVo);
			}

			// 무결성 제약조건 위배 예외처리
			try {
				GARM2000Dao.insert00GA01N003(setVo);
			} catch (DataIntegrityViolationException e) { // 무결성제약조건 예외처리
				e.printStackTrace();
				duplicatedRowNum.add(i+2); // 2번째 행부터 읽으므로 +2
			}
		}

		if(duplicatedRowNum.size() > 0) {
			throw new CustomBadRequestException("엑셀에 중복된 데이터가 있어요. [행 번호]: " + duplicatedRowNum, ErrorCode.BAD_REQUEST);
		}

		return arryCnt;
	}

	/* 복합기 정산년월 단가 조회 */
	@Override
	public GARM2010V0In01VO selectOne00GA01N003(GARM2010V0In01VO garm2010V0In01VO) {
		return GARM2000Dao.selectOne00GA01N003(garm2010V0In01VO);
	}
}

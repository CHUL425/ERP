package com.miraeasset.biz.ga.rm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.ConvertUtils;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.StringUtils;
import com.miraeasset.biz.ga.rm.dao.GARM1000V0Dao;
import com.miraeasset.biz.ga.rm.vo.GARM1000ExcelVO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In02VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In03VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0In04VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out01VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out02VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out03VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out04VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out05VO;
import com.miraeasset.biz.ga.rm.vo.GARM1000V0Out06VO;

@Service
@Transactional
public class GARM1000V0ServiceImpl implements GARM1000V0Service {
	
	@Autowired
	GARM1000V0Dao GARM1000Dao;
	
	/* 렌탈관리 조회 */
	@Override
	public List<GARM1000V0Out00VO> selectList00GA01N001(GARM1000V0In00VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getExccYm(), "").equals("")) {
			throw new CustomBadRequestException("정산년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		
		return GARM1000Dao.selectList00GA01N001(vo);
	}
	
	/* 렌탈관리내역 조회(합계포함) */
	public GARM1000V0Out05VO selectList05GA01N001(GARM1000V0In00VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getExccYm(), "").equals("")) {
			throw new CustomBadRequestException("정산년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		GARM1000V0Out05VO gridList = new GARM1000V0Out05VO();
		List<GARM1000V0Out00VO> list = null;
		list = GARM1000Dao.selectList00GA01N001(vo);
		if(list == null || list.size() == 0 ) {
		} else {
			gridList.setGridList(list);
		}
		
		GARM1000V0In01VO tot_vo = new GARM1000V0In01VO();
		ObjectCopyUtil.copyFields(vo, tot_vo);
		List<GARM1000V0Out01VO> totlist = GARM1000Dao.selectList01GA01N001(tot_vo);
		
		if (totlist == null || totlist.size() == 0) {
		} else {
			gridList.setSmarList(totlist);
		}
		
		return gridList;
	}
	
	
	/* 렌탈관리요약정보조회 */
	@Override
	public List<GARM1000V0Out01VO> selectList01GA01N001(GARM1000V0In01VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getExccYm(), "").equals("")) {
			throw new CustomBadRequestException("정산년월을 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		
		return GARM1000Dao.selectList01GA01N001(vo);
	}
	
	/* 연간렌탈료 조회 */
	@Override
	public List<GARM1000V0Out02VO> selectList02GA01N001(GARM1000V0In02VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getBasYm(), "").equals("")) {
			throw new CustomBadRequestException("조회년도를 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		
		return GARM1000Dao.selectList02GA01N001(vo);
	}
	
	/* 연간렌탈료요약정보 조회 */
	@Override
	public List<GARM1000V0Out03VO> selectList03GA01N001(GARM1000V0In03VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getBasYm(), "").equals("")) {
			throw new CustomBadRequestException("조회년도를 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		
		return GARM1000Dao.selectList03GA01N001(vo);
	}
	
	/* 연간렌탈료 조회(합계포함) */
	public GARM1000V0Out06VO selectList06GA01N001(GARM1000V0In02VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getBasYm(), "").equals("")) {
			throw new CustomBadRequestException("조회년도를 입력해주세요.", ErrorCode.BAD_REQUEST);
		}
		
		GARM1000V0Out06VO gridList = new GARM1000V0Out06VO();
		List<GARM1000V0Out02VO> list = null;
		list = GARM1000Dao.selectList02GA01N001(vo);
		if (list == null || list.size() == 0) {
		} else {
			gridList.setGridList(list);
		}
		
		GARM1000V0In03VO tot_vo = new GARM1000V0In03VO();
		ObjectCopyUtil.copyFields(vo, tot_vo);
		List<GARM1000V0Out03VO> totlist = GARM1000Dao.selectList03GA01N001(tot_vo);
		if (totlist == null || totlist.size() == 0) {
		} else {
			gridList.setSmarList(totlist);
		}
		
		return gridList;
	}
	
	/* 렌탈제품조회(신청지점의 렌탈관리 조회) */
	@Override
	public List<GARM1000V0Out04VO> selectList04GA01N001(GARM1000V0In04VO vo) {
		// TODO Auto-generated method stub
		if(StringUtils.empty(vo.getOrzCd(), "").equals("")) {
			throw new CustomBadRequestException("부점명을 확인해주세요.", ErrorCode.BAD_REQUEST);
		}
		
		return GARM1000Dao.selectList04GA01N001(vo);
	}
	
	/* 렌탈관리 엑셀업로드 - 정수기 */
	@Override
	public int excelUpload(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		int arryCnt = 0;
		int cnt = 0;
		List<GARM1000ExcelVO> convertVo = ConvertUtils.convertToValueObjects(list, GARM1000ExcelVO.class);
		GARM1000ExcelVO setVo = new GARM1000ExcelVO();

		/* [2023-09-07] 엑셀 업로드시 해당 정산년월 전체삭제 */
		List<String> deletedExccYm = new ArrayList<>();
		List<Integer> duplicatedRowNum = new ArrayList<>();
		for (int i=0; i < convertVo.size(); i++) {
			arryCnt++;
			setVo = convertVo.get(i);
//			setVo.setOptrId("000000");
//			setVo.setOprtChnlCd("000");
//			setVo.setOprtOrzCd("000000");
//			setVo.setOprtIpAdr("000000");
			
			
			
			// 기존데이터 삭제후 등록
			/* [2023-09-07] 엑셀 업로드시 해당 정산년월 전체삭제 */
			//GARM1000Dao.delete00GA01N001(setVo);
			if(!deletedExccYm.contains(setVo.getExccYm())) {
				deletedExccYm.add(setVo.getExccYm());
				GARM1000Dao.delete01GA01N001(setVo);
			}

			// 무결성 제약조건 위배 예외처리
			try {
				GARM1000Dao.insert00GA01N001(setVo);
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
}

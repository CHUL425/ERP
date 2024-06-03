package com.miraeasset.biz.ga.vm.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.ga.vm.dao.GAVM1000U0Dao;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In02VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In03VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In04VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In05VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out01VO;

@Service
@Transactional
public class GAVM1000U0ServiceImpl implements GAVM1000U0Service {
	
	@Autowired
	GAVM1000U0Dao dao;
	
	@Autowired
	CodeDao CodeDao;
	
	@Override
	public String nvl(String str, String nvlStr) {
        if(str == null || str.trim().equals("")) {
            return nvlStr;
        } else {
            return str;
        }
    }

	/* 임대차량정보관리 조회 */
	@Override
	public List<GAVM1000U0Out00VO> selectList00GA01N201(GAVM1000U0In00VO vo) {
		// TODO Auto-generated method stub
		GaCode01In00VO codeInfo = new GaCode01In00VO();
		List<GaCode01Out00VO> codeResult = new ArrayList<GaCode01Out00VO>();
		
		/* 차종구분 코드를 가지고 있지 않아 공통코드로 정합성 체크후 value 값 셋팅 */
		/**
		 * [20231127] 불필요한 부분 주석처리
		 * selectListGA01N201(합계 서비스)에서 이미 코드(CMN_CD_VL)로 조회 후, 이 서비스로 정의내용(CMN_CD_VL_DEF_CN)을 넘겨줌
		 * 그래서 코드조회시 아무것도 조회되지 않고, 인덱스 에러남
		 */
//		if (vo.getVhcKndNm() == null || vo.getVhcKndNm().equals("")) {
//		} else {
//			codeInfo.setCdKndNo("KCAR_TCD");
//			codeInfo.setCmnCdVl(vo.getVhcKndNm());
//			codeResult = CodeDao.selectListGaCode01(codeInfo);
//			vo.setVhcKndNm(codeResult.get(0).getCmnCdVlDefCn());
//		}

		// 페이징
		List<GAVM1000U0Out00VO> resultList = dao.selectList00GA01N201(vo);
		List<GAVM1000U0Out00VO> pagedResultList = resultList;

		if(vo.getPageIndex() != null && !!!vo.getPageIndex().equals("") &&
				vo.getPageSize() != null && !!!vo.getPageSize().equals("")) {
			int pageIndex = vo.getPageIndex().intValue();
			int pageSize = vo.getPageSize().intValue();

			if(pagedResultList.size() > pageIndex + pageSize) {
				pagedResultList = pagedResultList.subList(pageIndex, pageIndex + pageSize);
			} else if(pagedResultList.size() > pageIndex) {
				pagedResultList = pagedResultList.subList(pageIndex, pagedResultList.size());
			}
		}

		resultList = pagedResultList;

		return resultList;
	}
	
	/* 임대차량정보관리 합계 */
	@Override
//	public List<GAVM1000U0Out01VO> selectList01GA01N201(GAVM1000U0In01VO vo) {
	public List<GAVM1000U0Out01VO> selectList01GA01N201(List<GAVM1000U0Out00VO> gavm1000U0Out00VOList) {
//		// TODO Auto-generated method stub
//		GaCode01In00VO codeInfo = new GaCode01In00VO();
//		List<GaCode01Out00VO> codeResult = new ArrayList<GaCode01Out00VO>();
//
//		/* 차종구분 코드를 가지고 있지 않아 공통코드로 정합성 체크후 value 값 셋팅 */
//		if (vo.getVhcKndNm() == null || vo.getVhcKndNm().equals("")) {
//		} else {
//			codeInfo.setCdKndNo("KCAR_TCD");
//			codeInfo.setCmnCdVl(vo.getVhcKndNm());
//			codeResult = CodeDao.selectListGaCode01(codeInfo);
//			vo.setVhcKndNm(codeResult.get(0).getCmnCdVlDefCn());
//		}
//
//		return dao.selectList01GA01N201(vo);
		List<GAVM1000U0Out01VO> result = new ArrayList<>();
		GAVM1000U0Out01VO resultElement = new GAVM1000U0Out01VO();

		if(gavm1000U0Out00VOList == null || gavm1000U0Out00VOList.size() == 0) {
			resultElement.setVhcCnt("0");
			resultElement.setAlSmtl("0");
		} else {
			resultElement.setVhcCnt(gavm1000U0Out00VOList.get(0).getAlCnt().toString());
			BigDecimal alSmtl = BigDecimal.valueOf(0);
			for(GAVM1000U0Out00VO gavm1000U0Out00VO : gavm1000U0Out00VOList) {
				alSmtl = alSmtl.add(BigDecimal.valueOf(Long.parseLong(gavm1000U0Out00VO.getSurtExpPyLsA())));
			}
			resultElement.setAlSmtl(alSmtl.toString());
		}
		result.add(resultElement);
		return result;
	}
	
	/* 임대차량정보관리 조회 + 합계 */
	@Override
	public GAVM1000U0VO selectListGA01N201(GAVM1000U0In00VO vo) {
		// TODO Auto-generated method stub
		GaCode01In00VO codeInfo = new GaCode01In00VO();
		List<GaCode01Out00VO> codeResult = new ArrayList<GaCode01Out00VO>();
		
		/* 차종구분 코드를 가지고 있지 않아 공통코드로 정합성 체크후 value 값 셋팅 */
		if (vo.getVhcKndNm() == null || vo.getVhcKndNm().equals("")) {
		} else {
			codeInfo.setCdKndNo("KCAR_TCD");
			codeInfo.setCmnCdVl(vo.getVhcKndNm());
			codeResult = CodeDao.selectListGaCode01(codeInfo);
			vo.setVhcKndNm(codeResult.get(0).getCmnCdVlDefCn());
		}
		
		GAVM1000U0VO gridList = new GAVM1000U0VO();
		List<GAVM1000U0Out00VO> result = null;
		List<GAVM1000U0Out00VO> List = null;
		List<GAVM1000U0Out01VO> total = null;


		result = this.selectList00GA01N201(vo);
		List = dao.selectList00GA01N201(vo);
		gridList.setGridList(result);
		GAVM1000U0In01VO tot_vo = new GAVM1000U0In01VO();
		ObjectCopyUtil.copyFields(vo, tot_vo);

//		total = dao.selectList01GA01N201(tot_vo);
		total = this.selectList01GA01N201(List);
		if (total.size() > 0) {
			gridList.setTotalList(total);
		}

		return gridList;
	}
	
	/* 임대차량정보관리 = 중도해지위약금 조회 */
	@Override
	public List<GAVM1010U0Out00VO> selectList02GA01N201(GAVM1010U0In00VO vo) {
		// TODO Auto-generated method stub
		if (vo.getCclcFrcsDt() == null || vo.getCclcFrcsDt().equals("")) {
			throw new CustomBadRequestException("해지예상일자를 입력해주세요. ["+vo.getCclcFrcsDt()+"]", ErrorCode.BAD_REQUEST);
		}
		
		return dao.selectList02GA01N201(vo);
	}
	
	/* 임대차량정보관리 = 차량정보변경 조회 */
	@Override
	public List<GAVM1010U0Out01VO> selectList03GA01N201(GAVM1010U0In01VO vo) {
		// TODO Auto-generated method stub
		if (vo.getVhcNo() == null || vo.getVhcNo().equals("")) {
			throw new CustomBadRequestException("차량번호를 확인해주세요. ["+vo.getVhcNo()+"]", ErrorCode.BAD_REQUEST);
		}
		
		return dao.selectList03GA01N201(vo);
	}
	
	/* 임대차량정보관리 = 차량정보변경 단건등록 */
	@Override
	public int insert03GA01N201(GAVM1010U0In02VO vo) {
		// TODO Auto-generated method stub
		if (vo == null) {
			throw new CustomBadRequestException("등록할 데이터를 확인해주세요. ["+vo.toString()+"]", ErrorCode.BAD_REQUEST);
		}
		
		// 채번정보
		GaCode01In00VO codeinvo = new GaCode01In00VO();
		GaCode01Out00VO codeoutvo = null;
		List<GaCode01Out00VO> codelistvo = null;
		
		codeinvo.setCdKndNo("CHAEBUN");
		codeinvo.setCmnCdVl("VHCSRNO"); /* 차량정보변경 등록 채번 */
		codelistvo = CodeDao.selectChaebun(codeinvo);
		
		String newRctNo = null;
		if (codelistvo.size() > 0) {
			codeoutvo = codelistvo.get(0);
			newRctNo = codeoutvo.getNewNo(); 
		}
		
		if (newRctNo == null) {
			throw new CustomBadRequestException("자동채번오류 ["+newRctNo+"]", ErrorCode.BAD_REQUEST);
		}
		
		/* 최신 채번 정보 업데이트 */
		codeinvo.setNewNo(newRctNo);
		CodeDao.updateChaebun(codeinvo);
		
		vo.setSrno(newRctNo);
//		vo.setOptrId("000000");
//		vo.setOprtChnlCd("000");
//		vo.setOprtOrzCd("000000");
//		vo.setOprtIpAdr("000000");
		
		return dao.insert03GA01N201(vo);
	}
	
	/* 임대차량정보관리 = 차량정보변경 다건등록 */
	@Override
	public int insert05GA01N201(GAVM1010U0In05VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int arryCnt = 0;
		
		List<GAVM1010U0In02VO> inputList = vo.getInputList();
		GAVM1010U0In02VO setVo = null;
		
		// 채번정보
		GaCode01In00VO codeinvo = new GaCode01In00VO();
		GaCode01Out00VO codeoutvo = null;
		List<GaCode01Out00VO> codelistvo = null;
		
		if(inputList == null || inputList.size() == 0 ) {
            throw new CustomBadRequestException("차량정보변경 처리할 내역이 없습니다.", ErrorCode.BAD_REQUEST);					
		}
		
		for( int i = 0; i < inputList.size(); i++) {
			
			arryCnt++;
			
			codeinvo.setCdKndNo("CHAEBUN");
			codeinvo.setCmnCdVl("VHCSRNO"); /* 차량정보변경 등록 채번 */
			codelistvo = CodeDao.selectChaebun(codeinvo);
			
			String newRctNo = null;
			if (codelistvo.size() > 0) {
				codeoutvo = codelistvo.get(0);
				newRctNo = codeoutvo.getNewNo(); 
			}
			
			if (newRctNo == null) {
				throw new CustomBadRequestException("자동채번오류(임시문구) ["+newRctNo+"]", ErrorCode.BAD_REQUEST);
			}
			
			/* 최신 채번 정보 업데이트 */
			codeinvo.setNewNo(newRctNo);
			CodeDao.updateChaebun(codeinvo);
			
			setVo = inputList.get(i);
			setVo.setSrno(newRctNo);
//			setVo.setOptrId("000000");
//			setVo.setOprtChnlCd("000");
//			setVo.setOprtOrzCd("000000");
//			setVo.setOprtIpAdr("000000");
			
			cnt = dao.insert03GA01N201(setVo);
			if (cnt == 0) {
				throw new CustomBadRequestException("차량정보변경 등록 오류." + setVo.toString(), ErrorCode.BAD_REQUEST);
			}
		}
		
		return arryCnt;
	}
	
	
	
	/* 임대차량정보관리 = 차량정보변경 단건삭제 */
	@Override
	public int update03GA01N201(GAVM1010U0In03VO vo) {
		if (vo.getPrcDt() == null || vo.getVhcNo().equals("")) {
			throw new CustomBadRequestException("처리일자를 확인해주세요. ["+vo.getPrcDt()+"]", ErrorCode.BAD_REQUEST);
		}
		
		if (vo.getSrno() == null || vo.getSrno().equals("")) {
			throw new CustomBadRequestException("일련번호를 확인해주세요. ["+vo.getSrno()+"]", ErrorCode.BAD_REQUEST);
		}
		
		if (vo.getVhcNo() == null || vo.getVhcNo().equals("")) {
			throw new CustomBadRequestException("자동채번오류(임시문구) ["+vo.getVhcNo()+"]", ErrorCode.BAD_REQUEST);
		}
		
		return dao.update03GA01N201(vo);
	}
	
	/* 임대차량정보관리 = 차량정보변경 다건삭제 */
	@Override
	public int update04GA01N201(GAVM1010U0In04VO vo) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int arryCnt = 0;
		
		List<GAVM1010U0In03VO> inputList = vo.getInpuData();
		GAVM1010U0In03VO setVo = null;
		
		if(inputList == null || inputList.size() == 0 ) {
            throw new CustomBadRequestException("차량정보변경 내역이 없습니다.", ErrorCode.BAD_REQUEST);					
		}
		
		for( int i = 0; i < inputList.size(); i++) {
			setVo = inputList.get(i);
			
			arryCnt ++;
			
//			setVo.setOptrId("000000");
//			setVo.setOprtChnlCd("000");
//			setVo.setOprtOrzCd("000000");
//			setVo.setOprtIpAdr("000000");
			
			cnt = dao.update03GA01N201(setVo);
			if (cnt == 0) {
				throw new CustomBadRequestException("차량정보변경 삭제 오류." + setVo.toString(), ErrorCode.BAD_REQUEST);
			}
		}
		
		return arryCnt;
	}
	
}

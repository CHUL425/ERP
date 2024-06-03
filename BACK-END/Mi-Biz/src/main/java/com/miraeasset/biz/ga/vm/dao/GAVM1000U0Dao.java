package com.miraeasset.biz.ga.vm.dao;

import java.util.List;

import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In02VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In03VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out01VO;

public interface GAVM1000U0Dao {
	
	/* 임대차량정보관리 조회 */
	List<GAVM1000U0Out00VO> selectList00GA01N201(GAVM1000U0In00VO vo); 
	/* 임대차량정보관리 합계 */
	List<GAVM1000U0Out01VO> selectList01GA01N201(GAVM1000U0In01VO vo);
	
	/* 임대차량정보관리 = 중도해지위약금 조회 */
	List<GAVM1010U0Out00VO> selectList02GA01N201(GAVM1010U0In00VO vo);

	/* 임대차량정보관리 = 차량정보변경 조회 */
	List<GAVM1010U0Out01VO> selectList03GA01N201(GAVM1010U0In01VO vo);
	/* 임대차량정보관리 = 차량정보변경 등록 */
	int insert03GA01N201(GAVM1010U0In02VO vo);
	/* 임대차량정보관리 = 차량정보변경 삭제 */
	int update03GA01N201(GAVM1010U0In03VO vo); 
}

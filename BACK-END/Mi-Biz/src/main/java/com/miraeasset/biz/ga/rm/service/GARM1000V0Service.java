package com.miraeasset.biz.ga.rm.service;

import java.util.List;
import java.util.Map;

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

public interface GARM1000V0Service {

	/* 렌탈관리 조회 */
	List<GARM1000V0Out00VO> selectList00GA01N001(GARM1000V0In00VO vo);
	/* 렌탈관리요약정보조회 */
	List<GARM1000V0Out01VO> selectList01GA01N001(GARM1000V0In01VO vo);
	/* 연간렌탈료 조회 */
	List<GARM1000V0Out02VO> selectList02GA01N001(GARM1000V0In02VO vo);
	/* 연간렌탈료요약정보 조회 */
	List<GARM1000V0Out03VO> selectList03GA01N001(GARM1000V0In03VO vo);
	/* 렌탈제품조회(신청지점의 렌탈관리 조회) */
	List<GARM1000V0Out04VO> selectList04GA01N001(GARM1000V0In04VO vo);

	/* 렌탈관리내역 조회(합계포함) */
	GARM1000V0Out05VO selectList05GA01N001(GARM1000V0In00VO vo);
	
	/* 연간렌탈료 조회(합계포함) */	
	GARM1000V0Out06VO selectList06GA01N001(GARM1000V0In02VO vo);
	
	/* 엑셀업로드 - 정수기 */
	int excelUpload(List<Map<String, Object>> list);
}

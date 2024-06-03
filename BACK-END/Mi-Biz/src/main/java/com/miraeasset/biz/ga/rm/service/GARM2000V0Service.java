package com.miraeasset.biz.ga.rm.service;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.ga.rm.vo.GARM2000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out02VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0Out00VO;

public interface GARM2000V0Service {

	/* 렌탈관리(복합기) 조회 */
	List<GARM2000V0Out00VO> selectList00GA01N003(GARM2000V0In00VO vo); 
	/* 렌탈관리요약정보(복합기) 조회 */
	List<GARM2000V0Out01VO> selectList01GA01N003(GARM2000V0In01VO vo);
	
	/* 연간렌탈료 정산(계산) 조회 */
	List<GARM2010V0Out00VO> selectList02GA01N003(GARM2010V0In00VO vo);
	/* 연간렌탈료 정산(계산) 수정 */
	int update00GA01N003(GARM2010V0In01VO vo);

	/* 렌탈관리내역(복합기) 조회(합계포함) */
//	Map<String, Object> selectList04GA01N003(GARM2000V0In00VO vo);
	GARM2000V0Out02VO selectList04GA01N003(GARM2000V0In00VO vo);
	
	/* 엑셀업로드 - 복합기 */
	int excelUpload(List<Map<String, Object>> list);

	/* 복합기 정산년월 단가 조회 */
	public GARM2010V0In01VO selectOne00GA01N003(GARM2010V0In01VO garm2010V0In01VO);
}

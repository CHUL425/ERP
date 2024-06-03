package com.miraeasset.biz.ga.rm.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.miraeasset.biz.ga.rm.vo.GARM2000ExcelVO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2000V0Out01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In00VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0In01VO;
import com.miraeasset.biz.ga.rm.vo.GARM2010V0Out00VO;

public interface GARM2000V0Dao {
	
	/* 렌탈관리(복합기) 조회 */
	List<GARM2000V0Out00VO> selectList00GA01N003(GARM2000V0In00VO vo); 
	/* 렌탈관리요약정보(복합기) 조회 */
	List<GARM2000V0Out01VO> selectList01GA01N003(GARM2000V0In01VO vo);
	/* 연간렌탈료 정산(계산) 조회 */
	List<GARM2010V0Out00VO> selectList02GA01N003(GARM2010V0In00VO vo);
	/* 연간렌탈료 정산(계산) 수정 */
	int update00GA01N003(GARM2010V0In01VO vo);
	
	/* 렌탈관리 엑셀업로드 - 복합기 */
	int insert00GA01N003(GARM2000ExcelVO vo);
	/* 렌탈관리 삭제 - 복합기 */
	int delete00GA01N003(GARM2000ExcelVO vo);

	int delete01GA01N003(GARM2000ExcelVO vo);

	/* 복합기 정산년월 단가 조회 */
	GARM2010V0In01VO selectOne00GA01N003(GARM2010V0In01VO garm2010V0In01VO);
}

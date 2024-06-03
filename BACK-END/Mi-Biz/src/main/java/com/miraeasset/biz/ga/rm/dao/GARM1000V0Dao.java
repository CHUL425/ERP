package com.miraeasset.biz.ga.rm.dao;

import java.util.List;

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

public interface GARM1000V0Dao {
	
	/* 렌탈관리 조회 */
	List<GARM1000V0Out00VO> selectList00GA01N001(GARM1000V0In00VO vo); 
	/* 렌탈관리요약정보 조회 */
	List<GARM1000V0Out01VO> selectList01GA01N001(GARM1000V0In01VO vo);
	/* 연간렌탈료 조회 */
	List<GARM1000V0Out02VO> selectList02GA01N001(GARM1000V0In02VO vo);
	/* 연간렌탈료요약정보 조회 */
	List<GARM1000V0Out03VO> selectList03GA01N001(GARM1000V0In03VO vo);
	/* 렌탈제품조회(신청지점의 렌탈관리 조회) */
	List<GARM1000V0Out04VO> selectList04GA01N001(GARM1000V0In04VO vo);
	
	/* 렌탈관리 엑셀 업로드 -정수기 */
	int insert00GA01N001(GARM1000ExcelVO vo);
	/* 렌탈관리 삭제 -정수기 */
	int delete00GA01N001(GARM1000ExcelVO vo);

	/* 렌탈관리 삭제 -정수기 정산년월 전체 삭제*/
	int delete01GA01N001(GARM1000ExcelVO vo);
}

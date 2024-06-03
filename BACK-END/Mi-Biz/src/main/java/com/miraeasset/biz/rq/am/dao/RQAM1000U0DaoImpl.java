package com.miraeasset.biz.rq.am.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import com.miraeasset.biz.common.meta.vo.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out21VO;


@Repository
public class RQAM1000U0DaoImpl implements RQAM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 승댄대기 내역조회 */	
	@Override
	public List<RQAM1000U0Out00VO> selectAprvList(RQAM1000U0In00VO vo){
		if(vo.getPageNum() < 1){ vo.setPageNum(1); }
		if(vo.getPageSize().compareTo(BigDecimal.ZERO) <= 0){ vo.setPageSize(BigDecimal.valueOf(9999)); }

		return sqlSession.selectList("rqam_mapper.selectAprvList", vo);
	}	
	
	/* 승인처리 단건(승인/반려) */	
	@Override
	public int updateGA09N607Aprv(GA09N607Pu01InVO vo)  {
		return sqlSession.update("rqam_mapper.updateGA09N607Aprv", vo);
	}	
	
	/* 결재사유내용 변경 */	
	@Override
	public int updateGA09N607RsnCn(GA09N607VO vo) {
		return sqlSession.update("rqam_mapper.updateGA09N607RsnCn", vo);
	}	
	
	/* 승인처리 단건(승인/반려) */	
	@Override
	public int updateGA09N606Aprv(GA09N606Pu01InVO vo)  {
		return sqlSession.update("rqam_mapper.updateGA09N606Aprv", vo);
	}		
		
	/* 결재정보 등록 insert(PK) */	
	@Override
	public int insertGA09N606(GA09N606VO vo)  {
		return sqlSession.insert("rqam_mapper.insertGA09N606", vo);
	}	
			
	/* 결재상세정보 등록 insert(PK) */	
	@Override
	public int insertGA09N607(GA09N607VO vo)  {
		return sqlSession.insert("rqam_mapper.insertGA09N607", vo);
	}	
	
	/* 결재선내역조회 */	
	@Override
	public List<GA09N602Vf01OutVO> selectAprvLineList(GA09N602Vf01InVO vo) {
		return sqlSession.selectList("rqam_mapper.selectAprvLineList", vo);
	}	

	/* 다음결재정보 */	
	@Override
	public List<GA09N607VO> selectAprvNext(GA09N607VO vo) {
		return sqlSession.selectList("rqam_mapper.selectAprvNext", vo);
	}		
	
	/* 결재상세정보조회(PK) */	
	@Override
	public List<GA09N607VO> selectAprvDtlPk(GA09N607VO vo) {
		return sqlSession.selectList("rqam_mapper.selectAprvDtlPk", vo);
	}
	
	/* 결재상세정보조회(PK) */	
	@Override
	public List<GA09N606VO> selectGA09N606Pk(GA09N606VO vo) {
		return sqlSession.selectList("rqam_mapper.selectGA09N606Pk", vo);
	}
	
	/* 결재 - 사용자정보조회 */
	@Override
	public List<GA09N602Vf02OutVO> selectAprvWrrptUserInfoList(GA09N602Vf02InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectAprvWrrptUserInfoList", vo);
	}
	
	/* 결재 모듈 - 결재선 생성 처리 */
	@Override
	public int insertAprvLine(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rqam_mapper.insertAprvLine", vo);
	}
	
	/* 결재 모듈 - 결재 철회 정보 생성 */
	@Override
	public int insertGA09N607Wdral(GA09N607Pu01InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("rqam_mapper.insertGA09N607Wdral", vo);
	}
	
	/* 업무담당자 여부 조회 */
	@Override
	public GA09N602Vf02OutVO selectBzChprYn(GA09N602Vf02InVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("rqam_mapper.selectBzChprYn", vo);
	}
	
	
	/* 2023.09.05 */
	/* 결재_결재정보상세 조회 */
	@Override
	public List<GA09N607VO> selectAprvWrrptDlList(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectAprvWrrptDlList", vo);
	}
	/* 참조, 다움대상결재자 조회 */
	@Override
	public GA09N607VO selectNextAprvWrrptList(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("rqam_mapper.selectNextAprvWrrptList", vo);
	}
	/* 결재상세정보 수정 */
	@Override
	public int updateAprvWrrpt(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rqam_mapper.updateAprvWrrpt", vo);
	}
	
	/* 2023.09.07 */
	/* 기본결재선 조회 */
	@Override
	public List<GA09N607aprvVO> selectBaseAprvLineList(GA09N607aprvVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectBaseAprvLineList", vo);
	}
	
	/* 임시저장 결재선 조회 */
	@Override
	public List<GA09N607aprvVO> selectTmpStrgAprvLineList(GA09N607aprvVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectTmpStrgAprvLineList", vo);
	}

	/* 임대신청 상태 수정 */
	@Override
	public int updateAprvRqsScd(GA01N101VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rqam_mapper.updateAprvRqsScd", vo);
	}
	
	/* 임대신청 조회(pk) */
	@Override
	public GA01N101VO selectGA01N101Pk(GA01N101VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("rqam_mapper.selectGA01N101Pk", vo);
	}
	
	/* 임대신청 상태 수정 */
	@Override
	public int updateAprvWrrptStat(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("rqam_mapper.updateAprvWrrptStat", vo);
	}
	
	/* 기본 결재선관리번호 조회 */
	@Override
	public GA09N602Vf02OutVO baseAprvLine(GA09N602Vf02OutVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("rqam_mapper.baseAprvLine", vo);
	}
	
	/* 대결확인여부 조회 */
	@Override
	public List<GA09N607VO> selectSbapCfmtYn(GA09N607VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rqam_mapper.selectSbapCfmtYn", vo);
	}
	
	/* 결재선 삭제 */
	@Override
	public int deleteAprvl(String aprvWrrptMtNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("rqam_mapper.deleteAprvl", aprvWrrptMtNo);
	}
	
	/* 업무담당자 사원번호 조회 */
	@Override
	public String selectBzChprEpno(String psitMenuId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("rqam_mapper.selectBzChprEpno", psitMenuId);
	}

	// [20231130] 삭제예정. 결재관리번호 2023110100000006를 철회하기 위해 임시로 생성한 내용
//	@Override
//	public int insertGA09N607WdralFor2023110100000006(GA09N607Pu01InVO vo) {
//		return sqlSession.insert("rqam_mapper.insertGA09N607WdralFor2023110100000006", vo);
//	}
	/* 인감날인증명서 승인대기목록조회 */	
	@Override
	public List<RQSR1000U0Out21VO> selectSealAprvList(RQAM1000U0In00VO vo){
		if(vo.getPageNum() < 1){ vo.setPageNum(1); }
		if(vo.getPageSize().compareTo(BigDecimal.ZERO) <= 0){ vo.setPageSize(BigDecimal.valueOf(9999)); }
	
		return sqlSession.selectList("rqam_mapper.selectSealAprvList", vo);
	}
	/* 인감날인증명서 승인대기목록조회 - 전체건수*/	
	@Override
	public int selectSealAprvListTotCnt(RQAM1000U0In00VO vo){
		vo.setPageNum(1); 
		vo.setPageSize(BigDecimal.valueOf(9999));
	
		return sqlSession.selectOne("rqam_mapper.selectSealAprvListTotCnt", vo);
	}

	@Override
	public GA09N602VO selectOneGA09N602ByKey(GA09N602KeyVO ga09N602KeyVO) {
		return sqlSession.selectOne("rqam_mapper.selectOneGA09N602ByKey", ga09N602KeyVO);
	}

	@Override
	public List<GA09N602VO> selectListGA09N602ByAprvlMtNo(String aprvlMtNo) {
		return sqlSession.selectList("rqam_mapper.selectListGA09N602ByAprvlMtNo", aprvlMtNo);
	}
	
	/* 회수 */	
	@Override
	public RQAM1000U0Out01VO selectGA01N101Wtdw(String rctNo) {
		return sqlSession.selectOne("rqam_mapper.selectGA01N101Wtdw", rctNo);
	}
}

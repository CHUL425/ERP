package com.miraeasset.biz.rq.sr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA01N109VO;
import com.miraeasset.biz.common.meta.vo.GA01N504VO;
import com.miraeasset.biz.common.meta.vo.GA01N505OutQ1VO;
import com.miraeasset.biz.common.meta.vo.GA01N505OutQ2VO;
import com.miraeasset.biz.common.meta.vo.GA01N505VO;
import com.miraeasset.biz.common.meta.vo.GA01N510VO;
import com.miraeasset.biz.common.meta.vo.GA09N607VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In26VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out05VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out11VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out15VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out18VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out23VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out24VO;


@Repository
public class RQSR1000U0DaoImpl implements RQSR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/* 인감날인증명서신청 목록조회 */	
	@Override
	public List<RQSR1000U0Out00VO> selectListGA01N101BySeal(RQSR1000U0In00VO vo) {
		return sqlSession.selectList("rqsr_mapper.selectListGA01N101BySeal", vo);
	}	
	
	/* 인장신청_인감날인신청신청상태 정보조회 */	
	@Override
	public RQSR1000U0Out11VO selectInfoGA01N101BySeal(RQSR1000U0In00VO vo) {
		return sqlSession.selectOne("rqsr_mapper.selectInfoGA01N101BySeal", vo);
	}	
	
	/* 인장신청_인감날인신청 목록조회 */
	@Override
	public List<GA01N504VO> selectListGA01N504(GA01N504VO vo) {
		return sqlSession.selectList("rqsr_mapper.selectListGA01N504", vo);
	}	
	    
	/* 인장신청_인감증명서신청 목록조회 */
	@Override
	public List<GA01N505VO> selectListGA01N505(GA01N505VO vo) {
		return sqlSession.selectList("rqsr_mapper.selectListGA01N505", vo);
	}	

	/* 인감증명서신청 인감기준 증명서 목록조회 */	
	@Override
	public List<GA01N505OutQ1VO> selectListGA01N505BySalMtNoWithQ1(GA01N505VO vo) {
		return sqlSession.selectList("rqsr_mapper.selectListGA01N505BySalMtNoWithQ1", vo);
	}	
    
	/* 인장신청_인감증명서신청 제출처기준 등기부등본 목록조회 */	
	@Override
	public List<GA01N505OutQ2VO> selectListGA01N505BySmtpCnWithQ2(GA01N505VO vo) {
		return sqlSession.selectList("rqsr_mapper.selectListGA01N505BySmtpCnWithQ2", vo);
	}	
	
	/* 통합신청_신청별기안문서 목록조회 */	
	@Override
	public List<GA01N109VO> selectListGA01N109(GA01N109VO vo) {
		return sqlSession.selectList("rqsr_mapper.selectListGA01N109", vo);
	}	

	/* 인감날인증명서 승인완료 목록조회 */	
	@Override
	public List<RQSR1000U0Out20VO> selectListApvCmpn(RQSR1000U0In20VO vo) {
		if(vo.getPageNum() < 1){ vo.setPageNum(1); }
		if(vo.getPageSize() < 1){ vo.setPageSize(50); }

		return sqlSession.selectList("rqsr_mapper.selectListApvCmpn", vo);
	}
	
	/* 인감날인증명서 승인완료 총건수 조회 */
	@Override
	public int selectListApvCmpnTotCnt(RQSR1000U0In20VO vo) {
		vo.setPageNum(1); 
		vo.setPageSize(9999);
		
		return sqlSession.selectOne("rqsr_mapper.selectListApvCmpnTotCnt", vo);
	}
	
	/* 인감날인증명서 승인완료 신청상태 정보조회 */	
	@Override
	public  RQSR1000U0Out11VO selectListApvCmpnBySeal(RQSR1000U0In20VO vo){
		vo.setPageNum(1);
		vo.setPageSize(9999);

		return sqlSession.selectOne("rqsr_mapper.selectListApvCmpnBySeal", vo);
	}	    
	
	/* 통합신청상세조회 */
	@Override
	public GA01N101VO selectGA01N101(GA01N101VO vo) {
		return sqlSession.selectOne("rqsr_mapper.selectGA01N101", vo);
	}			 
    
	/* 인장신청_인감날인신청 신규등록 */	
    @Override
	public int insertGA01N504(GA01N504VO vo) {
		return sqlSession.insert("rqsr_mapper.insertGA01N504", vo);
	}	    
    /* 인장신청_인감날인신청 수정 */
    @Override
	public int updateGA01N504(GA01N504VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N504", vo);
	}	    
	/* 인장신청_인감날인신청 접수번호기준 삭제 */	
    @Override
	public int deleteGA01N504ByRctNo(GA01N504VO vo) {
		return sqlSession.delete("rqsr_mapper.deleteGA01N504ByRctNo", vo);
	}	    
	
	/* 인장신청_인감증명서신청 신규등록 */	
    @Override
	public int insertGA01N505(GA01N505VO vo) {
		return sqlSession.insert("rqsr_mapper.insertGA01N505", vo);
	}	    
    /* 인장신청_인감증명서신청 수정 */	
    @Override
	public int updateGA01N505(GA01N505VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N505", vo);
	}	    
	/* 인장신청_인감증명서신청 접수번호기준 삭제 */	
    @Override
	public int deleteGA01N505ByRctNo(GA01N505VO vo) {
		return sqlSession.delete("rqsr_mapper.deleteGA01N505ByRctNo", vo);
	}	    
	
	/* 통합신청기안문서 신규등록 */	
    @Override
	public int insertGA01N109(GA01N109VO vo) {
		return sqlSession.insert("rqsr_mapper.insertGA01N109", vo);
	}	    
	/* 통합신청기안문서 삭제 */	
    @Override
	public int deleteGA01N109(GA01N109VO vo) {
		return sqlSession.delete("rqsr_mapper.deleteGA01N109", vo);
	}
	/* 통합신청기안문서 접수번호기준 삭제 */	
    @Override
	public int deleteGA01N109ByRctNo(GA01N109VO vo) {
		return sqlSession.delete("rqsr_mapper.deleteGA01N109ByRctNo", vo);
	}
	
	/* 통합신청_신청관리 신규등록 */	
    @Override
	public int insertGA01N101(GA01N101VO vo) {
		return sqlSession.insert("rqsr_mapper.insertGA01N101", vo);
	}
	/* 통합신청_신청관리 수정 */	
    @Override
	public int updateGA01N101(GA01N101VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N101", vo);
	}
	/* 통합신청_신청관리 접수번호기준 삭제 */	
    @Override
	public int deleteGA01N101ByRctNo(GA01N101VO vo) {
		return sqlSession.delete("rqsr_mapper.deleteGA01N101ByRctNo", vo);
	}
	
	/* 결재정보상세_참조건_확인처리 */	
	@Override
	public int updateGA09N607ForCfmt(GA09N607VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA09N607ForCfmt", vo);
	}
	
	/* 인감날인증명서신청 건수 조회 */	
	@Override
	public RQSR1000U0Out05VO selectSalgSealDocCnt(String rctNo) {
		return sqlSession.selectOne("rqsr_mapper.selectSalgSealDocCnt", rctNo);
    }
	/* 인장날인 반려 건 자동 재신청 */
	@Override
	public int reApplyByRctNo(Map<String,Object> map)  {
		return sqlSession.insert("rqsr_mapper.reApplyByRctNo", map);
	}	
	
	/* 인장날인 재신청 - 인장날인 */
	@Override
	public int reApplyGA01N504(Map<String,Object> map)  {
		return sqlSession.insert("rqsr_mapper.reApplyGA01N504", map);
	}	
	/* 인장날인 재신청 - 증명서 */
	@Override
	public int reApplyGA01N505(Map<String,Object> map)  {
		return sqlSession.insert("rqsr_mapper.reApplyGA01N505", map);
	}
	
	/* 입고폐기관리 증명서유형 조회 */
	@Override
	public List<RQSR1000U0Out15VO> selectListSealDocPcd(){
		return sqlSession.selectList("rqsr_mapper.selectListSealDocPcd");
	}
	
    /* 순번 MAX,MIN값 조회*/
	@Override
	public GA01N510VO selectGA01N510MNo(GA01N510VO vo){
		return sqlSession.selectOne("rqsr_mapper.selectGA01N510MNo", vo);
	}
	
    /* 인감신청_인감증명서관리 신규등록*/
	@Override
	public int insertGA01N510(List<GA01N510VO> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return sqlSession.insert("rqsr_mapper.insertGA01N510", map);
	}
	
    /* 인감신청_인감증명서관리 폐기등록*/
	@Override
	public int updateGA01N510Dsus(GA01N510VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N510Dsus", vo);
	}
	
	/* 증명서번호 MAX값 조회 */
	@Override
	public String selectGA01N510MaxNo(GA01N510VO vo) {
		return sqlSession.selectOne("rqsr_mapper.selectGA01N510MaxNo", vo);
	}
	
	/* 입고/폐기관리 조회 */	
	@Override
	public List<RQSR1000U0Out19VO> selectListGA01N510(RQSR1000U0In19VO vo){
		return sqlSession.selectList("rqsr_mapper.selectListGA01N510", vo);
	}
	
	/* 입고/폐기관리 증명서잔고현황 조회 */	
	@Override
	public List<RQSR1000U0Out18VO> selectListGA01N510BalPstt(RQSR1000U0In19VO vo){
		return sqlSession.selectList("rqsr_mapper.selectListGA01N510BalPstt", vo);
	}
	/* 당일잔여수량 조회 */
	@Override
	public List<RQSR1000U0Out17VO> selectInfoGA01N510BalPstt(){
		return sqlSession.selectList("rqsr_mapper.selectInfoGA01N510BalPstt");
	}
	/* 인감증명서 신청여부*/
	@Override
	public int selectGA01N505ExistYn(String rctNo) {
		return sqlSession.selectOne("rqsr_mapper.selectGA01N505CtfwCnt", rctNo);
	}
	 /* 인감증명서 출력가능 여부 */
	@Override
	public boolean selectGA01N101SameDayYn(String rctNo) {
		return sqlSession.selectOne("rqsr_mapper.selectGA01N101SameDayYn", rctNo);
	}
    
	/* 인감증명서 출력가능수량 */
	@Override
	public int selectGA01N510AblCnt(RQSR1000U0In24VO vo) {
		return sqlSession.selectOne("rqsr_mapper.selectGA01N510AblCnt", vo);
	}
	/* 인감증명서 출력*/
	@Override
	public int updateGA01N510Oput(RQSR1000U0In24VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N510Oput", vo);
	}
	
	/* 등기부등본 출력*/
	@Override
	public int updateGA01N510CertDocOput(RQSR1000U0In24VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N510CertDocOput", vo);
	}
	
	/* 출고 - 출력후 미리보기 */
	@Override
	public List<RQSR1000U0Out24VO> selectGA01N510Oput(RQSR1000U0In24VO vo){
		return sqlSession.selectList("rqsr_mapper.selectGA01N510Oput", vo);
	}
	
	/* 인감증명서 재출력 */
	@Override
	public int updateGA01N510ReOput(RQSR1000U0In24VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N510ReOput", vo);
	}
	
	/* 인감증명서상세상태코드 수정 */
	@Override
	public int updateGA01N510DlScd(RQSR1000U0In01VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N510DlScd", vo);
	}
	/* 출고상세 재출력/폐기 조회  */
	@Override
	public List<RQSR1000U0Out23VO> selectListGA01N510Oput(RQSR1000U0In24VO vo){
		return sqlSession.selectList("rqsr_mapper.selectListGA01N510Oput", vo);
	}
	
	/* 재출력/폐기 - 폐기 */
	@Override
	public int updateGA01N510ReOputDsus(RQSR1000U0In26VO vo) {
		return sqlSession.update("rqsr_mapper.updateGA01N510ReOputDsus", vo);
	}
}

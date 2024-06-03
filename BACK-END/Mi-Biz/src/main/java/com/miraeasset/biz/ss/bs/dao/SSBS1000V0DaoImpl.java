package com.miraeasset.biz.ss.bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA01C001VO;
import com.miraeasset.biz.common.meta.vo.GA09N200VO;
import com.miraeasset.biz.common.meta.vo.GA09N201VO;
import com.miraeasset.biz.common.meta.vo.GA09N203VO;
import com.miraeasset.biz.common.meta.vo.GA09N204VO;
import com.miraeasset.biz.common.meta.vo.GA09N205VO;
import com.miraeasset.biz.common.meta.vo.GA09N208VO;
import com.miraeasset.biz.common.meta.vo.GA09N209VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS6000U0Out01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0In11VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS7100U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS9000V0Out00VO;

@Repository
public class SSBS1000V0DaoImpl implements SSBS1000V0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/* 사용자그룹 조회*/
	@Override
	public List<SSBS6000U0Out00VO> selectListGA09N200(SSBS6000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N200", vo);
	}   
	
	/* 사용자그룹 상세조회*/
	@Override
	public SSBS6000U0Out01VO selectGA09N200(SSBS6000U0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N200", vo);
	}   
	
	
	/* 사용자그룹 신규등록 */	
	public int insertGA09N200(GA09N200VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N200", vo);
	}    
		
	/* 사용자그룹 수정 */	
	public int updateGA09N200(GA09N200VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N200", vo);
	}    

	/* 사용자그룹 삭제 */	
	public int deleteGA09N200(GA09N200VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N200", vo);
	}    
	
	/* 사용자그룹_화면 목록조회*/
	@Override
	public List<SSBS7000U0Out00VO> selectListGA09N205(SSBS7000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N205", vo);
	}   
	
	/* 사용자그룹_화면 정상건 목록조회*/
	@Override
	public List<SSBS7000U0Out00VO> selectListGA09N205ByNrml(SSBS7000U0In11VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N205ByNrml", vo);
	}   
	
	/* 사용자그룹_화면 상세조회 PK */
	@Override
	public GA09N205VO selectGA09N205Pk(GA09N205VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N205Pk", vo);
	}   
	
	/* 사용자그룹_화면 신규등록 */	
	public int insertGA09N205(GA09N205VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N205", vo);
	}     
		
	/* 사용자그룹_화면 수정 */	
	public int updateGA09N205(GA09N205VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N205", vo);
	}     
    

    /* 화면관리 목록조회*/
	@Override
	public List<SSBS5000U0Out00VO> selectListGA09N204(SSBS5000U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N204", vo);
	}
	
    /* 화면관리 상세조회PK*/
	@Override
	public GA09N204VO selectGA09N204PK(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N204PK", vo);
	}
	
	/* 화면관리 신규등록 */	
	public int insertGA09N204(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N204", vo);
	}      
		
	/* 화면관리 수정 */	
	public int updateGA09N204(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N204", vo);
	}    
	
	/* 화면관리 삭제 */	
	public int deleteGA09N204(GA09N204VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N204", vo);
	}      
	
    /* 화면_담당사원 목록조회 화면ID 기준*/
	@Override
	public List<GA09N209VO> selectListGA09N209ByMenuId(GA09N209VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N209ByMenuId", vo);
	}
	
	/* 화면_담당사원 신규등록 */	
	public int insertGA09N209(GA09N209VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N209", vo);
	}      
    
	/* 화면_담당사원 삭제 화면ID 기준 */	
	public int deleteGA09N209ByMenuId(GA09N209VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N209ByMenuId", vo);
	}       
 
    /* 사용자그룹별 사용자관리 목록조회 */
	@Override
	public List<SSBS7100U0Out00VO> selectListGA09N201(SSBS7100U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N201", vo);
	}

    /* 사용자그룹별 사용자관리 정상기등록건 목록조회 */
	@Override
	public List<SSBS7100U0Out00VO> selectListGA09N201ByNrml(SSBS7100U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N201ByNrml", vo);
	}	

    /* 사용자그룹별 사용자관리 상세조회 PK */
	@Override
	public GA09N201VO selectGA09N201PK(GA09N201VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N201PK", vo);
	}	
	
	/* 사용자그룹별-사용자관리 신규등록 */	
	public int insertGA09N201(GA09N201VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N201", vo);
	}    	

	/* 사용자그룹별-사용자관리 수정 */	
	public int updateGA09N201(GA09N201VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("ssbs_mapper.updateGA09N201", vo);
	}
	
    /* 화면_검색키워드 내역조회  */
	@Override
	public List<GA09N208VO> selectListGA09N208VOByMenuId(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ssbs_mapper.selectListGA09N208VOByMenuId", vo);
	}	
	
    /* 화면_검색키워드 신규등록*/
	@Override
	public int insertGA09N208(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("ssbs_mapper.insertGA09N208", vo);
	}	

	/* 화면_검색키워드 삭제*/
	@Override
	public int deleteGA09N208(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N208", vo);
	}	

    /* 화면_검색키워드 삭제(화면id기준)*/
	@Override
	public int deleteGA09N208ByMenuId(GA09N208VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("ssbs_mapper.deleteGA09N208ByMenuId", vo);
	}	
    
	

}

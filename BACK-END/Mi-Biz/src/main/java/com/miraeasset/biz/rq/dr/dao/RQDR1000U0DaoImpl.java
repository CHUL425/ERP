package com.miraeasset.biz.rq.dr.dao;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.mybatis.spring.SqlSessionTemplate;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.rq.cr.vo.RQCR1000U01VO;
import com.miraeasset.biz.rq.dr.vo.*;


@Repository
public class RQDR1000U0DaoImpl implements RQDR1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;


	@Override
	public RQCR1000U01VO selectGA01N101(GA01N601VO vo) { return sqlSession.selectOne("rqdr_mapper.selectGA01N101", vo); }

	@Override
	public int insertGA01N601(GA01N601VO vo) {
		return sqlSession.insert("rqdr_mapper.insertGA01N601", vo);
	}

	@Override
	public int updateGA01N601(GA01N601VO vo) {
		return sqlSession.update("rqdr_mapper.updateGA01N601", vo);
	}


	@Override
	public GA01N601VO selectGA01N601(GA01N601VO vo) { return sqlSession.selectOne("rqdr_mapper.selectGA01N601", vo); }



	@Override
	public int insertGA01N602(GA01N602VO vo) {
		return sqlSession.insert("rqdr_mapper.insertGA01N602", vo);
	}


	@Override
	public int updateGA01N602BcdByBoxNo(GA01N602VO vo) { return sqlSession.update("rqdr_mapper.updateGA01N602BcdByBoxNo", vo); }


	@Override
	public int updateGA01N602BoxScdByRctNo(GA01N601VO vo) { return sqlSession.update("rqdr_mapper.updateGA01N602BoxScdByRctNo", vo); }


	@Override
	public int updateGA01N602byList(List<GA01N602VO> lstVo) {
		sqlSession.update("rqdr_mapper.updateGA01N602byList", lstVo);

		// 오라클 에서 -1 로 출력 중 이라서, 개선 예정
		return lstVo.size();
	}

	@Override
	public int insertGA01N603(GA01N601VO vo) { return sqlSession.insert("rqdr_mapper.insertGA01N603", vo); }

	@Override
	public int insertGA01N603byGA01N602(GA01N601VO vo) { return sqlSession.insert("rqdr_mapper.insertGA01N603byGA01N602", vo); }

	@Override
	public int deleteGA01N603n602(GA01N601VO vo) {
		return sqlSession.delete("rqdr_mapper.deleteGA01N603n602", vo);
	}


	@Override
	public int insertGA01N604byGA01N603(GA01N601VO vo) { return sqlSession.insert("rqdr_mapper.insertGA01N604byGA01N603", vo); }


	@Override
	public int updateGA01N604(GA01N602ModVO vo) {
		return sqlSession.update("rqdr_mapper.updateGA01N604", vo);
	}

	@Override
	public int updateGA01N604byGA01N602(GA01N601VO vo) { return sqlSession.update("rqdr_mapper.updateGA01N604byGA01N602", vo); }



	@Override
	public GA01N601SchVO selectGA01N601AndN101_Cnt(GA01N601SchVO vo) { return sqlSession.selectOne("rqdr_mapper.selectGA01N601AndN101_Cnt", vo); }

	@Override
	public List<GA01N601SchVO> selectGA01N601AndN101(GA01N601SchVO vo) {
		if(vo.getPageNum() < 1){ vo.setPageNum(1); }
		if(vo.getPageSize() < 1){ vo.setPageSize(50); }

		return sqlSession.selectList("rqdr_mapper.selectGA01N601AndN101", vo);
	}

	@Override
	public Map<String, Object> selectGA01N601AndN101_RqsStat(GA01N601SchVO vo) {
		return sqlSession.selectOne("rqdr_mapper.selectGA01N601AndN101_RqsStat", vo);
	}



	@Override
	public GA01N602SchVO selectGA01N602Sch_Cnt(GA01N602SchVO vo) {
		try{
			return sqlSession.selectOne("rqdr_mapper.selectGA01N602Sch_Cnt", vo);
		} catch(Exception ex) {
			throw new CustomBadRequestException("잘못 된 입력값 입니다_" + ex.getMessage(), ErrorCode.BAD_REQUEST);
		}
	}

	@Override
	public List<GA01N602SchVO> selectGA01N602Sch(GA01N602SchVO vo) {
		if(vo.getPageNum() < 1){ vo.setPageNum(1); }
		if(vo.getPageSize() < 1){ vo.setPageSize(50); }

		return sqlSession.selectList("rqdr_mapper.selectGA01N602Sch", vo);
	}

	@Override
	public Map<String, Object> selectGA01N602Sch_RqsStat(GA01N602SchVO vo) {
		return sqlSession.selectOne("rqdr_mapper.selectGA01N602Sch_RqsStat", vo);
	}


	@Override
	public List<GA01N602VO> selectGA01N602byRctNo(GA01N602VO vo) { return sqlSession.selectList("rqdr_mapper.selectGA01N602byRctNo", vo); }


	@Override
	public List<GA01N602VO> selectGA01N602byRctNoToExcel(GA01N602VO vo) { return sqlSession.selectList("rqdr_mapper.selectGA01N602byRctNoToExcel", vo); }


	@Override
	public Map<String,Object> selectCB01N310byMenuId(Map<String,Object> map) { return sqlSession.selectOne("rqdr_mapper.selectCB01N310byMenuId", map); }



	@Override
	public int insertGA01N601ReApplyByRctNo(Map<String,Object> map) { return sqlSession.insert("rqdr_mapper.insertGA01N601ReApplyByRctNo", map); }


	@Override
	public int deleteGA01N603n604(GA01N601VO vo) {
		return sqlSession.delete("rqdr_mapper.deleteGA01N603n604", vo);
	}


	@Override
	public int deleteGA01N601(GA01N601VO vo) {
		return sqlSession.update("rqdr_mapper.deleteGA01N601", vo);
	}


	@Override
	public List<GA01N602SchVO> selectGA01N604SchByRctNo(GA01N602SchVO vo) {
		if(vo.getPageNum() < 1){ vo.setPageNum(1); }
		if(vo.getPageSize() < 1){ vo.setPageSize(50); }

		return sqlSession.selectList("rqdr_mapper.selectGA01N604SchByRctNo", vo);
	}

	@Override
	public Map<String,Object> selectGA01N603ValidationCnt(GA01N601VO vo) { return sqlSession.selectOne("rqdr_mapper.selectGA01N603ValidationCnt", vo); }

}

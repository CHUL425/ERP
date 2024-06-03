/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS7100U0DaoImpl.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 사용자그룹별 사용자관리 DaoImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.dao;

import java.util.List;
import java.util.Map;

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
public class SSBS7100U0DaoImpl implements SSBS7100U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

 
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
	
    /* 사용자그룹별 사용자관리 상세조회(접수번호기준)*/
	@Override
	public GA09N201VO selectGA09N201ByRecNo(GA09N201VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ssbs_mapper.selectGA09N201ByRecNo", vo);
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
	
	/* 사용자그룹별-사용자관리 반려 건 자동 재신청 */
	public int reApplyByRctNo(Map<String,Object> map)  {
		return sqlSession.insert("ssbs_mapper.reApplyByRctNo7100", map);
	}		
	

}

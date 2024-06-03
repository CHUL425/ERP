package com.miraeasset.biz.common.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.miraeasset.biz.common.meta.vo.CB01N112VO;
import com.miraeasset.biz.common.meta.vo.CB01N210VO;
import com.miraeasset.biz.common.meta.vo.CB01N310VO;
import com.miraeasset.biz.common.vo.GA09N502VO;
import com.miraeasset.biz.common.vo.GA09N503In00VO;
import com.miraeasset.biz.common.vo.GA09N503VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.vo.FileVO;

@Repository
public class CommonDaoImpl implements CommonDao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;


	@Override
	public String selectFileGuid() {
		return sqlSession.selectOne("file_mapper.select_file_guid");
	}

	@Override
	public String selectNewFileNo() {
		return sqlSession.selectOne("file_mapper.selectNewFileNo");
	}
	@Override
	public String selectNewFileDlNo(FileVO vo) {
		return sqlSession.selectOne("file_mapper.selectNewFileDlNo", vo);
	}
    
	@Override
	public int updateGA09N411(GA09N411VO vo) {
		return sqlSession.update("file_mapper.updateGA09N411", vo);
	}
	
	@Override
	public int updateImgGA09N411(GA09N411VO vo) {
		return sqlSession.update("file_mapper.updateImgGA09N411", vo);
	}

	@Override
	public int updateDelGA09N411(GA09N411VO vo) {
		return sqlSession.update("file_mapper.updateDelGA09N411", vo);
	}	
	
	@Override
	public int updateSa09n013(FileVO vo) {
		return sqlSession.update("file_mapper.update_sa09n013", vo);
	}

	@Override
	public int updateFileChaebun(FileVO vo) {
		return sqlSession.update("file_mapper.updateFileChaebun", vo);
	}
    
	@Override
	public int updateFileChaebun(String fileNo) {
		return sqlSession.update("file_mapper.updateFileChaebun", fileNo);
	}
	
	@Override
	public List<Map<String, Object>> selectSa09n013ByKey(FileVO vo) {
		return sqlSession.selectList("file_mapper.select_sa09n013_by_key", vo);
	}

	@Override
	public FileVO selectSa09n013ByAtcFileGuid(FileVO vo) {
		return sqlSession.selectOne("file_mapper.select_sa09n013_by_atcFileGuid", vo);
	}


	@Override
	public int updateSa09n013ByDelYn(FileVO vo) {
		return sqlSession.update("file_mapper.update_sa09n013_by_delYn", vo);
	}

	@Override
	public Map<String, Object> selectSa09n013ByAtcFileGuidCount(FileVO vo) {
		return sqlSession.selectOne("file_mapper.select_sa09n013_by_atcFileGuid_count", vo);
	}

	@Override
	public FileVO selectFile(FileVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("file_mapper.selectFile", vo);
	}

	@Override
	public GA09N411VO selectGA09N411PK(GA09N411VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("file_mapper.selectGA09N411PK", vo);
	}		
	
	@Override
	public GA09N411VO selectImgGA09N411PK(GA09N411VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("file_mapper.selectImgGA09N411PK", vo);
	}		
	
	/* 첨부파일 목록조회 */
	@Override
	public List<GA09N411VO> selectListGA09N411(GA09N411VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("file_mapper.selectListGA09N411", vo);
	}		

	/* 첨부파일 목록조회_이름검색 */
	@Override
	public List<GA09N411VO> selectListGA09N411ByName(GA09N411VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("file_mapper.selectListGA09N411ByName", vo);
	}
	
	/* 이미지 파일 등록 */
	@Override
	public int updateImgFile(GA09N411VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("file_mapper.updateImgFile", vo);
	}

	/* 파일정보상세_ERP */
	@Override
	public GA09N411VO selectOneAT09N411(GA09N411VO vo) {
		return sqlSession.selectOne("file_mapper.selectOneAT09N411", vo);
	}

	/* 파일목록조회_ERP */
	@Override
	public List<GA09N411VO> selectListAT09N411(GA09N411VO vo) {
		return sqlSession.selectList("file_mapper.selectListAT09N411", vo);
	}

	/* 메신저, 이메일, 알림톡 발송 로그 등록 */
	@Override
	public int insertGA09N502(GA09N502VO vo) {
		return sqlSession.insert("post_mapper.insertGA09N502", vo);
	}


	/* Next 승인자, 사전 참조 알림 */
	@Override
	public List<Map<String, Object>> selectApvNotiAlmAlt(Map<String, Object> map) {
		return sqlSession.selectList("altok_mapper.selectApvNotiAlmAlt", map);
	}

	@Override
	public String selectGA09N503CrnSrno(String crnDt) {
		return sqlSession.selectOne("post_mapper.selectGA09N503CrnSrno", crnDt);
	}

	@Override
	public int insertGA09N503(GA09N503VO vo) {
		return sqlSession.insert("post_mapper.insertGA09N503", vo);
	}

	@Override
	public String checkBzD5Yn(String basDt) {
		return sqlSession.selectOne("code_mapper.checkBzD5Yn", basDt);
	}

	@Override
	public String findHrOsdtCdNmOrHrPstCdNmByEpno(String epno) {
		/* 직책명 확인 */
		String result = sqlSession.selectOne("code_mapper.findHrOsdtCdNmByEpno", epno);
		/* 직책명 없는 경우 직위명 확인 */
		if(result == null || result.equals("")) {
			result = sqlSession.selectOne("code_mapper.findHrPstCdNmByEpno", epno);
		}
		return result;
	}

	@Override
	public List<GA09N503VO> selectListGA09N503(GA09N503In00VO ga09N503In00VO) {
		return sqlSession.selectList("post_mapper.selectListGA09N503", ga09N503In00VO);
	}

	@Override
	public int updateGA09N503(GA09N503VO ga09N503VO) {
		return sqlSession.update("post_mapper.updateGA09N503", ga09N503VO);
	}

	@Override
	public String getEpTlno(String epno) {
		return sqlSession.selectOne("post_mapper.getEpTlno", epno);
	}


	@Override
	public CB01N112VO selectOneCB01N112ByHrNewOrzCd(String hrNewOrzCd) {
		return sqlSession.selectOne("common_mapper.selectOneCB01N112ByHrNewOrzCd", hrNewOrzCd);
	}

	@Override
	public CB01N210VO selectOneCB01N210ByOrzCd(String orzCd) {
		return sqlSession.selectOne("common_mapper.selectOneCB01N210ByOrzCd", orzCd);
	}

	@Override
	public CB01N310VO selectOneCB01N310ByEpno(String epno) {
		return sqlSession.selectOne("common_mapper.selectOneCB01N310ByEpno", epno);
	}
}
package com.miraeasset.biz.common.service;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.meta.vo.CB01N112VO;
import com.miraeasset.biz.common.meta.vo.CB01N210VO;
import com.miraeasset.biz.common.meta.vo.CB01N310VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.vo.FileVO;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

	@Autowired
	CommonDao commonDao;

	@Override
	public String selectFileGuid() { return commonDao.selectFileGuid(); }

	
	@Override
	public String selectNewFileNo() { return commonDao.selectNewFileNo(); }
        
	@Override
	public String selectNewFileDlNo(FileVO vo) { return commonDao.selectNewFileDlNo(vo); }

	@Override
	public int updateGA09N411(GA09N411VO vo) {
		return commonDao.updateGA09N411(vo);
	}
	
	@Override
	public int updateImgGA09N411(GA09N411VO vo) {
		return commonDao.updateImgGA09N411(vo);
	}
		
	public int updateImgFile(GA09N411VO vo) {
		return commonDao.updateImgFile(vo);
	}

	/* 첨부파일 삭제 = 사용여부 세팅 */
	@Override
	public int updateDelGA09N411(GA09N411VO vo){
		return commonDao.updateDelGA09N411(vo);
	}
	
	@Override
	public int updateSa09n013(FileVO vo) {
		return commonDao.updateSa09n013(vo);
	}
	
	@Override
	public int updateFileChaebun(FileVO vo) {
		return commonDao.updateFileChaebun(vo);
	}
	
	@Override
	public int updateFileChaebun(String fileNo) {
		return commonDao.updateFileChaebun(fileNo);
	}
    

	@Override
	public List<Map<String, Object>> selectSa09n013ByKey(FileVO vo) {
		return commonDao.selectSa09n013ByKey(vo);
	}

	@Override
	public FileVO selectSa09n013ByAtcFileGuid(FileVO vo) {
		return commonDao.selectSa09n013ByAtcFileGuid(vo);
	}

	@Override
	public int updateSa09n013ByDelYn(FileVO vo) {
		return commonDao.updateSa09n013ByDelYn(vo);
	}


	@Override
	public Map<String, Object> selectSa09n013ByAtcFileGuidCount(FileVO vo) {
		return commonDao.selectSa09n013ByAtcFileGuidCount(vo);
	}


	@Override
	public FileVO selectFile(FileVO vo) {
		// TODO Auto-generated method stub
		return commonDao.selectFile(vo);
	}

	/* 첨부파일정보조회 */	    
	@Override
	public GA09N411VO selectGA09N411PK(GA09N411VO vo) {
		// TODO Auto-generated method stub
		return commonDao.selectGA09N411PK(vo);
	}		
	
	/* 첨부파일 목록조회 */	    
	@Override
	public List<GA09N411VO> selectListGA09N411(GA09N411VO vo) {
		// TODO Auto-generated method stub
		return commonDao.selectListGA09N411(vo);
	}

	@Override
	public List<GA09N411VO> selectListGA09N411ByName(GA09N411VO vo) {
		return commonDao.selectListGA09N411ByName(vo);
	}

	/* 파일정보상세_ERP */
	@Override
	public GA09N411VO selectOneAT09N411(GA09N411VO vo) {
		return commonDao.selectOneAT09N411(vo);
	}

	/* 파일목록조회_ERP */
	@Override
	public List<GA09N411VO> selectListAT09N411(GA09N411VO vo) {
		return commonDao.selectListAT09N411(vo);
	}

	@Override
	public CB01N112VO selectOneCB01N112ByHrNewOrzCd(String hrNewOrzCd) {
		return commonDao.selectOneCB01N112ByHrNewOrzCd(hrNewOrzCd);
	}

	@Override
	public CB01N210VO selectOneCB01N210ByOrzCd(String orzCd) {
		return commonDao.selectOneCB01N210ByOrzCd(orzCd);
	}

	@Override
	public CB01N310VO selectOneCB01N310ByEpno(String epno) {
		return commonDao.selectOneCB01N310ByEpno(epno);
	}
}

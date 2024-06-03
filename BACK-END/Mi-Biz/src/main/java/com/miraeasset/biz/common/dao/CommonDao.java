package com.miraeasset.biz.common.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.meta.vo.CB01N112VO;
import com.miraeasset.biz.common.meta.vo.CB01N210VO;
import com.miraeasset.biz.common.meta.vo.CB01N310VO;
import com.miraeasset.biz.common.meta.vo.GA09N411VO;
import com.miraeasset.biz.common.vo.FileVO;
import com.miraeasset.biz.common.vo.GA09N502VO;
import com.miraeasset.biz.common.vo.GA09N503In00VO;
import com.miraeasset.biz.common.vo.GA09N503VO;

public interface CommonDao {

    String selectFileGuid();

    String selectNewFileNo();
    
    String selectNewFileDlNo(FileVO vo);    
    
    int updateGA09N411(GA09N411VO vo);
    
    int updateImgGA09N411(GA09N411VO vo);    
    
	int updateDelGA09N411(GA09N411VO vo);

    int updateSa09n013(FileVO vo);
    
    int updateFileChaebun(FileVO vo);
    
    int updateFileChaebun(String fileNo);        
    
    List<Map<String, Object>> selectSa09n013ByKey(FileVO vo);

    FileVO selectSa09n013ByAtcFileGuid(FileVO vo);
    FileVO selectFile(FileVO vo);
    
    int updateSa09n013ByDelYn(FileVO vo);

    Map<String, Object> selectSa09n013ByAtcFileGuidCount(FileVO vo);
    
	/* 첨부파일정보조회 */	    
	GA09N411VO selectGA09N411PK(GA09N411VO vo);  
	
	/* 첨부파일정보조회 */	    
	GA09N411VO selectImgGA09N411PK(GA09N411VO vo);  	
	
	/* 첨부파일 목록조회 */
	List<GA09N411VO> selectListGA09N411(GA09N411VO vo);  
	
	/* 첨부파일 목록조회_이름검색 */
	List<GA09N411VO> selectListGA09N411ByName(GA09N411VO vo);
	
	/* 이미지 파일 등록 */
	int updateImgFile(GA09N411VO vo);

    /* 파일정보상세_ERP */
    GA09N411VO selectOneAT09N411(GA09N411VO vo);

    /* 파일목록조회_ERP */
    List<GA09N411VO> selectListAT09N411(GA09N411VO vo);

    int insertGA09N502(GA09N502VO vo);

    List<Map<String, Object>> selectApvNotiAlmAlt(Map<String, Object> map);

    String selectGA09N503CrnSrno(String crnDt);

    int insertGA09N503(GA09N503VO vo);

    String checkBzD5Yn(String basDt);

    String findHrOsdtCdNmOrHrPstCdNmByEpno(String epno);

    List<GA09N503VO> selectListGA09N503(GA09N503In00VO ga09N503In00VO);

    int updateGA09N503(GA09N503VO ga09N503VO);

    String getEpTlno(String epno);

    CB01N112VO selectOneCB01N112ByHrNewOrzCd(String hrNewOrzCd);
    CB01N210VO selectOneCB01N210ByOrzCd(String orzCd);
    CB01N310VO selectOneCB01N310ByEpno(String epno);

}

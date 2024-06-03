package com.miraeasset.biz.sh.an.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.miraeasset.biz.bn.gn.dao.BNGN1000U0Dao;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.meta.vo.GA09N421VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.sh.an.dao.SHAN1000U0Dao;
import com.miraeasset.biz.sh.an.dao.SHAN3000U0Dao;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out01VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out02VO;
import com.miraeasset.biz.sh.an.vo.SHAN1000U0Out03VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0In01VO;
import com.miraeasset.biz.sh.an.vo.SHAN3000U0Out01VO;

@Service
@Transactional
public class SHAN1000U0ServiceImpl implements SHAN1000U0Service {

	@Autowired
	SHAN1000U0Dao SHAN1000U0Dao;
	
	@Autowired
	SHAN3000U0Dao SHAN3000U0Dao;
	
	@Autowired
	BNGN1000U0Dao BNGN1000U0Dao;
	
	@Autowired
	CommonDao commonDao;
			
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	/* 안전보건공지 신규등록 */	
	@Override
	public int insertGA09N421Sh(SHAN1000U0In00VO vo) {

		int cnt = 0;
		GA09N421VO GA09N421VO = new GA09N421VO(); 
		String regiDt = DateUtil.getTodayString("yyyyMMdd");	
		BigDecimal srno = new BigDecimal("0");
		
		// 전처리 : 입력값 체크 
		{
			if(vo.getMadeEpno()== null || vo.getMadeEpno().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[작성자입력] 오류. 입력값을 확인하세요["+vo.getMadeEpno()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(!"03".equals(vo.getCmklTcd())){
				throw new CustomBadRequestException("정합성 체크오류. 공지구분코드는 03 만 입력가능합니다. 입력값을 확인하세요 ["+vo.getCmklTcd()+"]", ErrorCode.BAD_REQUEST);	
			}
			if(vo.getTtlNm()== null || vo.getTtlNm().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[제목입력] 오류. 입력값을 확인하세요["+vo.getTtlNm()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getPstupStrtDt()== null || vo.getPstupStrtDt().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[확인시작일자] 오류. 입력값을 확인하세요["+vo.getPstupStrtDt()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getPstupEndDt()== null || vo.getPstupEndDt().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[확인종료일자] 오류. 입력값을 확인하세요["+vo.getPstupEndDt()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getFileNo()== null || vo.getFileNo().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[파일첨부] 오류. 입력값을 확인하세요["+vo.getFileNo()+"]", ErrorCode.BAD_REQUEST);		
			}
			if(vo.getBlbdImgFileNo()== null || vo.getBlbdImgFileNo().equals("") ) {
		        throw new CustomBadRequestException("필수입력항목[게시판이미지첨부파일] 오류. 입력값을 확인하세요["+vo.getBlbdImgFileNo()+"]", ErrorCode.BAD_REQUEST);		
			}
			
			if(!isEndDateBig(vo.getPstupStrtDt(), vo.getPstupEndDt())) {
				throw new CustomBadRequestException("입력항목[확인일자] 오류. ["+vo.getPstupStrtDt()+"]>["+vo.getPstupEndDt()+"]", ErrorCode.BAD_REQUEST);
			}
			
			ObjectCopyUtil.copyFields(vo, GA09N421VO);
			
			// 신규 세팅
			GA09N421VO.setMadeDt(regiDt);
			srno = BNGN1000U0Dao.selectNewSrno(GA09N421VO);
			GA09N421VO.setSrno(srno);
			GA09N421VO.setQryCnt(BigDecimal.ZERO);
			GA09N421VO.setDelYn("0");
			GA09N421VO.setPstgFxdYn("0");
		}
		
		// 신규 처리
		{
			cnt = SHAN1000U0Dao.insertGA09N421Sh(GA09N421VO);
		}
		
		return cnt;
	}	
	
	/* 안전보건공지 조회 */	
    public List<SHAN1000U0Out01VO> selectListGA09N421Sh(SHAN1000U0In01VO vo){
    	return SHAN1000U0Dao.selectListGA09N421Sh(vo);
    }
    
	/* 안전보건공지 조회 */	
    public SHAN3000U0Out01VO selectInfoGA09N421Sh(SHAN3000U0In01VO vo) {

        // 조회수 증가
	    {
	    	GA09N421VO GA09N421VO = new GA09N421VO();
			ObjectCopyUtil.copyFields(vo, GA09N421VO);
		    int cnt = BNGN1000U0Dao.updateQryCnt(GA09N421VO); 
	    }
	    
	    // 안전보건공지 확인 SHAN3000 동일한 조회쿼리 사용중인데, EPNO 없을때 게시일자 체크 안함.
	    vo.setEpno(null);
	    
    	return SHAN3000U0Dao.selectShanCfmtDlCn(vo);
    }
    
    /* 안전보건공지 삭제전 확인이력존재여부 조회 */	
    public SHAN1000U0Out02VO selectShanCfmtHst(SHAN3000U0In01VO vo) {
    	return SHAN1000U0Dao.selectShanCfmtHst(vo);
    }

    /* 안전보건공지 초기화면 팝업조회 */	
	@Override
	public SHAN1000U0Out03VO selectShanInitPopup(HttpServletRequest request) {
		
		LoginOutVO loginVO = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		String epno = loginVO.getEpno();
		
		return SHAN1000U0Dao.selectShanInitPopup(epno);
	}
	
	/* 확인일 비교*/	
	public boolean isEndDateBig(String startDt, String endDt){
		
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		
		try {
			Date dtStart = f.parse(startDt);
			Date dtEnd = f.parse(endDt);
			
			if(dtEnd.before(dtStart)) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			throw new CustomBadRequestException("확인일 비교 오류", ErrorCode.BAD_REQUEST);
		}
	}
}

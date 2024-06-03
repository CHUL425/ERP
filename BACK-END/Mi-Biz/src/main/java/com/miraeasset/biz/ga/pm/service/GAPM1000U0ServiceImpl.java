package com.miraeasset.biz.ga.pm.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA01N203VO;
import com.miraeasset.biz.common.service.CommonService;
import com.miraeasset.biz.common.util.ConvertUtils;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.ga.pm.dao.GAPM1000U0Dao;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In02VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In03VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0In10VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out00VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out01VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out10VO;
import com.miraeasset.biz.ga.pm.vo.GAPM1000U0Out11VO;

import io.swagger.annotations.ApiModelProperty;


@Service
@Transactional
public class GAPM1000U0ServiceImpl implements GAPM1000U0Service {

    @Autowired
    GAPM1000U0Dao GAPM1000U0Dao;

    @Autowired
    CommonService commonService;

    @Autowired
    CodeDao CodeDao;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /* APRV_PCD 코드값 정의 */
    private final String CD_APRV_PCD_RENT = "01"; // 렌탈신청
    private final String CD_APRV_PCD_PCH = "02"; // 구매신청

    /* APRV_SCD 코드값 정의 */
    private final String CD_APRV_SCD_RCT = "01"; // 접수
    private final String CD_APRV_SCD_APRVING = "02"; // 결재중
    private final String CD_APRV_SCD_RTRN = "03"; // 반려
    private final String CD_APRV_SCD_APV = "04"; // 승인완료

    /* APRV_RTRN_TCD  코드값 정의 */
    private final String CD_APRV_RTRN_TCD_RCT = "1"; // 접수/승인
    private final String CD_APRV_RTRN_TCD_RTRN = "2"; // 반려
    private final String CD_APRV_RTRN_TCD_REF = "3"; // 참조

    /* DCFC_PCD  코드값 정의 */
    private final String CD_DCFC_PCD_APRV = "01"; // 결재
    private final String CD_DCFC_PCD_REF = "02"; // 참조

    /* APRV_WRRPT_TCD   코드값 정의 */
    private final String APRV_WRRPT_TCD_DRWR = "0"; // 작성자
    private final String APRV_WRRPT_TCD_DCFC = "1"; // 결제자
    private final String APRV_WRRPT_TCD_RCTR = "2"; // 접수자
    private final String APRV_WRRPT_TCD_STDY = "3"; // 검토자
    private final String APRV_WRRPT_TCD_APVR = "4"; // 승인자

    /* RQS_CD 코드값 정의 */
    private final String CD_RQS_SCD_TMP_STRG = "01"; // 임시저장
    private final String CD_RQS_SCD_APV_ING = "02"; // 승인중
    private final String CD_RQS_SCD_APV_CMPN = "03"; // 승인완료
    private final String CD_RQS_SCD_CMPN = "04"; // 완료
    private final String CD_RQS_SCD_RTRN = "05"; // 반려
    private final String CD_RQS_SCD_WDRAL = "06"; // 철회


    /* 정기주차권관리 목록조회 */
    @Override
    public List<GAPM1000U0Out00VO> selectListGA01N203(GAPM1000U0In00VO vo) {
        return GAPM1000U0Dao.selectListGA01N203(vo);
    }

    /* 정기주차권관리 상세정보조회(PK) */
    @Override
    public List<GAPM1000U0Out01VO> selectGA01N203PK(GAPM1000U0In01VO vo) {
        return GAPM1000U0Dao.selectGA01N203PK(vo);
    }

    /* 정기주차권관리 수정(PK) */
    @Override
    public int updateGA01N203(GAPM1000U0In02VO vo) {
        int cnt = 0;
        GA01N203VO GA01N203VO = new GA01N203VO();
        GAPM1000U0In01VO GAPM1000U0In01VO = new GAPM1000U0In01VO();
        List<GAPM1000U0Out01VO> outList = null;
        
        List<GAPM1000U0Out11VO> parkCntInfoList = null;
        GAPM1000U0Out11VO GAPM1000U0Out11VO = null;
    	BigDecimal freeParkCnt = BigDecimal.ZERO     ; /* 무료주차대수 */		   
    	BigDecimal paidParkCnt = BigDecimal.ZERO     ; /* 유료주차대수 */
    	BigDecimal allParkCnt  = BigDecimal.ZERO     ; /* 전체주차대수 */
    	BigDecimal freePsesCnt = BigDecimal.ZERO     ; /* 무료사용대수 */		   
    	BigDecimal paidPsesCnt = BigDecimal.ZERO     ; /* 유료사용대수 */
    	BigDecimal allPsesCnt  = BigDecimal.ZERO     ; /* 전체사용대수 */
    	BigDecimal freeAblCnt  = BigDecimal.ZERO     ; /* 무료가능대수 = 무료주차대수 - 무료사용대수 */
    	BigDecimal paidAblCnt  = BigDecimal.ZERO     ; /* 유료가능대수 = 유료주차대수 - 유료사용대수 */
    	String bfChfTcd = null;	/*변경전 유료무료구분코드 01:무료 02:유료 */
    	String afChfTcd = null;	/*변경후 유료무료구분코드 01:무료 02:유료 */

        // 전처리 : 입력값 체크
        {
        	afChfTcd = vo.getChfTcd();
        	
            if (vo.getVhcNo() == null || vo.getVhcNo().equals("")) {
                throw new CustomBadRequestException("필수입력항목[차량번호] 오류. 입력값을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }

            ObjectCopyUtil.copyFields(vo, GAPM1000U0In01VO);
            outList = GAPM1000U0Dao.selectGA01N203PK(GAPM1000U0In01VO);

            if (outList != null && outList.size() > 0) {
                ObjectCopyUtil.copyFields(outList.get(0), GA01N203VO);

                if (GA01N203VO.getVhcNo() == null || GA01N203VO.getVhcNo().equals("")) {
                    throw new CustomBadRequestException("변경할 대상건이 없습니다2. 입력항목을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
                }
                bfChfTcd = GA01N203VO.getChfTcd();

            } else {
                throw new CustomBadRequestException("변경할 대상건이 없습니다1. 입력항목을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }
            
            
            // 유료무료 추자 가능대수 체크
            {
            	// 변경전후 유무료주차코드 상이할경우 주차가능대수 체크
            	if(!bfChfTcd.equals(afChfTcd)){
                	parkCntInfoList = GAPM1000U0Dao.selectParkCntInfo();
                	
                	if(parkCntInfoList!= null && parkCntInfoList.size() > 0 ) {
                		GAPM1000U0Out11VO = parkCntInfoList.get(0);
                    	freeParkCnt = GAPM1000U0Out11VO.getFreeParkCnt()     ; /* 무료주차대수 */		   
                    	paidParkCnt = GAPM1000U0Out11VO.getPaidParkCnt()     ; /* 유료주차대수 */
                    	allParkCnt  = GAPM1000U0Out11VO.getAllParkCnt()      ; /* 전체주차대수 */
                    	freePsesCnt = GAPM1000U0Out11VO.getFreePsesCnt()     ; /* 무료사용대수 */		   
                    	paidPsesCnt = GAPM1000U0Out11VO.getPaidPsesCnt()     ; /* 유료사용대수 */
                    	allPsesCnt  = GAPM1000U0Out11VO.getAllPsesCnt()      ; /* 전체사용대수 */     
                    	
                    	freeAblCnt  = freeParkCnt.subtract(freePsesCnt)  ; /* 무료가능대수 = 무료주차대수 - 무료사용대수 */
                    	paidAblCnt  = paidParkCnt.subtract(paidPsesCnt)  ; /* 유료가능대수 = 유료주차대수 - 유료사용대수 */ 
                    	
                    	log.info(GAPM1000U0Out11VO.toString());
                    	
                    	if(freeAblCnt.compareTo(BigDecimal.ZERO) < 0 ) {
                    		freeAblCnt = BigDecimal.ZERO;
                    	}
                    	if(paidAblCnt.compareTo(BigDecimal.ZERO) < 0 ) {
                    		paidAblCnt = BigDecimal.ZERO;
                    	}
                	}
                	
                	// 무료 추차가능 체크
                	if(afChfTcd.equals("01")) {
                		if(freeAblCnt.compareTo(BigDecimal.ZERO) <= 0) {
                            throw new CustomBadRequestException("무료주차 가능대수가 없습니다. 주차가능대수를 확인하세요 [" + freeAblCnt + "]", ErrorCode.BAD_REQUEST);
                		}
                		
                	}
                	// 유료 주차가능 체크
                	if(afChfTcd.equals("02")) {
                		if(paidAblCnt.compareTo(BigDecimal.ZERO) <= 0) {
                            throw new CustomBadRequestException("유료주차 가능대수가 없습니다. 주차가능대수를 확인하세요 [" + paidAblCnt + "]", ErrorCode.BAD_REQUEST);
                		}
                	}            		
            	}
            }            
        }

        // 수정처리
        {
            // 데이터 카피
            ObjectCopyUtil.copyFields(vo, GA01N203VO);

//			GA01N203VO.setOptrId("000000");
//			GA01N203VO.setOprtChnlCd("000");
//			GA01N203VO.setOprtOrzCd("000000");
//			GA01N203VO.setOprtIpAdr("000000");

            cnt = GAPM1000U0Dao.updateGA01N203(GA01N203VO);

            if (cnt == 0) {
                throw new CustomBadRequestException("정기주차권관리 수정오류. 입력값을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }
        }

        return cnt;
    }

    /* 정기주차권관리 삭제 */
    @Override
    public int deleteGA01N203(GAPM1000U0In02VO vo) {
        int cnt = 0;
        GA01N203VO GA01N203VO = new GA01N203VO();
        GAPM1000U0In01VO GAPM1000U0In01VO = new GAPM1000U0In01VO();
        List<GAPM1000U0Out01VO> outList = null;

        // 전처리 : 입력값 체크
        {
            if (vo.getVhcNo() == null || vo.getVhcNo().equals("")) {
                throw new CustomBadRequestException("필수입력항목[차량번호] 오류. 입력값을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }

            ObjectCopyUtil.copyFields(vo, GAPM1000U0In01VO);
            outList = GAPM1000U0Dao.selectGA01N203PK(GAPM1000U0In01VO);

            if (outList != null && outList.size() > 0) {
                ObjectCopyUtil.copyFields(outList.get(0), GA01N203VO);

                if (GA01N203VO.getVhcNo() == null || GA01N203VO.getVhcNo().equals("")) {
                    throw new CustomBadRequestException("삭제할 대상건이 없습니다2. 입력항목을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
                }
            } else {
                throw new CustomBadRequestException("삭제할 대상건이 없습니다1. 입력항목을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }
        }

        // 삭제처리
        {
            // 데이터 카피
            ObjectCopyUtil.copyFields(vo, GA01N203VO);

//			GA01N203VO.setOptrId("000000");
//			GA01N203VO.setOprtChnlCd("000");
//			GA01N203VO.setOprtOrzCd("000000");
//			GA01N203VO.setOprtIpAdr("000000");

            cnt = GAPM1000U0Dao.deleteGA01N203(GA01N203VO);

            if (cnt == 0) {
                throw new CustomBadRequestException("정기주차권관리 삭제오류. 입력값을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }
        }

        return cnt;
    }

    /* 정기주차권관리 신규등록 */
    @Override
    public int insertGA01N203(GAPM1000U0In03VO vo) {
        int cnt = 0;
        GA01N203VO GA01N203VO = new GA01N203VO();
        GAPM1000U0In01VO GAPM1000U0In01VO = new GAPM1000U0In01VO();
        List<GAPM1000U0Out01VO> outList = null;

        List<GAPM1000U0Out11VO> parkCntInfoList = null;
        GAPM1000U0Out11VO GAPM1000U0Out11VO = null;
    	BigDecimal freeParkCnt = BigDecimal.ZERO     ; /* 무료주차대수 */		   
    	BigDecimal paidParkCnt = BigDecimal.ZERO     ; /* 유료주차대수 */
    	BigDecimal allParkCnt  = BigDecimal.ZERO     ; /* 전체주차대수 */
    	BigDecimal freePsesCnt = BigDecimal.ZERO     ; /* 무료사용대수 */		   
    	BigDecimal paidPsesCnt = BigDecimal.ZERO     ; /* 유료사용대수 */
    	BigDecimal allPsesCnt  = BigDecimal.ZERO     ; /* 전체사용대수 */
    	BigDecimal freeAblCnt  = BigDecimal.ZERO     ; /* 무료가능대수 = 무료주차대수 - 무료사용대수 */
    	BigDecimal paidAblCnt  = BigDecimal.ZERO     ; /* 유료가능대수 = 유료주차대수 - 유료사용대수 */
    	String chfTcd = null;	/*유료무료구분코드 01:무료 02:유료 */
    	
        // 전처리 : 입력값 체크
        {
        	chfTcd = vo.getChfTcd();
        	
            if (vo.getVhcNo() == null || vo.getVhcNo().equals("")) {
                throw new CustomBadRequestException("필수입력항목[차량번호] 오류. 입력값을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }

            ObjectCopyUtil.copyFields(vo, GAPM1000U0In01VO);
            outList = GAPM1000U0Dao.selectGA01N203PK(GAPM1000U0In01VO);

            if (outList != null && outList.size() > 0) {
                throw new CustomBadRequestException("신규등록할 대상이 이미 존재합니다. 입력항목을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }
            
            // 유료무료 추자 가능대수 체크
            {
            	parkCntInfoList = GAPM1000U0Dao.selectParkCntInfo();
            	
            	if(parkCntInfoList!= null && parkCntInfoList.size() > 0 ) {
            		GAPM1000U0Out11VO = parkCntInfoList.get(0);
                	freeParkCnt = GAPM1000U0Out11VO.getFreeParkCnt()     ; /* 무료주차대수 */		   
                	paidParkCnt = GAPM1000U0Out11VO.getPaidParkCnt()     ; /* 유료주차대수 */
                	allParkCnt  = GAPM1000U0Out11VO.getAllParkCnt()      ; /* 전체주차대수 */
                	freePsesCnt = GAPM1000U0Out11VO.getFreePsesCnt()     ; /* 무료사용대수 */		   
                	paidPsesCnt = GAPM1000U0Out11VO.getPaidPsesCnt()     ; /* 유료사용대수 */
                	allPsesCnt  = GAPM1000U0Out11VO.getAllPsesCnt()      ; /* 전체사용대수 */     
                	
                	freeAblCnt  = freeParkCnt.subtract(freePsesCnt)  ; /* 무료가능대수 = 무료주차대수 - 무료사용대수 */
                	paidAblCnt  = paidParkCnt.subtract(paidPsesCnt)  ; /* 유료가능대수 = 유료주차대수 - 유료사용대수 */ 
                	
                	log.info(GAPM1000U0Out11VO.toString());
                	
                	if(freeAblCnt.compareTo(BigDecimal.ZERO) < 0 ) {
                		freeAblCnt = BigDecimal.ZERO;
                	}
                	if(paidAblCnt.compareTo(BigDecimal.ZERO) < 0 ) {
                		paidAblCnt = BigDecimal.ZERO;
                	}
            	}
            	
            	// 무료 추차가능 체크
            	if(chfTcd.equals("01")) {
            		if(freeAblCnt.compareTo(BigDecimal.ZERO) <= 0) {
                        throw new CustomBadRequestException("무료주차 가능대수가 없습니다. 주차가능대수를 확인하세요 [" + freeAblCnt + "]", ErrorCode.BAD_REQUEST);
            		}
            		
            	}
            	// 유료 주차가능 체크
            	if(chfTcd.equals("02")) {
            		if(paidAblCnt.compareTo(BigDecimal.ZERO) <= 0) {
                        throw new CustomBadRequestException("유료주차 가능대수가 없습니다. 주차가능대수를 확인하세요 [" + paidAblCnt + "]", ErrorCode.BAD_REQUEST);
            		}
            	}
            }
        }

        // 신규등록처리
        {

            // 데이터 카피
            ObjectCopyUtil.copyFields(vo, GA01N203VO);

            // 암호화값 처리
//			GA01N203VO.setOptrId("000000");
//			GA01N203VO.setOprtChnlCd("000");
//			GA01N203VO.setOprtOrzCd("000000");
//			GA01N203VO.setOprtIpAdr("000000");

            cnt = GAPM1000U0Dao.insertGA01N203(GA01N203VO);

            if (cnt == 0) {
                throw new CustomBadRequestException("신규등록 생성오류. 입력값을 확인하세요[" + vo.getVhcNo() + "]", ErrorCode.BAD_REQUEST);
            }
        }

        return cnt;
    }

    /* 정기주차권관리 주차대수요약정보  */
    @Override
    public List<GAPM1000U0Out11VO> selectParkCntInfo() {
        return GAPM1000U0Dao.selectParkCntInfo();
    }

    /* 정기주차권관리 유무료주차대수조회  */
    @Override
    public List<GAPM1000U0Out10VO> selectParkCnt() {
        List<GAPM1000U0Out10VO> outList = (List<GAPM1000U0Out10VO>) new ArrayList();
        GAPM1000U0Out10VO outVo = new GAPM1000U0Out10VO();

        List<GaCode01Out00VO> codeList = null;
        GaCode01In00VO codeVo = new GaCode01In00VO();
        GaCode01Out00VO codeOutVo = null;

        //cdKndNo="TOT_PARK_CNT"				cmnCdVl="01"				bzMtCdVl=수정값

        // 무료주차대수 세팅
        {
            codeVo.setCdKndNo("TOT_PARK_CNT");
            codeVo.setCmnCdVl("01"); // 무료주차

            /* 업무별 관리항목 조회 */
            codeList = CodeDao.selectBzMtCode(codeVo);

            if (codeList == null || codeList.size() == 0) {
                throw new CustomBadRequestException("무료주차대수 값이 존재하지않습니다. 입력값을 확인하세요[" + codeVo.getCdKndNo() + "][" + codeVo.getCmnCdVl() + "]", ErrorCode.BAD_REQUEST);
            }
            codeOutVo = codeList.get(0);
            outVo.setFreeParkCnt(new BigDecimal(codeOutVo.getBzMtCdVl()));
        }

        // 유료주차대수 세팅
        {
            codeVo.setCdKndNo("TOT_PARK_CNT");
            codeVo.setCmnCdVl("02"); // 유료주차

            /* 업무별 관리항목 조회 */
            codeList = CodeDao.selectBzMtCode(codeVo);

            if (codeList == null || codeList.size() == 0) {
                throw new CustomBadRequestException("무료주차대수 값이 존재하지않습니다. 입력값을 확인하세요[" + codeVo.getCdKndNo() + "][" + codeVo.getCmnCdVl() + "]", ErrorCode.BAD_REQUEST);
            }
            codeOutVo = codeList.get(0);
            outVo.setPaidParkCnt(new BigDecimal(codeOutVo.getBzMtCdVl()));
        }

        outVo.setAllParkCnt(outVo.getFreeParkCnt().add(outVo.getPaidParkCnt()));
        outList.add(outVo);

        return outList;
    }

    /* 정기주차권관리 유무료주차대수 수정  */
    @Override
    public int updateParkCnt(GAPM1000U0In10VO vo) {
        int cnt = 0;

        GaCode01In00VO codeVo = new GaCode01In00VO();
        
        List<GAPM1000U0Out11VO> parkCntInfoList = null;
        GAPM1000U0Out11VO GAPM1000U0Out11VO = null;
    	BigDecimal freeParkCnt = BigDecimal.ZERO     ; /* 무료주차대수 */		   
    	BigDecimal paidParkCnt = BigDecimal.ZERO     ; /* 유료주차대수 */
    	BigDecimal allParkCnt  = BigDecimal.ZERO     ; /* 전체주차대수 */
    	BigDecimal freePsesCnt = BigDecimal.ZERO     ; /* 무료사용대수 */		   
    	BigDecimal paidPsesCnt = BigDecimal.ZERO     ; /* 유료사용대수 */
    	BigDecimal allPsesCnt  = BigDecimal.ZERO     ; /* 전체사용대수 */
    	BigDecimal freeAblCnt  = BigDecimal.ZERO     ; /* 무료가능대수 = 무료주차대수 - 무료사용대수 */
    	BigDecimal paidAblCnt  = BigDecimal.ZERO     ; /* 유료가능대수 = 유료주차대수 - 유료사용대수 */
    	String chfTcd = null;	/*유료무료구분코드 01:무료 02:유료 */

        // 유료무료 추자 가능대수 체크
        {
        	// 유료무료 추차 기세팅 조회
        	{
            	parkCntInfoList = GAPM1000U0Dao.selectParkCntInfo();
            	
            	if(parkCntInfoList!= null && parkCntInfoList.size() > 0 ) {
            		GAPM1000U0Out11VO = parkCntInfoList.get(0);
                	freeParkCnt = GAPM1000U0Out11VO.getFreeParkCnt()     ; /* 무료주차대수 */		   
                	paidParkCnt = GAPM1000U0Out11VO.getPaidParkCnt()     ; /* 유료주차대수 */
                	allParkCnt  = GAPM1000U0Out11VO.getAllParkCnt()      ; /* 전체주차대수 */
                	freePsesCnt = GAPM1000U0Out11VO.getFreePsesCnt()     ; /* 무료사용대수 */		   
                	paidPsesCnt = GAPM1000U0Out11VO.getPaidPsesCnt()     ; /* 유료사용대수 */
                	allPsesCnt  = GAPM1000U0Out11VO.getAllPsesCnt()      ; /* 전체사용대수 */     
                	
                	freeAblCnt  = freeParkCnt.subtract(freePsesCnt)  ; /* 무료가능대수 = 무료주차대수 - 무료사용대수 */
                	paidAblCnt  = paidParkCnt.subtract(paidPsesCnt)  ; /* 유료가능대수 = 유료주차대수 - 유료사용대수 */ 
                	
                	log.info(GAPM1000U0Out11VO.toString());
                	
                	if(freeAblCnt.compareTo(BigDecimal.ZERO) < 0 ) {
                		freeAblCnt = BigDecimal.ZERO;
                	}
                	if(paidAblCnt.compareTo(BigDecimal.ZERO) < 0 ) {
                		paidAblCnt = BigDecimal.ZERO;
                	}
            	}
        	}
        	
        	// 무료추차대수 < 무료사용대수 => 에러
        	if(vo.getFreeParkCnt().compareTo(freePsesCnt) < 0){
                throw new CustomBadRequestException("무료주차사용대수 보다 작은값을 입력할수 없습니다. 무료사용주차대수를 확인하세요 : 입력된무료주차대수[" + vo.getFreeParkCnt() + "] 현재무료주차사용대수[ "+ freePsesCnt + "]", ErrorCode.BAD_REQUEST);
        	}

        	// 유료추차대수 < 유료사용대수 => 에러
        	if(vo.getPaidParkCnt().compareTo(paidPsesCnt) < 0){
                throw new CustomBadRequestException("유료주차사용대수 보다 작은값을 입력할수 없습니다. 유료사용주차대수를 확인하세요 : 입력된유료주차대수[" + vo.getPaidParkCnt() + "] 현재유료주차사용대수[" + paidPsesCnt + "]", ErrorCode.BAD_REQUEST);
        	}
        }
        
        // 무료주차대수 세팅
        {
            codeVo.setCdKndNo("TOT_PARK_CNT");
            codeVo.setCmnCdVl("01"); // 무료주차
            codeVo.setBzMtCdVl(vo.getFreeParkCnt().toString()); // 무료주차대수

            /* 업무별 관리항목 수정 */
            cnt = CodeDao.updateBzMtCode(codeVo);

            if (cnt == 0) {
                throw new CustomBadRequestException("무료주차대수 값이 수정오류. 입력값을 확인하세요[" + codeVo.getCdKndNo() + "][" + codeVo.getCmnCdVl() + "][" + codeVo.getBzMtCdVl() + "]", ErrorCode.BAD_REQUEST);
            }
        }

        // 유료주차대수 세팅
        {
            codeVo.setCdKndNo("TOT_PARK_CNT");
            codeVo.setCmnCdVl("02"); // 유료주차
            codeVo.setBzMtCdVl(vo.getPaidParkCnt().toString()); // 유료주차대수

            /* 업무별 관리항목 수정 */
            cnt = CodeDao.updateBzMtCode(codeVo);

            if (cnt == 0) {
                throw new CustomBadRequestException("유료주차대수 값이 수정오류. 입력값을 확인하세요[" + codeVo.getCdKndNo() + "][" + codeVo.getCmnCdVl() + "][" + codeVo.getBzMtCdVl() + "]", ErrorCode.BAD_REQUEST);
            }
        }

        return cnt;
    }


    /* 정기주차권관리 엑셀업로드 */
    @Override
    public int excelUpload(List<Map<String, Object>> list) {
        // TODO Auto-generated method stub
        int arryCnt = 0;
        int cnt = 0;
        String chfTcd = "";
        String vhcPcd = "";
        String vhcNo = "";
        String userOrzCd = "";

        List<GA01N203VO> convertVo = ConvertUtils.convertToValueObjects(list, GA01N203VO.class);
        GA01N203VO setVo = new GA01N203VO();

        for (int i = 0; i < convertVo.size(); i++) {
            arryCnt++;
            setVo = convertVo.get(i);
            log.info("엑셀자료 i[" + i + "}============[" + setVo + "]");
            chfTcd = setVo.getChfTcd();
            vhcPcd = setVo.getVhcPcd();
            vhcNo = setVo.getVhcNo();
            userOrzCd = setVo.getUserOrzCd();

            // 입력값 검증
            {
                if (vhcNo == null || "".equals(vhcNo.trim())) {
                    //log.info("필수입력항목[차량번호] 오류. 입력값을 확인하세요["+vhcNo+"] - ["+arryCnt+"]번째 데이터");
                    throw new CustomBadRequestException("필수입력항목[차량번호] 오류. 입력값을 확인하세요[" + vhcNo + "] - [" + arryCnt + "]번째 데이터", ErrorCode.BAD_REQUEST);
                }
                if (chfTcd == null || "".equals(chfTcd.trim())) {
                    //log.info("필수입력항목[유무료구분코드] 오류. 입력값을 확인하세요["+chfTcd+"] - ["+arryCnt+"]번째 데이터");
                    throw new CustomBadRequestException("필수입력항목[유무료구분코드] 오류. 입력값을 확인하세요[" + chfTcd + "] - [" + arryCnt + "]번째 데이터", ErrorCode.BAD_REQUEST);
                }
                if (vhcPcd == null || "".equals(vhcPcd.trim())) {
                    //log.info("필수입력항목[차량유형구분코드] 오류. 입력값을 확인하세요["+vhcPcd+"] - ["+arryCnt+"]번째 데이터");
                    throw new CustomBadRequestException("필수입력항목[차량유형구분코드] 오류. 입력값을 확인하세요[" + vhcPcd + "] - [" + arryCnt + "]번째 데이터", ErrorCode.BAD_REQUEST);
                }
                if (userOrzCd == null || "".equals(userOrzCd.trim())) {
                    //log.info("필수입력항목[조직코드] 오류. 입력값을 확인하세요["+userOrzCd+"] - ["+arryCnt+"]번째 데이터");
                    throw new CustomBadRequestException("필수입력항목[조직코드] 오류. 입력값을 확인하세요[" + userOrzCd + "] - [" + arryCnt + "]번째 데이터", ErrorCode.BAD_REQUEST);
                }


                if (!Arrays.asList("01", "02").contains(chfTcd.trim())) {
                    //log.info("유무료구분코드 입력오류 ["+chfTcd+"] ["+arryCnt+"]번째 데이터 - (01:무료 02:유료) ");
                    throw new CustomBadRequestException("유무료구분코드 입력오류 [" + chfTcd + "] [" + arryCnt + "]번째 데이터 - (01:무료 02:유료) ", ErrorCode.BAD_REQUEST);
                }
                if (!Arrays.asList("01", "02").contains(vhcPcd.trim())) {
                    //log.info("차량유형구분코드 입력오류 ["+vhcPcd+"] ["+arryCnt+"]번째 데이터 - (01:업무용 02:개인) ");
                    throw new CustomBadRequestException("차량유형구분코드 입력오류 [" + vhcPcd + "] [" + arryCnt + "]번째 데이터 - (01:업무용 02:개인) ", ErrorCode.BAD_REQUEST);
                }

                if ((vhcPcd.trim()).equals("01")) {
                    if (setVo.getUserEpno() != null && !"".equals(setVo.getUserEpno())) {
                        //log.info("차량유형구분코드 01:업무용 일경우 사번입력 불가입니다. 차량번호["+setVo.getVhcNo()+"] 사번["+setVo.getUserEpno()+"] - ["+arryCnt+"]번째 데이터 확인 ");
                        throw new CustomBadRequestException("차량유형구분코드 01:업무용 일경우 사번입력 불가입니다. 차량번호[" + setVo.getVhcNo() + "] 사번[" + setVo.getUserEpno() + "] - [" + arryCnt + "]번째 데이터 확인 ", ErrorCode.BAD_REQUEST);
                    }
                }
            }

            // 기존데이터 삭제후 등록
            /* [2023-09-06] 전체 DELETE 후 INSERT로 변경 요청 -> 원복 요청*/
            GAPM1000U0Dao.deleteGA01N203(setVo);
            GAPM1000U0Dao.insertGA01N203(setVo);
        }
        return arryCnt;
    }


}

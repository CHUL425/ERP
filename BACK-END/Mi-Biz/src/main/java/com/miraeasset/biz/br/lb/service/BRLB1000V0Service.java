package com.miraeasset.biz.br.lb.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.br.lb.dao.BRLB1000V0Dao;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0In00VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0In01VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0In02VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0In03VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0Out00VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0Out02VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0Out03VO;
import com.miraeasset.biz.common.cm.bs.service.CMBS1000V0Service;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0In00VO;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.CryptoUtil;

@Service
@Transactional
public class BRLB1000V0Service {
    private final BRLB1000V0Dao brlb1000V0Dao;
    private final CMBS1000V0Service cmbs1000V0Service; // (공통)계정과목코드 조회

    @Autowired
    public BRLB1000V0Service(BRLB1000V0Dao brlb1000V0Dao, CMBS1000V0Service cmbs1000V0Service) {
        this.brlb1000V0Dao = brlb1000V0Dao;
        this.cmbs1000V0Service = cmbs1000V0Service;
    }

    /**
     * 레벨별 계정과목코드 가져오기
     */
    public List<CMBS1000V0Out00VO> getRentalAndMaintenanceAccountSubjectCode(BRLB1000V0In01VO in01VO) {
        List<CMBS1000V0Out00VO> cmbs1000V0Out00VOList = new ArrayList<>();

        // 검증
        if(in01VO == null) {
            throw new CustomBadRequestException("비정상적인 요청입니다.", ErrorCode.BAD_REQUEST);
        } else if(in01VO.getAcsjGcd().isEmpty() || in01VO == null) {
            throw new CustomBadRequestException("레벨구분을 입력하세요.", ErrorCode.BAD_REQUEST);
        } else if(!in01VO.getAcsjGcd().equals("5") && !in01VO.getAcsjGcd().equals("6")) {
            throw new CustomBadRequestException("레벨구분은 5또는 6만 가능합니다.", ErrorCode.BAD_REQUEST);
        }

        List<String> targetAccountSubjectCodeList = null;
        if(in01VO.getAcsjGcd().equals("5")) {
            // 건물임차료
            targetAccountSubjectCodeList = new ArrayList<>(Arrays.asList("5270060100"));
        } else if (in01VO.getAcsjGcd().equals("6")) {
            //건물임차료, 건물임차료_관리비, 건물임차료_주차장관리비
            targetAccountSubjectCodeList = new ArrayList<>(Arrays.asList("5270060101", "5270060102", "5270060103"));
        }

        for(String targetAccountSubjectCode : targetAccountSubjectCodeList) {
            CMBS1000V0In00VO cmbs1000V0In00VO = new CMBS1000V0In00VO();
            cmbs1000V0In00VO.setAcsjGcd(in01VO.getAcsjGcd());
            cmbs1000V0In00VO.setAcsjCd(targetAccountSubjectCode);
            for(CMBS1000V0Out00VO cmbs1000V0Out00VO : cmbs1000V0Service.select00AT01C001List(cmbs1000V0In00VO)) {
                cmbs1000V0Out00VOList.add(cmbs1000V0Out00VO);
            }
        }

        return cmbs1000V0Out00VOList;
    }

    /**
     * 임차료/관리비현황 조회
     */
    public List<BRLB1000V0Out02VO> getRentalAndMaintenanceFee(BRLB1000V0In02VO in02VO) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date qryStartDate = dateFormat.parse(in02VO.getQryStartDt());
            Date qryEndDate   = dateFormat.parse(in02VO.getQryEndDt()  );

            long days = (qryEndDate.getTime() - qryStartDate.getTime()) / 1000 / (24*60*60);
            System.out.println("################" + days);

            if(days > 366) {
                throw new CustomBadRequestException("1년 이내만 조회 가능해요", ErrorCode.BAD_REQUEST);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<BRLB1000V0Out02VO> brlb1000V0Out02VOList = brlb1000V0Dao.selectList00AT05N200(in02VO);

        for(BRLB1000V0Out02VO brlb1000V0Out02VO : brlb1000V0Out02VOList) {
            CMBS1000V0In00VO cmbs1000V0In00VO = new CMBS1000V0In00VO();
            cmbs1000V0In00VO.setAcsjCd(brlb1000V0Out02VO.getAcsjCd());
            String acsjCdNm = cmbs1000V0Service.select00AT01C001List(cmbs1000V0In00VO).get(0).getAcsjCdNm();
            brlb1000V0Out02VO.setAcsjCdNm(acsjCdNm);
            brlb1000V0Out02VO.setActgUnitCd(in02VO.getOrzCd());
        }

        return brlb1000V0Out02VOList;
    }

    /**
     * 본지점임차현황 조회
     */
    public List<BRLB1000V0Out00VO> getLeaseStatus(BRLB1000V0In00VO in00VO) {
        List<BRLB1000V0Out00VO> brlb1000V0Out00VOList = brlb1000V0Dao.selectList00AT08N101(in00VO);

        if(in00VO.getLsEndDtStart() == null || in00VO.getLsEndDtStart().equals("")) {
            throw new CustomBadRequestException("조회기간을 입력해주세요.", ErrorCode.BAD_REQUEST);
        }

        if(in00VO.getLsEndDtEnd() == null || in00VO.getLsEndDtEnd().equals("")) {
            in00VO.setLsEndDtEnd("99991231");
        }

        for(BRLB1000V0Out00VO brlb1000V0Out00VO : brlb1000V0Out00VOList) {
            // 1.리스료 = 부가세제외리스료 + 리스료부가세
            long surtExpPyLsA = 0;
            long lsAVat = 0;
            long lsA = 0;
            try {
                surtExpPyLsA = Long.parseLong(brlb1000V0Out00VO.getSurtExpPyLsA());
            } catch (Exception e) {
                surtExpPyLsA = 0;
            }
            try {
                lsAVat = Long.parseLong(brlb1000V0Out00VO.getLsAVat());
            } catch (Exception e) {
                lsAVat = 0;
            }
            
            // 리스료 계산
            lsA = surtExpPyLsA + lsAVat;
            brlb1000V0Out00VO.setLsA( Long.toString(lsA) );
            
            
            // [20231102] AT08N101.MN_MCST 미사용하므로 MN_MCST_CN으로 컬럼 변경
            String mnMcst = "0";
            if(brlb1000V0Out00VO.getMnMcst() != null) {
                mnMcst = brlb1000V0Out00VO.getMnMcst().replaceAll("\\D", "");
                if(mnMcst.equals("")) {
                    mnMcst = "0";
                }
            }
            brlb1000V0Out00VO.setMnMcst(mnMcst);
            
            
            // 2.평당 임차료 = 월임차료/임차면적(평)
            //long perpLeasA = 0;
            BigDecimal perpLeasA = BigDecimal.ZERO;
            
            // 3.평당 관리비 = 월관리비/임차면적(평)
            //long perpMcst = 0;
            BigDecimal perpMcst = BigDecimal.ZERO;
            
            long intMnMcst = 0;
            try{
            	intMnMcst = Long.parseLong(brlb1000V0Out00VO.getMnMcst()); // 월관리비
            } catch (Exception e) {
            	intMnMcst = 0;
            }
            
            
            double leasAr = 0;   // 임차면적(평)
            try {
            	leasAr = brlb1000V0Out00VO.getLeasAr2();
            } catch (Exception e) {
            	leasAr = 0;
            }
            if(leasAr == 0) {
            	perpLeasA = new BigDecimal(lsA);
            	perpMcst = new BigDecimal(intMnMcst);
            } else {
            	perpLeasA = new BigDecimal(lsA/leasAr);
            	perpMcst = new BigDecimal(intMnMcst/leasAr);
            }
            
            // 소수둘째자리까지표기
            DecimalFormat df = new DecimalFormat("#,##0.00");
            
            brlb1000V0Out00VO.setPerpLeasA(df.format(perpLeasA));
            brlb1000V0Out00VO.setPerpMcst(df.format(perpMcst));
            //월 임차비용 = 월임차료+월 관리비
            brlb1000V0Out00VO.setMonLeasA( Long.toString(lsA+intMnMcst) );
            //연 임차비용 = 월 임차비용*12
            brlb1000V0Out00VO.setyLeasA( Long.toString((lsA+intMnMcst)*12) );
            
            String decryptedAdr = "";
            try{
                decryptedAdr = CryptoUtil.getDecryption(brlb1000V0Out00VO.getAdrEcpVl());
            } catch (RuntimeException e) {
                e.printStackTrace();
                decryptedAdr = "복호화 에러가 발생했어요. 개발자에게 문의해주세요. [내용]:" + e.toString();
            } finally {
                brlb1000V0Out00VO.setAdrEcpVl(decryptedAdr);
            }
        }

        return brlb1000V0Out00VOList;
    }
    
    
    /**
     * 지점임차비용 비교
     */
    public List<BRLB1000V0Out03VO> selectAT08N101ByOrz(BRLB1000V0In03VO inVo) {
    	
    	List<BRLB1000V0Out03VO> returnList = new ArrayList<>();
    	BRLB1000V0Out00VO frstOrzInfo = null;
    	BRLB1000V0Out00VO scndOrzInfo = null;
    	BRLB1000V0Out00VO thrdOrzInfo = null;
    	
    	// [첫번째] 조직 조회
    	if(!StringUtils.isBlank(inVo.getFrstOrzCd())) {
    		frstOrzInfo = brlb1000V0Dao.selectAT08N101ByOrz(inVo.getFrstOrzCd());
    	}
    	// [두번째] 조직 조회
    	if(!StringUtils.isBlank(inVo.getScndOrzCd())) {
    		scndOrzInfo = brlb1000V0Dao.selectAT08N101ByOrz(inVo.getScndOrzCd());
    	}
    	// [세번째] 조직 조회
    	if(!StringUtils.isBlank(inVo.getThrdOrzCd())) {
    		thrdOrzInfo = brlb1000V0Dao.selectAT08N101ByOrz(inVo.getThrdOrzCd());
    	}
    	
		/* 결과 전달방식:
         *        [orzNm0] [orzNm1] [orzNm2] [orzNm3]
         * rtnVo1 조직명     orzNm1    orzNm2    orzNm3
         * rtnVo2 임대면적    orzNm1    orzNm2    orzNm3
         * rtnVo3 전용면적    orzNm1    orzNm2    orzNm3
         * rtnVo4 월 임차료   orzNm1    orzNm2    orzNm3
         * rtnVo5 월 관리비   orzNm1    orzNm2    orzNm3
         * rtnVo6 월 임차비용  orzNm1    orzNm2    orzNm3
         * rtnVo7 연 임차비용  orzNm1    orzNm2    orzNm3
		 * */
    	BRLB1000V0Out03VO rtnVo1 = new BRLB1000V0Out03VO();
    	BRLB1000V0Out03VO rtnVo2 = new BRLB1000V0Out03VO();
    	BRLB1000V0Out03VO rtnVo3 = new BRLB1000V0Out03VO();
    	BRLB1000V0Out03VO rtnVo4 = new BRLB1000V0Out03VO();
    	BRLB1000V0Out03VO rtnVo5 = new BRLB1000V0Out03VO();
    	BRLB1000V0Out03VO rtnVo6 = new BRLB1000V0Out03VO();
    	BRLB1000V0Out03VO rtnVo7 = new BRLB1000V0Out03VO();
    	
    	rtnVo1.setOrzTitle("");
    	rtnVo2.setOrzTitle("임차면적");
    	rtnVo3.setOrzTitle("임차면적");
    	rtnVo4.setOrzTitle("");
    	rtnVo5.setOrzTitle("");
    	rtnVo6.setOrzTitle("합계");
    	rtnVo7.setOrzTitle("합계");
    	
    	rtnVo1.setOrzNm0("조직명");
    	rtnVo2.setOrzNm0("임차면적");
    	rtnVo3.setOrzNm0("전용면적");
    	rtnVo4.setOrzNm0("월 임차료");
    	rtnVo5.setOrzNm0("월 관리비");
    	rtnVo6.setOrzNm0("월 임차비용");
    	rtnVo7.setOrzNm0("연 임차비용");
    	
    	// [첫번째] 조직 정보 세팅
    	if(frstOrzInfo != null) {
    		
    		// 1.리스료 = 부가세제외리스료 + 리스료부가세
            long surtExpPyLsA = 0;
            long lsAVat = 0;
            long lsA = 0;
            try {
                surtExpPyLsA = Long.parseLong(frstOrzInfo.getSurtExpPyLsA());
            } catch (Exception e) {
                surtExpPyLsA = 0;
            }
            try {
                lsAVat = Long.parseLong(frstOrzInfo.getLsAVat());
            } catch (Exception e) {
                lsAVat = 0;
            }
            lsA = surtExpPyLsA + lsAVat;
            
            // 2.월 관리비
            long mnMcst = 0;
            try {
            	mnMcst = Long.parseLong(frstOrzInfo.getMnMcst());
            } catch (Exception e) {
            	mnMcst = 0;
            }
            
    		rtnVo1.setOrzNm1(frstOrzInfo.getOrzNm());         //조직명
        	rtnVo2.setOrzNm1(String.valueOf(frstOrzInfo.getLeasAr2()));       //임대면적
        	rtnVo3.setOrzNm1(String.valueOf(frstOrzInfo.getOnlyAr2()));       //전용면적
        	rtnVo4.setOrzNm1(Long.toString(lsA));             //월 임차료
        	rtnVo5.setOrzNm1(Long.toString(mnMcst));          //월 관리비
        	rtnVo6.setOrzNm1(Long.toString(lsA+mnMcst));      //월 임차비용=월 임차료+월관리비
        	rtnVo7.setOrzNm1(Long.toString((lsA+mnMcst)*12)); //연 임차비용=월 임차비용*12
    	}
    	
    	// [두번째] 조직 정보
    	if(scndOrzInfo != null) {
    		
    		// 1.리스료 = 부가세제외리스료 + 리스료부가세
            long surtExpPyLsA = 0;
            long lsAVat = 0;
            long lsA = 0;
            try {
                surtExpPyLsA = Long.parseLong(scndOrzInfo.getSurtExpPyLsA());
            } catch (Exception e) {
                surtExpPyLsA = 0;
            }
            try {
                lsAVat = Long.parseLong(scndOrzInfo.getLsAVat());
            } catch (Exception e) {
                lsAVat = 0;
            }
            lsA = surtExpPyLsA + lsAVat;
            
            // 2.월 관리비
            long mnMcst = 0;
            try {
            	mnMcst = Long.parseLong(scndOrzInfo.getMnMcst());
            } catch (Exception e) {
            	mnMcst = 0;
            }
            
    		rtnVo1.setOrzNm2(scndOrzInfo.getOrzNm());         //조직명
        	rtnVo2.setOrzNm2(String.valueOf(scndOrzInfo.getLeasAr2()));       //임대면적
        	rtnVo3.setOrzNm2(String.valueOf(scndOrzInfo.getOnlyAr2()));       //전용면적
        	rtnVo4.setOrzNm2(Long.toString(lsA));             //월 임차료
        	rtnVo5.setOrzNm2(Long.toString(mnMcst));          //월 관리비
        	rtnVo6.setOrzNm2(Long.toString(lsA+mnMcst));      //월 임차비용=월 임차료+월관리비
        	rtnVo7.setOrzNm2(Long.toString((lsA+mnMcst)*12)); //연 임차비용=월 임차비용*12
    	}
    	
    	// [세번째] 조직 정보
    	if(thrdOrzInfo != null) {
    		
    		// 1.리스료 = 부가세제외리스료 + 리스료부가세
            long surtExpPyLsA = 0;
            long lsAVat = 0;
            long lsA = 0;
            try {
                surtExpPyLsA = Long.parseLong(thrdOrzInfo.getSurtExpPyLsA());
            } catch (Exception e) {
                surtExpPyLsA = 0;
            }
            try {
                lsAVat = Long.parseLong(thrdOrzInfo.getLsAVat());
            } catch (Exception e) {
                lsAVat = 0;
            }
            lsA = surtExpPyLsA + lsAVat;
            
            // 2.월 관리비
            long mnMcst = 0;
            try {
            	mnMcst = Long.parseLong(thrdOrzInfo.getMnMcst());
            } catch (Exception e) {
            	mnMcst = 0;
            }
            
    		rtnVo1.setOrzNm3(thrdOrzInfo.getOrzNm());         //조직명
        	rtnVo2.setOrzNm3(String.valueOf(thrdOrzInfo.getLeasAr2()));       //임대면적
        	rtnVo3.setOrzNm3(String.valueOf(thrdOrzInfo.getOnlyAr2()));       //전용면적
        	rtnVo4.setOrzNm3(Long.toString(lsA));             //월 임차료
        	rtnVo5.setOrzNm3(Long.toString(mnMcst));          //월 관리비
        	rtnVo6.setOrzNm3(Long.toString(lsA+mnMcst));      //월 임차비용=월 임차료+월관리비
        	rtnVo7.setOrzNm3(Long.toString((lsA+mnMcst)*12)); //연 임차비용=월 임차비용*12
    	}
    	
    	returnList.add(rtnVo1);
    	returnList.add(rtnVo2);
    	returnList.add(rtnVo3);
    	returnList.add(rtnVo4);
    	returnList.add(rtnVo5);
    	returnList.add(rtnVo6);
    	returnList.add(rtnVo7);
        return returnList;
    }
}

package com.miraeasset.biz.in.in.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.ga.bm.dao.GABM1000U0Dao;
import com.miraeasset.biz.ga.bm.service.GABM1000U0ServiceImpl;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0In00VO;
import com.miraeasset.biz.ga.bm.vo.GABM1000U0Out00VO;
import com.miraeasset.biz.in.in.dao.ININ2000V0Dao;
import com.miraeasset.biz.in.in.vo.ININ1000V0In02VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out00VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out01VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0Out02VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO;
import com.miraeasset.biz.in.in.vo.ININ2000V0VO2;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out00VO;
import com.miraeasset.biz.rq.dr.vo.GA01N602ModVO;

@Service
@Transactional
public class ININ2000V0ServiceImple implements ININ2000V0Service {
	
	@Autowired
	ININ2000V0Dao dao;
	
	@Autowired
	RQAM1000U0Dao RQAM1000U0Dao;
	
	/* 연간 예산집행 */
	@Override
	public ININ2000V0Out02VO ylyBdgt(ININ1000V0In02VO vo) {
		/*
		* [R231218-007]
		* 1. "연간 예산집행"의 "전년동기대비"를 말일 기준이 아닌, 작년 오늘일자로 변경. 예) AS-IS) 2023-12-21 -> 2022-12-31 / TO-BE) 2023-12-21 -> 2022-12-21
		* 2. "분기누적 예산집행"을 "분기 예산집행"으로 변경(누적이 아닌 해당 분기만 표기되도록 변경)
		* */
		
		String bzTp = vo.getBzTp()	; /* 업무구분 1.연간, 2.감가상각비 제외 */
		
		if (!bzTp.equals("1") && !bzTp.equals("2")) {
			 throw new CustomBadRequestException("[필수항목 체크] 업무구분 오류 bzTp = [" + vo.getBzTp() + "]", ErrorCode.BAD_REQUEST);		
		}
		
		/* 현재 */
		String ymDt = DateUtil.getTodayString("yyyyMMdd");
		String QryEndDt  = DateUtil.getAddDay(ymDt, -1);
		String QryStrtDt = DateUtil.getAddDay(QryEndDt, -1);
		
		/* 전년도 */
//		String yr = DateUtil.getAddDay(QryEndDt, -365);
//		String bfEndDt = yr.substring(0, 4) + "1231";
		// [R231218-007] "연간 예산집행"의 "전년동기대비"를 말일 기준이 아닌, 작년 오늘일자로 변경. 예) AS-IS) 2023-12-21 -> 2022-12-31 / TO-BE) 2023-12-21 -> 2022-12-21
		String bfEndDt = DateUtil.getAddDay(QryEndDt, -365);
		String bfStrtDt = DateUtil.getAddDay(bfEndDt, -1);
		
		ININ1000V0In02VO nowInVo = new ININ1000V0In02VO();
		nowInVo.setBzTp(bzTp);
		nowInVo.setQryStrtDt(QryStrtDt);
		nowInVo.setQryEndDt(QryEndDt);
		List<ININ2000V0Out00VO> nowBdgt = dao.selectGeafBusiBdgt(nowInVo); 
//		ININ2000V0Out00VO EnfcA = new ININ2000V0Out00VO();
//		EnfcA = dao.selectGeafBusiBdgt2(nowInVo);
		
		
		ININ1000V0In02VO bfInVo = new ININ1000V0In02VO();
		bfInVo.setBzTp(bzTp);
		bfInVo.setQryStrtDt(bfStrtDt);
		bfInVo.setQryEndDt(bfEndDt);
		List<ININ2000V0Out00VO> bfBdgt = dao.selectGeafBusiBdgt(bfInVo); 
		
		ININ2000V0Out02VO rs = new ININ2000V0Out02VO();
		/* 연간대비 */
		BigDecimal ylyCmpR   = nowBdgt.get(0).getYlyCmpR();
		/* 전년동기대비 */ 
		BigDecimal bfYlyCmpR = nowBdgt.get(0).getYlyCmpR().subtract(bfBdgt.get(0).getYlyCmpR());
		/* 연간예산 */
		BigDecimal ylyBdgtA  = nowBdgt.get(0).getYlyBdgtA();
		/* 집행금액 */
		BigDecimal enfcA     = nowBdgt.get(0).getEnfcA();
//		BigDecimal enfcA     = EnfcA.getEnfcA();
		/* 예산잔액 */
		BigDecimal bdgtBala  = nowBdgt.get(0).getBdgtBala();
		
		/* 연간예산집행 */
		rs.setYlyCmpR(ylyCmpR); 
		rs.setBfYlyCmpR(bfYlyCmpR);
		rs.setYlyBdgtA(ylyBdgtA);
		rs.setEnfcA(enfcA);
		rs.setBdgtBala(bdgtBala);


		/* [R231218-007] "분기누적 예산집행"을 "분기 예산집행"으로 변경(누적이 아닌 해당 분기만 표기되도록 변경) */
		/* 분기배정금액 = 연간예산(연간배정금액) / 4 */
		BigDecimal qtr4 = new BigDecimal(4);
		BigDecimal qtrBdgtA = ylyBdgtA.divide(qtr4, 2, BigDecimal.ROUND_HALF_UP);

//		/* 전년동분기배정대비 */
//		BigDecimal bfYlyAsnCmpR = nowBdgt.get(0).getAsnCmpR().subtract(bfBdgt.get(0).getAsnCmpR());
//		/* 분기누적배정 */
//		BigDecimal qtrAccmAsnA  = nowBdgt.get(0).getAsnA();

		/* 시스템일자 기준 전분기 조회 */
		List<ININ1000V0In02VO> qtrList = dao.selectBfQtrDt();
		
		
		
		/**
		 * [2024.04.04] 전분기 일자 세팅
		 * 
		 * 분기  시작일  종료일
		 *  1	20240330	20240331   
		 *  2	20240629	20240630   
		 *  3	20240929	20240930   
		 *  4	20241230	20241231   
		 *  
		 *  
		 *  집행금액(분기) = 현재까지 누적 집행금액 - 전분기 누적 집행금액
		 *  
		 */
		ININ1000V0In02VO qtrInVo = new ININ1000V0In02VO();
		qtrInVo.setBzTp(bzTp);
		
		// 전분기 일자 세팅 START
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int quarter = (month/3)+1;
		
		String lastQStartDt = "";
		String lastQEndDt = "";
		
		if( quarter == 1 ) { // 1분기는 minus 집행금액 없음
			lastQStartDt = year+"0101";
			lastQEndDt   = year+"0101";
		} else if( quarter == 2) { // 2분기는 1분기 집행금액 설정
			lastQStartDt = year+"0330";
			lastQEndDt   = year+"0331";
		} else if(quarter == 3) { // 3분기는 2분기 집행금액 설정
			lastQStartDt = year+"0629";
			lastQEndDt   = year+"0630";
		} else if(quarter == 4) { // 4분기는 3분기 집행금액 설정
			lastQStartDt = year+"0929";
			lastQEndDt   = year+"0930";
		}
		
		qtrInVo.setQryStrtDt(lastQStartDt);
		qtrInVo.setQryEndDt(lastQEndDt);
		// 전분기 일자 세팅 END
		
		List<ININ2000V0Out00VO> qtrBdgt = dao.selectGeafBusiBdgt(qtrInVo);
		
		/* 집행금액(분기) */
		BigDecimal qtrEnfcA = nowBdgt.get(0).getEnfcA().subtract(qtrBdgt.get(0).getEnfcA());

		/* 예산잔액(분기) */
		BigDecimal qtrBdgtBala = qtrBdgtA.subtract(qtrEnfcA);


//		/* 배정대비 */
//		BigDecimal asnCmpR      = nowBdgt.get(0).getAsnCmpR();
		/* 분기예산집행률 = 분기집행금액 / 분기배정금액 */
		BigDecimal asnCmpR = qtrEnfcA.divide(qtrBdgtA, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L));

		/* 전년동분기대비 = (올해)분기예산집행률 - (작년)분기예산집행률 */
		ININ1000V0In02VO bfQtrInVo = new ININ1000V0In02VO();
		bfQtrInVo.setBzTp(bzTp);
		bfQtrInVo.setQryStrtDt(DateUtil.getAddDay(qtrList.get(0).getQryStrtDt(), -365));
		bfQtrInVo.setQryEndDt(DateUtil.getAddDay(qtrList.get(0).getQryEndDt(), -365));
		List<ININ2000V0Out00VO> bfQtrBdgt = dao.selectGeafBusiBdgt(bfQtrInVo);

		BigDecimal bfQtrBdgtA = bfBdgt.get(0).getYlyBdgtA().divide(qtr4, 2, RoundingMode.HALF_UP); /* 작년 분기배정금액 */
		BigDecimal bfQtrEnfcA = bfBdgt.get(0).getEnfcA().subtract(bfQtrBdgt.get(0).getEnfcA()); /* 작년 분기집행금액 */
		BigDecimal bfAsnCmpR  = bfQtrEnfcA.divide(bfQtrBdgtA, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)); /* 작년 분기예산집행률 */
		BigDecimal bfYlyAsnCmpR = asnCmpR.subtract(bfAsnCmpR); /* 전년동분기대비 */

		/* 분기누적예산집행 */
		rs.setAsnCmpR(asnCmpR);              /* 분기예산집행률 */
		rs.setBfYlyAsnCmpR(bfYlyAsnCmpR);    /* 전년동기대비 */
//		rs.setQtrAccmAsnA(qtrAccmAsnA);      /* 분기누적배정 */
		rs.setQtrAccmAsnA(qtrBdgtA);         /* 분기배정금액 */
		rs.setQtrEnfcA(qtrEnfcA);            /* 집행금액(분기) */
		rs.setQtrBdgtBala(qtrBdgtBala);      /* 예산잔액(분기) */

		return rs;
	}
	
	/* 연간 예산집행 추이 */
	@Override
	public ININ2000V0VO selectYlyBdgtEnfc() {
		// TODO Auto-generated method stub
		List<ININ2000V0Out01VO> grid;
		ININ1000V0In02VO inVo1 = new ININ1000V0In02VO();
		List<ININ2000V0Out01VO> total;
		ININ1000V0In02VO inVo2 = new ININ1000V0In02VO();
		
		inVo1.setBzTp("1");
		grid = dao.selectYlyBdgtEnfc(inVo1);
		
		ININ2000V0VO rs = new ININ2000V0VO();
		if (grid.size() > 0 ) {
			inVo2.setBzTp("2");
			total = dao.selectYlyBdgtEnfc(inVo2);
			
			rs.setGrid(grid);
			rs.setTotal(total);
		}
		return rs;
	}
	
	/* 총무사업 예산 */
	@Override
	public List<ININ2000V0Out00VO> selectGeafBusiBdgt(ININ1000V0In02VO vo) {
		// TODO Auto-generated method stub
		
		// 업무구분 총무사업예산 IO 1.예산집행-전체, 2.예산집행-감가제외, 3.차트바(현재 미사용), 4.소모품등
		if(vo.getBzTp() == null || vo.getBzTp().equals("")) {
            throw new CustomBadRequestException("[필수항목 체크] 업무구분이 입력되지않았습니다.", ErrorCode.BAD_REQUEST);					
		}
		
		String ymDt = DateUtil.getTodayString("yyyyMMdd");
		String QryEndDt  = DateUtil.getAddDay(ymDt, -1);
		String QryStrtDt = DateUtil.getAddDay(QryEndDt, -1);
		
		System.out.print("QryStrtDt = " + QryStrtDt +" " + "QryEndDt = " + QryEndDt + "\n");
		
		vo.setQryStrtDt(QryStrtDt);
		vo.setQryEndDt(QryEndDt);
		
		return dao.selectGeafBusiBdgt(vo);
	}
	
	/* 임직원 초기화면 - 승인현황 */
	@Override
	public List<ININ2000V0VO2> selectXempApvPstt(ININ2000V0VO2 vo) {
		// TODO Auto-generated method stub
		
		List<ININ2000V0VO2> list = new ArrayList<ININ2000V0VO2>();
		RQAM1000U0In00VO inVo = new RQAM1000U0In00VO();
		ININ2000V0VO2 outVo = null;
		
		if (vo.getBzTp().equals("2")) {
			
			inVo.setEpno(vo.getEpno());
			inVo.setBlngOrzCd(vo.getBlngOrzCd());
			inVo.setHrOsdtCd(vo.getHrOsdtCd());
			inVo.setPageIndex(vo.getPageIndex());
			inVo.setPageSize(vo.getPageSize());
			
			for (RQAM1000U0Out00VO tmpVo : RQAM1000U0Dao.selectAprvList(inVo)) {
				outVo = new ININ2000V0VO2();
				outVo.setAprvPcd(tmpVo.getAprvPcd());
				outVo.setAprvEpnm(tmpVo.getWrrptEpNm());
				outVo.setAprvWrrptMtNo(tmpVo.getAprvWrrptMtNo());
				outVo.setAprvWrrptOrzCd(tmpVo.getAprvWrrptOrzCd());
				outVo.setRctNo(tmpVo.getRctNo());
				outVo.setRqsScdNm(tmpVo.getAprvScdNm());
				outVo.setRqsTtlNm(tmpVo.getRqsTtlNm());
				outVo.setUnifRqsPcdNm(tmpVo.getAprvPcdNm());
				outVo.setRqsDt(tmpVo.getWrrptDt());
				outVo.setAprvRnk(tmpVo.getAprvRnk());
				outVo.setAprvDlRnk(tmpVo.getAprvDlRnk());
				list.add(outVo);
			}
		} else {
			list = dao.selectXempApvPstt(vo);
		}
		
		return list;
	}
	
}

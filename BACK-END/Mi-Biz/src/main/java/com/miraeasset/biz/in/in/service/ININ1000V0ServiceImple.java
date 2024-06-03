package com.miraeasset.biz.in.in.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import com.miraeasset.biz.in.in.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.br.rb.dao.BRRB3000V0Dao;
import com.miraeasset.biz.br.rb.service.BRRB2000V0Service;
import com.miraeasset.biz.br.rb.service.BRRB3000V0Service;
import com.miraeasset.biz.br.rb.service.BRRB4000V0Service;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0In00VO;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0Out00VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In00VO;
import com.miraeasset.biz.in.in.dao.ININ1000V0Dao;

@Service
@Transactional
public class ININ1000V0ServiceImple implements ININ1000V0Service {
	
	@Autowired
	ININ1000V0Dao dao;
	
	@Autowired
	BRRB2000V0Service brrb2000Svc;
	@Autowired
	BRRB3000V0Service brrb3000Svc;
	@Autowired
	BRRB3000V0Dao brrb3000V0Dao;
	
	@Autowired
    BRRB4000V0Service brrb4000Svc;

	// [20231115] "(총무팀 초기화면)-(소모품, 리스료 등 예산짐행금액)"을 "(대시보드)-(총무사업예산)-(소모품, 리스료 비용관리)-(합계)"와 동일하게 수정요청
	@Autowired
	ININ2000V0Service inin2000V0Service;
	
	/* Today 업무현황 
	 * 
	 * 오늘까지 접수한 나의 업무현황
	 * 처리완료(당일포함 2주동안 처리한 내역)
	 * 미처리(당일포함 2주동안 미처리한 내역)
	 * */
	@Override
	public ININ1000V0Out00VO selectTodayBzPstt(ININ1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return dao.selectTodayBzPstt(vo);
	}
	
	/* 예산집행금액 및 집행율
	 * 
	 * 해당일 전일까지 누적 예산집행율
	 *  */
	@Override
	public ININ1000V0Out01VO selectBdgtList() {
		// TODO Auto-generated method stub
		ININ1000V0In01VO inVo = new ININ1000V0In01VO();
		String yrDyEndDt  = DateUtil.getAddDay(DateUtil.getTodayString("yyyyMMdd"), -1);
		String yrDyStrtDt = DateUtil.getAddDay(yrDyEndDt, -1); /* 년시작일자 */
		inVo.setYrDyEndDt(yrDyEndDt);
		inVo.setYrDyStrtDt(yrDyStrtDt);
		
		return dao.selectBdgtList(inVo);
	}
	
	/* 소모품, 리스료 등  예산 집행금액 */
	@Override
	public ININ1000V0Out02VO selectYlyBdgtList() {
		// TODO Auto-generated method stub

		// [20231115] "(총무팀 초기화면)-(소모품, 리스료 등 예산짐행금액)"을 "(대시보드)-(총무사업예산)-(소모품, 리스료 비용관리)-(합계)"와 동일하게 수정요청
		// 기존 소스 주석처리
//		ININ1000V0In01VO inVo = new ININ1000V0In01VO();
//		String yrDyEndDt  = DateUtil.getAddDay(DateUtil.getTodayString("yyyyMMdd"), -1);
//		String yrDyStrtDt = DateUtil.getAddDay(yrDyEndDt, -1); /* 년시작일자 */
//		inVo.setYrDyEndDt(yrDyEndDt);
//		inVo.setYrDyStrtDt(yrDyStrtDt);
//
//		return dao.selectYlyBdgtList(inVo);

		// (대시보드)-(총무사업예산)-(소모품, 리스료 비용관리)-(합계)
		ININ1000V0Out02VO result = new ININ1000V0Out02VO();

		ININ1000V0In02VO inin1000V0In02VO = new ININ1000V0In02VO();
		inin1000V0In02VO.setBzTp("4");

		List<ININ2000V0Out00VO> inin2000V0Out00VOList = inin2000V0Service.selectGeafBusiBdgt(inin1000V0In02VO);
		ININ2000V0Out00VO sumOfInin2000V0Out00VO = inin2000V0Out00VOList.get(inin2000V0Out00VOList.size() - 1);

		if(sumOfInin2000V0Out00VO != null
				&& sumOfInin2000V0Out00VO.getBzTpNm().equals("합계")) {
			result.setAccmAsnA(   sumOfInin2000V0Out00VO.getAsnA().toString()     ); // 누적배정금액	- 배정
			result.setAsnCmpEnfcr(sumOfInin2000V0Out00VO.getAsnCmpR().toString()  ); // 배정대비집행율	- 배정대비
			result.setBdgtFmtnA(  sumOfInin2000V0Out00VO.getYlyBdgtA().toString() ); // 편성금액		- 연간예산
			result.setEnfcA(      sumOfInin2000V0Out00VO.getEnfcA().toString()    ); // 집행금액		- 집행
			result.setYlYenfcr(   sumOfInin2000V0Out00VO.getYlyCmpR().toString()  ); // 연간집행율	- 연간대비
		} else { // NULL 이거나 합계 없는 경우 0 리턴
			result.setAccmAsnA(   "0");
			result.setAsnCmpEnfcr("0");
			result.setBdgtFmtnA(  "0");
			result.setEnfcA(      "0");
			result.setYlYenfcr(   "0");
		}

		return result;
	}
	
	/* 지점 사옥임대손익 현황 */
	private ININ1000V0Out03VO OfficeRentalPLStatus(BRRB2000V0In00VO in) {
//
//        BRRB2000V0Out00VO revenue = new BRRB2000V0Out00VO(3, 1, "매출");
//        BRRB2000V0Out00VO expense = new BRRB2000V0Out00VO(3, 2, "비용");
//
//        BRRB2000V0Out00VO rentalRevenue = new BRRB2000V0Out00VO(2, 1, "임대매출");
//        BRRB2000V0Out00VO selfBranchRevenue = new BRRB2000V0Out00VO(2, 2, "자가지점 환산수익");
//
//        BRRB2000V0Out00VO propertyTax = new BRRB2000V0Out00VO(2, 1, "재산세금");
//        BRRB2000V0Out00VO sumOfRevenue = new BRRB2000V0Out00VO(1, 99, "매출합계");
//        BRRB2000V0Out00VO sumOfExpense = new BRRB2000V0Out00VO(1, 99, "비용합계");
//
//        // 매출-임대매출
//        rentalRevenue.addChildAcsjList(brrb3000Svc.getDepositInterest(in));
//        rentalRevenue.addChildAcsjList(brrb3000Svc.getRentalSalesTaxInvoice(in));
//        rentalRevenue.addChildAcsjList(brrb3000Svc.getRentalSalesInvoice(in));
//        rentalRevenue.addChildAcsjList(brrb3000Svc.getRentalParkingFee(in));
//
//        // 매출-자가지점 환산수익
//        selfBranchRevenue.addChildAcsjList(brrb3000Svc.getSelfBranchDepositInterest(in));
//        selfBranchRevenue.addChildAcsjList(brrb3000Svc.getSelfBranchLeaseFee(in));
//
//        // 재산세금
//        propertyTax.addChildAcsjList(brrb4000Svc.getPropertyTax(in));
//        propertyTax.addChildAcsjList(brrb4000Svc.getOtherTaxesAndDuties(in));
//        propertyTax.addChildAcsjList(brrb4000Svc.getEstateTax(in));
//        propertyTax.addChildAcsjList(brrb4000Svc.getRoadOccupationFee(in));
//        propertyTax.addChildAcsjList(brrb4000Svc.getTrafficInducedBurdenFee(in));
//        propertyTax.addChildAcsjList(brrb4000Svc.getCorporateEqualResidentTax(in));
//
//        /* 2-3. 하위항목 추가(RANK-3) */
//        // 매출
//        revenue.addChildAcsjList(rentalRevenue);
//        revenue.addChildAcsjList(selfBranchRevenue);
//        revenue.addChildAcsjList(sumOfRevenue);
//
//        // 비용
//        expense.addChildAcsjList(propertyTax);
//        expense.addChildAcsjList(brrb4000Svc.getHeatingFuelExpense(in));
//        expense.addChildAcsjList(brrb4000Svc.getElectricityBill(in));
//        expense.addChildAcsjList(brrb4000Svc.getWaterBill(in));
//        expense.addChildAcsjList(brrb4000Svc.getGeneralFee(in));
//        expense.addChildAcsjList(brrb4000Svc.getOfficeAdministrationExpense(in));
//        expense.addChildAcsjList(brrb4000Svc.getConsumableExpense(in));
//        expense.addChildAcsjList(brrb4000Svc.getBuildingRepairExpense(in));
//        expense.addChildAcsjList(brrb4000Svc.getMaintenanceFee(in));
//        expense.addChildAcsjList(sumOfExpense);
//
//        /* 합계항목 */
////        System.out.print("revenue = " + revenue.getChildSumA() + " " + "expense = " + expense.getChildSumA()+ "\n");
//        ININ1000V0Out03VO rs = new ININ1000V0Out03VO();
//        // 수익
//        rs.setOfcbldRentErn(revenue.getChildSumA());
//        // 비용
//        rs.setOfcbldRentCt(expense.getChildSumA());
//
//		return rs;
		ININ1000V0Out03VO result = new ININ1000V0Out03VO();
		BRRB2000V0Out00VO officeRentalRevenue = brrb2000Svc.getOfficeRentalPLStatusRevenue(in);
		BRRB2000V0Out00VO officeRentalExpense = brrb2000Svc.getOfficeRentalPLStatusExpense(in);

		result.setOfcbldRentErn(officeRentalRevenue.getSumA());
		result.setOfcbldRentCt(officeRentalExpense.getSumA());

		return result;
	}
	
	/* 사옥임대현황 */
	@Override
	public ININ1000V0Out03VO selectOfcbldRentPstt(String basYm) {
		
		BRRB2000V0In00VO in = new BRRB2000V0In00VO(); 
		ININ1000V0Out03VO rs = new ININ1000V0Out03VO();
		
		int y = Integer.parseInt(basYm.substring(0, 4));
		int m = Integer.parseInt(basYm.substring(4, 6));
		int d = Integer.parseInt(basYm.substring(6, 8));

		java.util.GregorianCalendar sToday = new java.util.GregorianCalendar();
		sToday.set(y, m - 1, d);
		int day = sToday.get(GregorianCalendar.DAY_OF_MONTH);
		
		String MNBF     = DateUtil.getAddMonth(basYm, -1); // 전월
		String BFR_MNBF = DateUtil.getAddMonth(basYm, -2); // 전전월
		String BAS_YM;
		
		// 10일 이전 = 전전월 기준
		if (day < 10) {
			BAS_YM = BFR_MNBF.substring(0, 6); 
		}
		// 10일 이후 = 전월 기준
		else {
			BAS_YM = MNBF.substring(0, 6); 
		}
		System.out.print("day = " + day + " " + "MNBF = " + MNBF + " " + "BFR_MNBF = " + BFR_MNBF + "\n");
		in.setBasYm(BAS_YM);
		rs = OfficeRentalPLStatus(in);
		
		BigDecimal WUNT = new BigDecimal("100000000");
		// 조회기준 수익, 비용
		BigDecimal OfcbldRentErn = rs.getOfcbldRentErn().divide(WUNT, 2, BigDecimal.ROUND_HALF_UP ).setScale(2, RoundingMode.DOWN);
		BigDecimal OfcbldRentCt  = rs.getOfcbldRentCt().divide(WUNT, 2, BigDecimal.ROUND_HALF_UP ).setScale(2, RoundingMode.DOWN);	
		
		System.out.print("OfcbldRentErn = " + OfcbldRentErn + " " + "OfcbldRentCt" + OfcbldRentCt + "\n");
		
		String MNBF_BAS_YM = DateUtil.getAddMonth(BAS_YM, -1);
		in = new BRRB2000V0In00VO();
		rs = new ININ1000V0Out03VO();
		in.setBasYm(MNBF_BAS_YM);
		rs = OfficeRentalPLStatus(in);
		
		// 조회기준 전월 수익, 비용		
		BigDecimal MnbfOfcbldRentErn = rs.getOfcbldRentErn().divide(WUNT, 2, BigDecimal.ROUND_HALF_UP ).setScale(2, RoundingMode.DOWN);
		BigDecimal MnbfOfcbldRentCt  = rs.getOfcbldRentCt().divide(WUNT, 2, BigDecimal.ROUND_HALF_UP ).setScale(2, RoundingMode.DOWN);
		
		System.out.print("MnbfOfcbldRentErn = " + MnbfOfcbldRentErn + " " + "MnbfOfcbldRentCt" + MnbfOfcbldRentCt + "\n");
		
		ININ1000V0Out03VO result = new ININ1000V0Out03VO();
		result.setOfcbldRentErn(OfcbldRentErn);
		result.setOfcbldRentCt(OfcbldRentCt);
		result.setMnbfOfcbldRentErn(MnbfOfcbldRentErn);
		result.setMnbfOfcbldRentCt(MnbfOfcbldRentCt);
//		result.setMnbfOfcbldRentErn(OfcbldRentErn.subtract(MnbfOfcbldRentErn));
//		result.setMnbfOfcbldRentCt(OfcbldRentCt.subtract(MnbfOfcbldRentCt));

		result.setBasYm(BAS_YM);
		return result;
	}
	
	/* Today 나의업무 */
	@Override
	public List<ININ1000V0Out00VO> selectTodayBzChprList(ININ1000V0In00VO vo) {
		// TODO Auto-generated method stub
		return dao.selectTodayBzChprList(vo);
	}
	
	/* 총무접수현황 */
	@Override
	public List<ININ1000V0Out04VO> selectGeafRctPstt() {
		// TODO Auto-generated method stub
		
		String QryEndDt  = DateUtil.getTodayString("yyyyMMdd");
		String QryStrtDt = DateUtil.getAddDay(QryEndDt, -13);
		
		System.out.print("QryStrtDt = " + QryStrtDt +" " + "QryEndDt = " + QryEndDt + "\n");
		
		ININ1000V0In02VO inVo = new ININ1000V0In02VO();
		inVo.setQryStrtDt(QryStrtDt);
		inVo.setQryEndDt(QryEndDt);
		
		return dao.selectGeafRctPstt(inVo);
	}
	
	/* 신규계약현황 */
	@Override
	public List<ININ1000V0Out05VO> selectNewCntcPstt() {
		// TODO Auto-generated method stub
		String QryEndDt  = DateUtil.getTodayString("yyyyMMdd");
		String QryStrtDt = DateUtil.getAddDay(QryEndDt, -365);
		
		GACM1000U0In00VO inVo = new GACM1000U0In00VO(); 
		inVo.setQryStrtDt(QryStrtDt);
		inVo.setQryEndDt(QryEndDt);
		return dao.selectNewCntcPstt(inVo);
	}
	
}

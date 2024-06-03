package com.miraeasset.biz.br.rb.service;

import com.miraeasset.biz.br.rb.vo.BRRB2000V0In00VO;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0Out00VO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BRRB2000V0Service {
    private final BRRB3000V0Service brrb3000V0Service;
    private final BRRB4000V0Service brrb4000V0Service;

    public BRRB2000V0Service(BRRB3000V0Service brrb3000V0Service, BRRB4000V0Service brrb4000V0Service) {
        this.brrb3000V0Service = brrb3000V0Service;
        this.brrb4000V0Service = brrb4000V0Service;
    }

    public BRRB2000V0Out00VO getOfficeRentalPLStatus(BRRB2000V0In00VO brrb2000V0In00VO) {
        // 1. 상위항목 정의
        BRRB2000V0Out00VO result = new BRRB2000V0Out00VO(4, 1, "결과");

        BRRB2000V0Out00VO revenue = new BRRB2000V0Out00VO(3, 1, "매출");
        BRRB2000V0Out00VO expense = new BRRB2000V0Out00VO(3, 2, "비용");
        BRRB2000V0Out00VO profitAndLoss = new BRRB2000V0Out00VO(3, 3, "손익");

        BRRB2000V0Out00VO rentalRevenue = new BRRB2000V0Out00VO(2, 1, "임대매출");
        BRRB2000V0Out00VO selfBranchRevenue = new BRRB2000V0Out00VO(2, 2, "자가지점 환산수익");

        BRRB2000V0Out00VO propertyTax = new BRRB2000V0Out00VO(2, 1, "재산세금");

        BRRB2000V0Out00VO sumOfRevenue = new BRRB2000V0Out00VO(1, 99, "매출합계");
        BRRB2000V0Out00VO sumOfExpense = new BRRB2000V0Out00VO(1, 99, "비용합계");
        BRRB2000V0Out00VO profitSubCost = new BRRB2000V0Out00VO(1, 1, "매출-비용");

        /* 2-1. 하위항목 추가(RANK-1) */
        // 결과
        result.addChildAcsjList(revenue);
        result.addChildAcsjList(expense);
        result.addChildAcsjList(profitAndLoss);

        /* 2-2. 하위항목 추가(RANK-2) */
        // 매출-임대매출
        rentalRevenue.addChildAcsjList(brrb3000V0Service.getDepositInterest(brrb2000V0In00VO));
        rentalRevenue.addChildAcsjList(brrb3000V0Service.getRentalSalesTaxInvoice(brrb2000V0In00VO));
        rentalRevenue.addChildAcsjList(brrb3000V0Service.getRentalSalesInvoice(brrb2000V0In00VO));
        rentalRevenue.addChildAcsjList(brrb3000V0Service.getRentalParkingFee(brrb2000V0In00VO));

        // 매출-자가지점 환산수익
        selfBranchRevenue.addChildAcsjList(brrb3000V0Service.getSelfBranchDepositInterest(brrb2000V0In00VO));
        selfBranchRevenue.addChildAcsjList(brrb3000V0Service.getSelfBranchLeaseFee(brrb2000V0In00VO));

        // 재산세금
        propertyTax.addChildAcsjList(brrb4000V0Service.getPropertyTax(brrb2000V0In00VO));
        propertyTax.addChildAcsjList(brrb4000V0Service.getOtherTaxesAndDuties(brrb2000V0In00VO));
        propertyTax.addChildAcsjList(brrb4000V0Service.getEstateTax(brrb2000V0In00VO));
        propertyTax.addChildAcsjList(brrb4000V0Service.getRoadOccupationFee(brrb2000V0In00VO));
        propertyTax.addChildAcsjList(brrb4000V0Service.getTrafficInducedBurdenFee(brrb2000V0In00VO));
        propertyTax.addChildAcsjList(brrb4000V0Service.getCorporateEqualResidentTax(brrb2000V0In00VO));

        /* 2-3. 하위항목 추가(RANK-3) */
        // 매출
        revenue.addChildAcsjList(rentalRevenue);
        revenue.addChildAcsjList(selfBranchRevenue);
        revenue.addChildAcsjList(sumOfRevenue);

        // 비용
        expense.addChildAcsjList(propertyTax);
        expense.addChildAcsjList(brrb4000V0Service.getHeatingFuelExpense(brrb2000V0In00VO));
        expense.addChildAcsjList(brrb4000V0Service.getElectricityBill(brrb2000V0In00VO));
        expense.addChildAcsjList(brrb4000V0Service.getWaterBill(brrb2000V0In00VO));
        expense.addChildAcsjList(brrb4000V0Service.getGeneralFee(brrb2000V0In00VO));
        expense.addChildAcsjList(brrb4000V0Service.getOfficeAdministrationExpense(brrb2000V0In00VO));
        expense.addChildAcsjList(brrb4000V0Service.getConsumableExpense(brrb2000V0In00VO));
        expense.addChildAcsjList(brrb4000V0Service.getBuildingRepairExpense(brrb2000V0In00VO));
        expense.addChildAcsjList(brrb4000V0Service.getMaintenanceFee(brrb2000V0In00VO));
        expense.addChildAcsjList(sumOfExpense);



        /* 3. 합계항목 계산 */
        sumOfRevenue.setSumA(revenue.getChildSumA());
        sumOfExpense.setSumA(expense.getChildSumA());

        // 손익
        profitSubCost.setSumA( sumOfRevenue.getSumA().subtract(sumOfExpense.getSumA()) ); /* [20231024] 매출-손익 계산 */
        profitAndLoss.addChildAcsjList(profitSubCost);
        profitAndLoss.setSumA( profitAndLoss.getChildSumA() );


        return result;
    }

    /* 비용 합계 획득 */
    public BRRB2000V0Out00VO getOfficeRentalPLStatusExpense(@RequestBody BRRB2000V0In00VO brrb2000V0In00VO) {
        List<BRRB2000V0Out00VO> result = new ArrayList<>();

        int index = 0;
        BigDecimal sumA = null;

        // 4000
        result.add(brrb4000V0Service.getPropertyTax(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getOtherTaxesAndDuties(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getEstateTax(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getRoadOccupationFee(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getTrafficInducedBurdenFee(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getCorporateEqualResidentTax(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getHeatingFuelExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getElectricityBill(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getWaterBill(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getGeneralFee(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getOfficeAdministrationExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getConsumableExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getBuildingRepairExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getMaintenanceFee(brrb2000V0In00VO));
        sumA = BigDecimal.valueOf(0);
        for(int i = index; i < result.size(); i++) {
            sumA = sumA.add(result.get(i).getSumA());
        }
        return new BRRB2000V0Out00VO(0, 0, null, sumA);
    }

    /* 매출 합계 획득 */
    public BRRB2000V0Out00VO getOfficeRentalPLStatusRevenue(@RequestBody BRRB2000V0In00VO brrb2000V0In00VO) {
        List<BRRB2000V0Out00VO> result = new ArrayList<>();

        int index = 0;
        BigDecimal sumA = null;

        // 3000
        result.add(brrb3000V0Service.getDepositInterest(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getRentalSalesTaxInvoice(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getRentalSalesInvoice(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getRentalParkingFee(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getSelfBranchDepositInterest(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getSelfBranchLeaseFee(brrb2000V0In00VO));
        sumA = BigDecimal.valueOf(0);
        for(int i = index; i < result.size(); i++) {
            sumA = sumA.add(result.get(i).getSumA());
        }
        return new BRRB2000V0Out00VO(0, 0, null, sumA);
    }
}

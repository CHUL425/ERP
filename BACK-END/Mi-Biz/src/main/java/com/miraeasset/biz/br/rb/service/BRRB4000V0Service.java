package com.miraeasset.biz.br.rb.service;

import com.miraeasset.biz.br.rb.dao.BRRB4000V0Dao;
import com.miraeasset.biz.br.rb.vo.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BRRB4000V0Service {

    private final BRRB4000V0Dao brrb4000V0Dao;

    public BRRB4000V0Service(BRRB4000V0Dao brrb4000V0Dao) {
        this.brrb4000V0Dao = brrb4000V0Dao;
    }

    /**
     * 가) 재산세
     */
    public BRRB2000V0Out00VO getPropertyTax(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270150301", "재산세(건축물)납부", "");
        BigDecimal result1 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);
        brrb4000V0In00VO.setDscptSmryCn("재산세납부(토지)");
        BigDecimal result2 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);

        BigDecimal result = result1.add(result2);
        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 1, "제산세", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 가) 기타제세금
     */
    public BRRB2000V0Out00VO getOtherTaxesAndDuties(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270150204", "등록면허세", "홍천");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);
        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 2, "기타제세금", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 가) 종합부동산세
     */
    public BRRB2000V0Out00VO getEstateTax(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270150308", "", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);
        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 3, "종합부동산세", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 가) 도로점용료
     */
    public BRRB2000V0Out00VO getRoadOccupationFee(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270150303", "", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);
        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 4, "도로점용료", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 가) 교통유발부담금
     */
    public BRRB2000V0Out00VO getTrafficInducedBurdenFee(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270150305", "", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);
        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 5, "교통유발부담금", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 가) 법인균등주민세
     */
    public BRRB2000V0Out00VO getCorporateEqualResidentTax(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270150202", "주민세(사업소분)", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);
        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 6, "법인균등주민세", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 나) 난방연료비
     */
    public BRRB2000V0Out00VO getHeatingFuelExpense(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270161301", "", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP); // [20231024] 절사

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 1, "난방연료비", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 나) 전기료
     */
    public BRRB2000V0Out00VO getElectricityBill(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270161202", "", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP); // [20231024] 절사

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 2, "전기료", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 나) 수도료
     */
    public BRRB2000V0Out00VO getWaterBill(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270161201", "", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);
        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 3, "수도료", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 다) 기타일반수수료
     */
    public BRRB2000V0Out00VO getGeneralFee(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270070401", "창원", "");
        BigDecimal result1 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);
        brrb4000V0In00VO.setDscptSmryCn("미래에셋컨설팅");
        BigDecimal result2 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO);

        BigDecimal result = result1.add(result2);
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP); // [20231024] 절사

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 4, "기타일반수수료", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 라) 사옥관리잡비
     */
    public BRRB2000V0Out00VO getOfficeAdministrationExpense(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270163701", "", "홍천");
        BigDecimal result1 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);
        brrb4000V0In00VO.setAcsjCd("5270163702");
        brrb4000V0In00VO.setExpDscptSmryCn("");
        BigDecimal result2 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);

        BigDecimal result = result1.add(result2);
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP); // [20231024] 절사

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 5, "사옥관리잡비", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 마) 소모품비
     */
    public BRRB2000V0Out00VO getConsumableExpense(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270161403", "사옥", "휘트니스");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP); // [20231024] 절사

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 6, "소모품비", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 바) 건물수선비
     */
    public BRRB2000V0Out00VO getBuildingRepairExpense(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270162201", "", "");
        BigDecimal result = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP); // [20231024] 절사

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 7, "건물수선비", result);
        return brrb2000V0Out00VO;
    }

    /**
     * 사) 유지보수료
     */
    public BRRB2000V0Out00VO getMaintenanceFee(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        BRRB4000V0In00VO brrb4000V0In00VO = new BRRB4000V0In00VO(basYm, "S03001", "5270162104", "사옥", "");
        BigDecimal result1 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);
        brrb4000V0In00VO.setDscptSmryCn("공통");
        BigDecimal result2 = brrb4000V0Dao.selectOne00AT01N101(brrb4000V0In00VO).divide(BigDecimal.valueOf(1.1), 2, BigDecimal.ROUND_HALF_UP);

        BigDecimal result = result1.add(result2);
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP); // [20231024] 절사


        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO(1, 8, "유지보수료", result);
        return brrb2000V0Out00VO;
    }


    /**
     * 비용추이 조회
     */
    public List<BRRB4000V0Out01VO> getExpenseTrend(BRRB2000V0In01VO brrb2000V0In01VO) {
        List<BRRB4000V0Out01VO> brrb4000V0Out01VOList = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            String basYm = brrb2000V0In01VO.getBasYm(i);
            BRRB2000V0In00VO brrb2000V0In00VO = new BRRB2000V0In00VO(basYm);

            BRRB4000V0Out01VO brrb4000V0Out01VO = new BRRB4000V0Out01VO();
            brrb4000V0Out01VO.setBasYm(basYm);

            // 사옥관리잡비
            BigDecimal officeAdministrationExpense = this.getOfficeAdministrationExpense(brrb2000V0In00VO).getSumA();
            brrb4000V0Out01VO.setOfficeAdministrationExpense(officeAdministrationExpense);

            // 건물수선비
            BigDecimal buildingRepairExpense = this.getBuildingRepairExpense(brrb2000V0In00VO).getSumA();
            brrb4000V0Out01VO.setBuildingRepairExpense(buildingRepairExpense);

            // 난방연료비
            BigDecimal heatingFuelExpense = this.getHeatingFuelExpense(brrb2000V0In00VO).getSumA();
            brrb4000V0Out01VO.setHeatingFuelExpense(heatingFuelExpense);

            // 수도전기료
            BigDecimal waterBill = this.getWaterBill(brrb2000V0In00VO).getSumA();
            BigDecimal electricityBill = this.getElectricityBill(brrb2000V0In00VO).getSumA();
            brrb4000V0Out01VO.setWaterAndElectricityBill(waterBill.add(electricityBill));

            // 소모품비
            BigDecimal consumableExpense = this.getConsumableExpense(brrb2000V0In00VO).getSumA();
            brrb4000V0Out01VO.setConsumableExpense(consumableExpense);

            // 유지보수료
            BigDecimal maintenanceFee = this.getMaintenanceFee(brrb2000V0In00VO).getSumA();
            brrb4000V0Out01VO.setMaintenanceFee(maintenanceFee);

            // 재산세
            BigDecimal propertyTax = this.getPropertyTax(brrb2000V0In00VO).getSumA();
            // [20231110] 재산세에 하위항목 추가
            BigDecimal otherTaxesAndDuties = this.getOtherTaxesAndDuties(brrb2000V0In00VO).getSumA();
            BigDecimal estateTax = this.getEstateTax(brrb2000V0In00VO).getSumA();
            BigDecimal roadOccupationFee = this.getRoadOccupationFee(brrb2000V0In00VO).getSumA();
            BigDecimal trafficInducedBurdenFee = this.getTrafficInducedBurdenFee(brrb2000V0In00VO).getSumA();
            BigDecimal corporateEqualResidentTax = this.getCorporateEqualResidentTax(brrb2000V0In00VO).getSumA();
            propertyTax = propertyTax.add(otherTaxesAndDuties)
                                     .add(estateTax)
                                     .add(roadOccupationFee)
                                     .add(trafficInducedBurdenFee)
                                     .add(corporateEqualResidentTax);

            brrb4000V0Out01VO.setPropertyTax(propertyTax);

            // 기타일반수수료
            BigDecimal generalFee = this.getGeneralFee(brrb2000V0In00VO).getSumA();
            brrb4000V0Out01VO.setGeneralFee(generalFee);

            // 합계
            brrb4000V0Out01VO.setSummation(brrb4000V0Out01VO.getSummation());
            brrb4000V0Out01VOList.add(brrb4000V0Out01VO);
        }

        // 전체 합계 ROW
        BigDecimal sumOfOfficeAdministrationExpense = BigDecimal.valueOf(0);
        BigDecimal sumOfBuildingRepairExpense = BigDecimal.valueOf(0);
        BigDecimal sumOfHeatingFuelExpense = BigDecimal.valueOf(0);
        BigDecimal sumOfWaterAndElectricityBill = BigDecimal.valueOf(0);
        BigDecimal sumOfConsumableExpense = BigDecimal.valueOf(0);
        BigDecimal sumOfMaintenanceFee = BigDecimal.valueOf(0);
        BigDecimal sumOfPropertyTax = BigDecimal.valueOf(0);
        BigDecimal sumOfGeneralFee = BigDecimal.valueOf(0);
        for (BRRB4000V0Out01VO brrb4000V0Out01VO : brrb4000V0Out01VOList) {
            sumOfOfficeAdministrationExpense = sumOfOfficeAdministrationExpense.add(brrb4000V0Out01VO.getOfficeAdministrationExpense());
            sumOfBuildingRepairExpense = sumOfBuildingRepairExpense.add(brrb4000V0Out01VO.getBuildingRepairExpense());
            sumOfHeatingFuelExpense = sumOfHeatingFuelExpense.add(brrb4000V0Out01VO.getHeatingFuelExpense());
            sumOfWaterAndElectricityBill = sumOfWaterAndElectricityBill.add(brrb4000V0Out01VO.getWaterAndElectricityBill());
            sumOfConsumableExpense = sumOfConsumableExpense.add(brrb4000V0Out01VO.getConsumableExpense());
            sumOfMaintenanceFee = sumOfMaintenanceFee.add(brrb4000V0Out01VO.getMaintenanceFee());
            sumOfPropertyTax = sumOfPropertyTax.add(brrb4000V0Out01VO.getPropertyTax());
            sumOfGeneralFee = sumOfGeneralFee.add(brrb4000V0Out01VO.getGeneralFee());
        }
        BRRB4000V0Out01VO brrb4000V0Out01VO = new BRRB4000V0Out01VO();
        brrb4000V0Out01VO.setBasYm("합계");
        brrb4000V0Out01VO.setOfficeAdministrationExpense(sumOfOfficeAdministrationExpense);
        brrb4000V0Out01VO.setBuildingRepairExpense(sumOfBuildingRepairExpense);
        brrb4000V0Out01VO.setHeatingFuelExpense(sumOfHeatingFuelExpense);
        brrb4000V0Out01VO.setWaterAndElectricityBill(sumOfWaterAndElectricityBill);
        brrb4000V0Out01VO.setConsumableExpense(sumOfConsumableExpense);
        brrb4000V0Out01VO.setMaintenanceFee(sumOfMaintenanceFee);
        brrb4000V0Out01VO.setPropertyTax(sumOfPropertyTax);
        brrb4000V0Out01VO.setGeneralFee(sumOfGeneralFee);
        brrb4000V0Out01VO.setSummation(brrb4000V0Out01VO.getSummation()); // 합계
        brrb4000V0Out01VOList.add(brrb4000V0Out01VO); // 리스트에 추가

        return brrb4000V0Out01VOList;
    }
}

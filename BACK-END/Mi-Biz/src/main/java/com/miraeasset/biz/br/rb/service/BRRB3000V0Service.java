package com.miraeasset.biz.br.rb.service;

import com.miraeasset.biz.br.rb.dao.BRRB3000V0Dao;
import com.miraeasset.biz.br.rb.vo.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BRRB3000V0Service {
    private final BRRB3000V0Dao brrb3000V0Dao;
    private final BRRB1000U0Service brrb1000U0Service;

    public BRRB3000V0Service(BRRB3000V0Dao brrb3000V0Dao, BRRB1000U0Service brrb1000U0Service) {
        this.brrb3000V0Dao = brrb3000V0Dao;
        this.brrb1000U0Service = brrb1000U0Service;
    }

    /**
     * 1-가) 보증금 운용수익
     */
    public BRRB2000V0Out00VO getDepositInterest(BRRB2000V0In00VO brrb2000V0In00VO) {
        String basYm = brrb2000V0In00VO.getBasYm();
        int year = Integer.parseInt(basYm.substring(0, 4));
        int month = Integer.parseInt(basYm.substring(4, 6));
        BigDecimal sumOfDeposit = brrb3000V0Dao.selectOne00AT08N123(brrb2000V0In00VO);
        BigDecimal internalTransferRate = brrb3000V0Dao.selectOne00AT03N332(brrb2000V0In00VO); // 내부이전금리
        BigDecimal lengthOfMonth = BigDecimal.valueOf(LocalDate.of(year, month, 1).lengthOfMonth());
        BigDecimal result = sumOfDeposit.multiply(internalTransferRate).multiply(lengthOfMonth).divide(BigDecimal.valueOf(365), 2, BigDecimal.ROUND_HALF_UP);
        result = result.divide(BigDecimal.valueOf(100), 0, BigDecimal.ROUND_HALF_UP); /* [20231023] 조정원 선임: 나누기 100 해야함 */

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO();
        brrb2000V0Out00VO.setRank(1);
        brrb2000V0Out00VO.setSortSqn(1);
        brrb2000V0Out00VO.setAcsjCdNm("보증금 운용수익");
        brrb2000V0Out00VO.setSumA(result);

        return brrb2000V0Out00VO;
    }

    /**
     * 1-나) 임대료 매출세금계산서
     */
    public BRRB2000V0Out00VO getRentalSalesTaxInvoice(BRRB2000V0In00VO brrb2000V0In00VO) {
        BRRB3000V0In00VO voForSumOfSupa = new BRRB3000V0In00VO();
        voForSumOfSupa.setBasYm(brrb2000V0In00VO.getBasYm());
        voForSumOfSupa.setPchsSalsTcd("1");
        voForSumOfSupa.setEvdnPcd("1");
        voForSumOfSupa.setRsnTcd("001");

        // 매출세금계산서 공급가액 합계
        BigDecimal sumOfSupa = brrb3000V0Dao.selectOne00AT05N401(voForSumOfSupa);

        // 매출세금계산서 공급가액 합계(적요: 홍천)
        voForSumOfSupa.setDscptSmryCn("홍천");
        BigDecimal sumOfSupaOfHongCheon = brrb3000V0Dao.selectOne00AT05N401(voForSumOfSupa);
        voForSumOfSupa.setDscptSmryCn(null);

        // 매출세금계산서 공급가액합계(계정: 주차료)
        voForSumOfSupa.setOcrrAcsjCd("5315010102");
        BigDecimal sumOfSupaOfParkingFee = brrb3000V0Dao.selectOne00AT05N401(voForSumOfSupa);
        voForSumOfSupa.setOcrrAcsjCd(null);

        BigDecimal result = sumOfSupa.subtract(sumOfSupaOfHongCheon).subtract(sumOfSupaOfParkingFee);

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO();
        brrb2000V0Out00VO.setRank(1);
        brrb2000V0Out00VO.setSortSqn(2);
        brrb2000V0Out00VO.setAcsjCdNm("임대료 매출세금계산서");
        brrb2000V0Out00VO.setSumA(result);

        return brrb2000V0Out00VO;
    }

    /**
     * 1-다) 임대료 매출계산서
     */
    public BRRB2000V0Out00VO getRentalSalesInvoice(BRRB2000V0In00VO brrb2000V0In00VO) {
        BRRB3000V0In00VO voForSumOfSupa = new BRRB3000V0In00VO();
        voForSumOfSupa.setBasYm(brrb2000V0In00VO.getBasYm());
        voForSumOfSupa.setPchsSalsTcd("1");
        voForSumOfSupa.setEvdnPcd("2");
        voForSumOfSupa.setRsnTcd("012");

        BigDecimal result = brrb3000V0Dao.selectOne00AT05N401(voForSumOfSupa);

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO();
        brrb2000V0Out00VO.setRank(1);
        brrb2000V0Out00VO.setSortSqn(3);
        brrb2000V0Out00VO.setAcsjCdNm("임대료 매출계산서");
        brrb2000V0Out00VO.setSumA(result);

        return brrb2000V0Out00VO;
    }

    /**
     * 1-라) 임대료 주차료
     */
    public BRRB2000V0Out00VO getRentalParkingFee(BRRB2000V0In00VO brrb2000V0In00VO) {
        BRRB3000V0In00VO voForSumOfSupa = new BRRB3000V0In00VO();
        voForSumOfSupa.setBasYm(brrb2000V0In00VO.getBasYm());
        voForSumOfSupa.setOcrrAcsjCd("5315010102");

        BigDecimal result = brrb3000V0Dao.selectOne00AT05N200(voForSumOfSupa);
        result = result.divide(BigDecimal.valueOf(1.1), 0, BigDecimal.ROUND_HALF_UP); /* [20231024] 조정원 선임: 1.1로 나눠야 함 */

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO();
        brrb2000V0Out00VO.setRank(1);
        brrb2000V0Out00VO.setSortSqn(4);
        brrb2000V0Out00VO.setAcsjCdNm("임대료 주차료");
        brrb2000V0Out00VO.setSumA(result);

        return brrb2000V0Out00VO;
    }

    /**
     * 2-가) 자가지점 보증금 운용수익
     */
    public BRRB2000V0Out00VO getSelfBranchDepositInterest(BRRB2000V0In00VO brrb2000V0In00VO) {
        BRRB1000U0In00VO brrb1000U0In00VO = new BRRB1000U0In00VO();
        brrb1000U0In00VO.setLsSfTcd("02"); // 자가
        brrb1000U0In00VO.setBasYm(brrb2000V0In00VO.getBasYm());

        List<BRRB1000U0Out00VO> brrb1000U0Out00VOList = brrb1000U0Service.getOfficeOccupancyManagement(brrb1000U0In00VO);

        BigDecimal grtA = BigDecimal.valueOf(0);
        BigDecimal internalTransferRate = brrb3000V0Dao.selectOne00AT03N332(brrb2000V0In00VO);

        for (BRRB1000U0Out00VO brrb1000U0Out00VO : brrb1000U0Out00VOList) {
            grtA = grtA.add(brrb1000U0Out00VO.getGrtA());
        }

        BigDecimal result = grtA.multiply(internalTransferRate).divide(BigDecimal.valueOf(12), 0, BigDecimal.ROUND_HALF_UP);
        result = result.divide(BigDecimal.valueOf(100), 0, BigDecimal.ROUND_HALF_UP); /* [20231024] 조정원 선임: 100으로 나눠야 함 */

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO();
        brrb2000V0Out00VO.setRank(1);
        brrb2000V0Out00VO.setSortSqn(1);
        brrb2000V0Out00VO.setAcsjCdNm("자가지점 보증금 운용수익");
        brrb2000V0Out00VO.setSumA(result);

        return brrb2000V0Out00VO;
    }

    /**
     * 2-나) 자가지점 임대료 관리비
     */
    public BRRB2000V0Out00VO getSelfBranchLeaseFee(BRRB2000V0In00VO brrb2000V0In00VO) {
        BigDecimal result = brrb3000V0Dao.selectOne00AT03N531(brrb2000V0In00VO);

        BRRB2000V0Out00VO brrb2000V0Out00VO = new BRRB2000V0Out00VO();
        brrb2000V0Out00VO.setRank(1);
        brrb2000V0Out00VO.setSortSqn(2);
        brrb2000V0Out00VO.setAcsjCdNm("자가지점 임대료+관리비");
        brrb2000V0Out00VO.setSumA(result);

        return brrb2000V0Out00VO;
    }

    /**
     * 매출추이 조회
     */
    public List<BRRB3000V0Out01VO> getRevenueTrend(BRRB2000V0In01VO brrb2000V0In01VO) {
        List<BRRB3000V0Out01VO> brrb3000V0Out01VOList = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            String basYm = brrb2000V0In01VO.getBasYm(i);
            BRRB2000V0In00VO brrb2000V0In00VO = new BRRB2000V0In00VO(basYm);

            BRRB3000V0Out01VO brrb3000V0Out01VO = new BRRB3000V0Out01VO();
            brrb3000V0Out01VO.setBasYm(basYm);

            // 임대매출 - 보증금 운용수익
            BigDecimal depositInterest = this.getDepositInterest(brrb2000V0In00VO).getSumA();
            brrb3000V0Out01VO.setRentalDepositInterest(depositInterest);

            // 임대매출 - 임대료
            BigDecimal rentalSalesTaxInvoice = this.getRentalSalesTaxInvoice(brrb2000V0In00VO).getSumA();
            BigDecimal rentalSalesInvoice = this.getRentalSalesInvoice(brrb2000V0In00VO).getSumA();
            BigDecimal rentalParkingFee = this.getRentalParkingFee(brrb2000V0In00VO).getSumA();
            BigDecimal rentalFee = rentalSalesTaxInvoice.add(rentalSalesInvoice).add(rentalParkingFee);
            brrb3000V0Out01VO.setRentalRentalFee(rentalFee);

            // 자가지점 환산매출 - 보증금 운용수익
            BigDecimal selfBranchDepositInterest = this.getSelfBranchDepositInterest(brrb2000V0In00VO).getSumA();
            brrb3000V0Out01VO.setSelfDepositInterest(selfBranchDepositInterest);

            // 자가지점 환산매출 - 임대료
            BigDecimal selfBranchLeaseFee = this.getSelfBranchLeaseFee(brrb2000V0In00VO).getSumA();
            brrb3000V0Out01VO.setSelfRentalFee(selfBranchLeaseFee);

            // 합계
            brrb3000V0Out01VO.setSummation(brrb3000V0Out01VO.getSummation());
            brrb3000V0Out01VOList.add(brrb3000V0Out01VO);
        }

        // 전체 합계 ROW
        BigDecimal sumOfRentalDepositInterest = BigDecimal.valueOf(0);
        BigDecimal sumOfRentalFee = BigDecimal.valueOf(0);
        BigDecimal sumOfSelfBranchDepositInterest = BigDecimal.valueOf(0);
        BigDecimal sumOfSelfBranchLeaseFee = BigDecimal.valueOf(0);

        for (int i = 0; i < brrb3000V0Out01VOList.size(); i++) {
            sumOfRentalDepositInterest = sumOfRentalDepositInterest.add(brrb3000V0Out01VOList.get(i).getRentalDepositInterest());
            sumOfRentalFee = sumOfRentalFee.add(brrb3000V0Out01VOList.get(i).getRentalRentalFee());
            sumOfSelfBranchDepositInterest = sumOfSelfBranchDepositInterest.add(brrb3000V0Out01VOList.get(i).getSelfDepositInterest());
            sumOfSelfBranchLeaseFee = sumOfSelfBranchLeaseFee.add(brrb3000V0Out01VOList.get(i).getSelfRentalFee());
        }
        BRRB3000V0Out01VO brrb3000V0Out01VO = new BRRB3000V0Out01VO();
        brrb3000V0Out01VO.setBasYm("합계");
        brrb3000V0Out01VO.setRentalDepositInterest(sumOfRentalDepositInterest);
        brrb3000V0Out01VO.setRentalRentalFee(sumOfRentalFee);
        brrb3000V0Out01VO.setSelfDepositInterest(sumOfSelfBranchDepositInterest);
        brrb3000V0Out01VO.setSelfRentalFee(sumOfSelfBranchLeaseFee);
        brrb3000V0Out01VO.setSummation(brrb3000V0Out01VO.getSummation()); // 합계
        brrb3000V0Out01VOList.add(brrb3000V0Out01VO); // 리스트에 추가

        return brrb3000V0Out01VOList;
    }
}

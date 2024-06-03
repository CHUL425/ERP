package com.miraeasset.biz.br.rb.service;

import com.miraeasset.biz.br.rb.vo.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BRRB5000V0Service {
    private final BRRB3000V0Service brrb3000V0Service;
    private final BRRB4000V0Service brrb4000V0Service;

    public BRRB5000V0Service(BRRB3000V0Service brrb3000V0Service, BRRB4000V0Service brrb4000V0Service) {
        this.brrb3000V0Service = brrb3000V0Service;
        this.brrb4000V0Service = brrb4000V0Service;
    }

    /**
     * 순수익추이 조회
     */
    public List<BRRB5000V0Out01VO> getNetProfitTrend(BRRB2000V0In01VO brrb2000V0In01VO) {
        List<BRRB5000V0Out01VO> brrb5000V0Out01VOList = new ArrayList<>();

        List<BRRB3000V0Out01VO> brrb3000V0Out01VOList = brrb3000V0Service.getRevenueTrend(brrb2000V0In01VO);
        List<BRRB4000V0Out01VO> brrb4000V0Out01VOList = brrb4000V0Service.getExpenseTrend(brrb2000V0In01VO);

        for (int i = 1; i <= 12; i++) {
            String basYm = brrb2000V0In01VO.getBasYm(i);
            BRRB5000V0Out01VO brrb5000V0Out01VO = new BRRB5000V0Out01VO();
            brrb5000V0Out01VO.setBasYm(basYm);

            BigDecimal revenue = brrb3000V0Out01VOList.get(i-1).getSummation();
            BigDecimal expense = brrb4000V0Out01VOList.get(i-1).getSummation();

            brrb5000V0Out01VO.setRevenue(revenue);
            brrb5000V0Out01VO.setExpense(expense);
            brrb5000V0Out01VO.setSummation(brrb5000V0Out01VO.getSummation());

            brrb5000V0Out01VOList.add(brrb5000V0Out01VO);
        }

        // 전체 합계 ROW
        BigDecimal sumOfRevenue = BigDecimal.valueOf(0);
        BigDecimal sumOfExpense = BigDecimal.valueOf(0);
        for (BRRB5000V0Out01VO brrb5000V0Out01VO : brrb5000V0Out01VOList) {
            sumOfRevenue = sumOfRevenue.add(brrb5000V0Out01VO.getRevenue());
            sumOfExpense = sumOfExpense.add(brrb5000V0Out01VO.getExpense());
        }
        BRRB5000V0Out01VO brrb5000V0Out01VO = new BRRB5000V0Out01VO();
        brrb5000V0Out01VO.setBasYm("합계");
        brrb5000V0Out01VO.setRevenue(sumOfRevenue);
        brrb5000V0Out01VO.setExpense(sumOfExpense);
        brrb5000V0Out01VO.setSummation(brrb5000V0Out01VO.getSummation()); // 합계
        brrb5000V0Out01VOList.add(brrb5000V0Out01VO); // 리스트에 추가


        return brrb5000V0Out01VOList;
    }
}

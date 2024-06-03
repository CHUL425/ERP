package com.miraeasset.biz.br.rb.controller;

import com.miraeasset.biz.br.rb.service.BRRB5000V0Service;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0In01VO;
import com.miraeasset.biz.br.rb.vo.BRRB4000V0Out01VO;
import com.miraeasset.biz.br.rb.vo.BRRB5000V0Out01VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("api/br/rb/5000")
public class BRRB5000V0Controller {
    private final BRRB5000V0Service brrb5000V0Service;

    public BRRB5000V0Controller(BRRB5000V0Service brrb5000V0Service) {
        this.brrb5000V0Service = brrb5000V0Service;
    }

    @ApiOperation(value = "순수익추이 조회")
    @RequestMapping(value = "/net-profit-trend/get", method = RequestMethod.POST)
    public List<BRRB5000V0Out01VO> getExpenseTrend(@RequestBody BRRB2000V0In01VO brrb2000V0In01VO) {
        return brrb5000V0Service.getNetProfitTrend(brrb2000V0In01VO);
    }

    @ApiOperation(value = "순수익추이 엑셀다운로드")
    @RequestMapping(value = "/expense-trend/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getLeaseStatusExcel(HttpServletResponse response, BRRB2000V0In01VO brrb2000V0In01VO)
            throws IOException {
        String fileName = "순수익추이"+ DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
        List<BRRB5000V0Out01VO> brrb5000V0Out01VOList = this.getExpenseTrend(brrb2000V0In01VO);
        ExcelFile<BRRB5000V0Out01VO> excelFile = new OneSheetExcelFile<>(brrb5000V0Out01VOList, BRRB5000V0Out01VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }
}

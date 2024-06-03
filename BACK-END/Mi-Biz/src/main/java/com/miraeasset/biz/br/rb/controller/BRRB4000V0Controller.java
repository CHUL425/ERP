package com.miraeasset.biz.br.rb.controller;

import com.miraeasset.biz.br.rb.service.BRRB4000V0Service;
import com.miraeasset.biz.br.rb.vo.BRRB1000U0In00VO;
import com.miraeasset.biz.br.rb.vo.BRRB1000U0Out00VO;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0In01VO;
import com.miraeasset.biz.br.rb.vo.BRRB4000V0Out01VO;
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
@RequestMapping("api/br/rb/4000")
public class BRRB4000V0Controller {
    private final BRRB4000V0Service brrb4000V0Service;

    public BRRB4000V0Controller(BRRB4000V0Service brrb4000V0Service) {
        this.brrb4000V0Service = brrb4000V0Service;
    }

    @ApiOperation(value = "비용추이 조회")
    @RequestMapping(value = "/expense-trend/get", method = RequestMethod.POST)
    public List<BRRB4000V0Out01VO> getExpenseTrend(@RequestBody BRRB2000V0In01VO brrb2000V0In01VO) {
        return brrb4000V0Service.getExpenseTrend(brrb2000V0In01VO);
    }

    @ApiOperation(value = "비용추이 엑셀다운로드")
    @RequestMapping(value = "/expense-trend/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getLeaseStatusExcel(HttpServletResponse response, BRRB2000V0In01VO brrb2000V0In01VO)
            throws IOException {
        String fileName = "비용추이_"+ DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
        List<BRRB4000V0Out01VO> brrb4000V0Out01VOList = this.getExpenseTrend(brrb2000V0In01VO);
        ExcelFile<BRRB4000V0Out01VO> excelFile = new OneSheetExcelFile<>(brrb4000V0Out01VOList, BRRB4000V0Out01VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }
}

package com.miraeasset.biz.br.ob.controller;

import com.miraeasset.biz.br.ob.service.BROB1000U0Service;
import com.miraeasset.biz.br.ob.vo.BROB1000U0In00VO;
import com.miraeasset.biz.br.ob.vo.BROB1000U0Out00VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/br/ob/1000")
public class BROB1000U0Controller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final BROB1000U0Service brob1000U0Service;

    public BROB1000U0Controller(BROB1000U0Service brob1000U0Service) {
        this.brob1000U0Service = brob1000U0Service;
    }

    @ApiOperation(value = "사옥개요 코드 조회")
    @RequestMapping(value = "office-overview/code/get", method = RequestMethod.POST)
    public List<Map<String, String>> getOfficeCode() {
        return brob1000U0Service.getOfficeCode();
    }

    @ApiOperation(value = "사옥개요 전체 조회")
    @RequestMapping(value = "office-overview/get/all", method = RequestMethod.POST)
    public List<BROB1000U0Out00VO> getAllOfficeOverview() {
        return brob1000U0Service.getAllOfficeOverview();
    }

    @ApiOperation(value = "사옥개요 전체 엑셀다운로드")
    @RequestMapping(value = "office-overview/get/all/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getAllOfficeOverviewExcel(String temp, HttpServletResponse response)
            throws IOException {
        String fileName = "사옥개요전체_" + DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
        List<BROB1000U0Out00VO> brob1000U0Out00VOList = brob1000U0Service.getAllOfficeOverview();
        ExcelFile<BROB1000U0Out00VO> excelFile = new OneSheetExcelFile<>(brob1000U0Out00VOList, BROB1000U0Out00VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }

    @ApiOperation(value = "사옥개요 조회")
    @RequestMapping(value = "office-overview/get", method = RequestMethod.POST)
    public BROB1000U0Out00VO getOfficeOverview(@RequestBody BROB1000U0In00VO brob1000U0In00VO) {
        return brob1000U0Service.getOfficeOverview(brob1000U0In00VO);
    }

    @ApiOperation(value = "사옥개요 저장")
    @RequestMapping(value = "office-overview/save", method = RequestMethod.POST)
    public int saveOfficeOverview(@RequestBody BROB1000U0Out00VO brob1000U0Out00VO) {
        return brob1000U0Service.saveOfficeOverview(brob1000U0Out00VO);
    }
}

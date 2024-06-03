package com.miraeasset.biz.br.fb.controller;

import com.miraeasset.biz.br.er.vo.BRER1000U0Out00VO;
import com.miraeasset.biz.br.fb.service.BRFB1000U0Service;
import com.miraeasset.biz.br.fb.vo.BRFB1000U0In00VO;
import com.miraeasset.biz.br.fb.vo.BRFB1000U0Out00VO;
import com.miraeasset.biz.br.fb.vo.BRFB1000U0Out01VO;
import com.miraeasset.biz.br.fb.vo.BRFB1000U0Out03VO;
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
import java.util.Map;

@RestController
@RequestMapping("api/br/fb/1000")
public class BRFB1000U0Controller {

    private final BRFB1000U0Service brfb1000U0Service;

    public BRFB1000U0Controller(BRFB1000U0Service brfb1000U0Service) {
        this.brfb1000U0Service = brfb1000U0Service;
    }

    @ApiOperation(value = "지점 리스트 조회")
    @RequestMapping(value = "/branch-list/get", method = RequestMethod.POST)
    public List<Map<String, String>> getCmnKndNo() {
        return brfb1000U0Service.getBranchList();
    }

    @ApiOperation(value = "지점개요 전체 조회")
    @RequestMapping(value = "branch-overview/get/all", method = RequestMethod.POST)
    public List<BRFB1000U0Out00VO> getBranchOverviewAll(@RequestBody BRFB1000U0In00VO brfb1000U0In00VO) {
        return brfb1000U0Service.getBranchOverviewAll(brfb1000U0In00VO);
    }

    @ApiOperation(value = "지점개요 전체 엑셀다운로드")
    @RequestMapping(value = "branch-overview/excel/all", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getBranchOverviewAllExcel(BRFB1000U0In00VO brfb1000U0In00VO, HttpServletResponse response) throws IOException {
        String fileName = "지점개요_전체_"+ DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");

        List<BRFB1000U0Out00VO> brfb1000U0Out00VOList = brfb1000U0Service.getBranchOverviewAll(brfb1000U0In00VO);
        ExcelFile<BRFB1000U0Out00VO> excelFile = new OneSheetExcelFile<>(brfb1000U0Out00VOList, BRFB1000U0Out00VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }

    @ApiOperation(value = "지점개요 상세 조회")
    @RequestMapping(value = "branch-overview/get/detail", method = RequestMethod.POST)
    public BRFB1000U0Out03VO getBranchOverviewDetail(@RequestBody BRFB1000U0In00VO brfb1000U0In00VO) {
        return brfb1000U0Service.getBranchOverviewDetail(brfb1000U0In00VO);
    }

    @ApiOperation(value = "지점개요관리 조회")
    @RequestMapping(value = "branch-overview/management/get", method = RequestMethod.POST)
    public BRFB1000U0Out01VO getBranchOverviewManagement(@RequestBody BRFB1000U0In00VO brfb1000U0In00VO) {
        return brfb1000U0Service.getBranchOverviewManagement(brfb1000U0In00VO);
    }

    @ApiOperation(value = "지점개요관리 저장")
    @RequestMapping(value = "branch-overview/management/save", method = RequestMethod.POST)
    public int saveBranchOverviewManagement(@RequestBody BRFB1000U0Out01VO brfb1000U0Out01VO) {
        return brfb1000U0Service.saveBranchOverviewManagement(brfb1000U0Out01VO);
    }
}

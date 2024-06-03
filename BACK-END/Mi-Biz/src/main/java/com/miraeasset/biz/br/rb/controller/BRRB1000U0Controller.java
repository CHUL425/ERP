package com.miraeasset.biz.br.rb.controller;

import com.miraeasset.biz.br.lb.vo.BRLB1000V0In00VO;
import com.miraeasset.biz.br.lb.vo.BRLB1000V0Out00VO;
import com.miraeasset.biz.br.rb.service.BRRB1000U0Service;
import com.miraeasset.biz.br.rb.vo.*;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("api/br/rb/1000")
public class BRRB1000U0Controller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final BRRB1000U0Service brrb1000U0Service;

    @Autowired
    public BRRB1000U0Controller(BRRB1000U0Service brrb1000U0Service) {
        this.brrb1000U0Service = brrb1000U0Service;
    }

//    @ApiOperation(value="사옥입주관리 조회")
//    @RequestMapping(value ="office-occupancy-management/get", method = RequestMethod.POST)
//    public List<BRRB1000U0Out00VO> getOfficeOccupancyManagement(@RequestBody BRRB1000U0In00VO brrb1000U0In00VO) {
//        return brrb1000U0Service.getOfficeOccupancyManagement(brrb1000U0In00VO);
//    }

    @ApiOperation(value = "사옥입주관리-본지점임차현황")
    @RequestMapping(value = "office-occupancy-management/ls/get", method = RequestMethod.POST)
    public List<BRRB1000U0Out00VO> getOfficeOccupancyManagementLease(@RequestBody BRRB1000U0In00VO brrb1000U0In00VO) {
        brrb1000U0In00VO.setLsSfTcd("01");
        return brrb1000U0Service.getOfficeOccupancyManagement(brrb1000U0In00VO);
    }

    @ApiOperation(value = "사옥입주관리-자가지점현황")
    @RequestMapping(value = "office-occupancy-management/sf/get", method = RequestMethod.POST)
    public List<BRRB1000U0Out00VO> getOfficeOccupancyManagementSelf(@RequestBody BRRB1000U0In00VO brrb1000U0In00VO) {
        brrb1000U0In00VO.setLsSfTcd("02");
        return brrb1000U0Service.getOfficeOccupancyManagement(brrb1000U0In00VO);
    }

    @ApiOperation(value = "사옥입주관리 엑셀다운로드")
    @RequestMapping(value = "office-occupancy-management/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getLeaseStatusExcel(HttpServletResponse response, BRRB1000U0In00VO brrb1000U0In00VO)
            throws IOException {
        String fileName = "사옥입주관리_"+ DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
        List<BRRB1000U0Out00VO> brrb1000U0Out00VOList = brrb1000U0Service.getOfficeOccupancyManagement(brrb1000U0In00VO);
        ExcelFile<BRRB1000U0Out00VO> excelFile = new OneSheetExcelFile<>(brrb1000U0Out00VOList, BRRB1000U0Out00VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }

    @ApiOperation(value="자가지점관리 상세 조회")
    @RequestMapping(value = "self-branch-management/get", method = RequestMethod.POST)
    public BRRB1000U0Out01VO getSelfBranchManagementDetail(@RequestBody BRRB1000U0In01VO brrb1000U0In01VO) {
        return brrb1000U0Service.getSelfBranchManagementDetail(brrb1000U0In01VO);
    }

    @ApiOperation(value = "자가지점관리 상세 저장")
    @RequestMapping(value = "self-branch-management/save", method = RequestMethod.POST)
    public int saveSelfBranchManagementDetail(@RequestBody BRRB1000U0Out01VO brrb1000U0Out01VO) {
        return brrb1000U0Service.saveSelfBranchManagementDetail(brrb1000U0Out01VO);
    }

    @ApiOperation(value = "자가지점관리 상세 삭제")
    @RequestMapping(value = "self-branch-management/delete", method = RequestMethod.POST)
    public int deleteSelfBranchManagementDetail(@RequestBody BRRB1000U0In01VO brrb1000U0In01VO) {
        return brrb1000U0Service.deleteSelfBranchManagementDetail(brrb1000U0In01VO);
    }

    @ApiOperation(value = "사옥임대현황 조회")
    @RequestMapping(value = "office-rental-status/get", method = RequestMethod.POST)
    public BRRB1000U0Out02VO getOfficeRentalStatus(@RequestBody BRRB1000U0In02VO brrb1000U0In02VO) {
        return brrb1000U0Service.getOfficeRentalStatus(brrb1000U0In02VO);
    }
}

package com.miraeasset.biz.br.lb.controller;

import com.miraeasset.biz.br.lb.service.BRLB1000V0Service;
import com.miraeasset.biz.br.lb.vo.*;
import com.miraeasset.biz.common.cm.bs.vo.CMBS1000V0Out00VO;
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
@RequestMapping("/api/br/lb/1000")
public class BRLB1000V0Controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final BRLB1000V0Service brlb1000V0Service;

    @Autowired
    public BRLB1000V0Controller(BRLB1000V0Service brlb1000V0Service) {
        this.brlb1000V0Service = brlb1000V0Service;
    }

    @ApiOperation(value="임차료/관리비 계정과목코드 조회")
    @RequestMapping(value ="getRentalAndMaintenanceAccountSubjectCode", method = RequestMethod.POST)
    public List<CMBS1000V0Out00VO> getRentalAndMaintenanceAccountSubjectCode(@RequestBody BRLB1000V0In01VO in01VO) {
        return brlb1000V0Service.getRentalAndMaintenanceAccountSubjectCode(in01VO);
    }

    @ApiOperation(value="임차료/관리비현황 조회")
    @RequestMapping(value = "getRentalAndMaintenanceFee", method = RequestMethod.POST)
    public List<BRLB1000V0Out02VO> getRentalAndMaintenanceFee(@RequestBody BRLB1000V0In02VO in02VO) {
        return brlb1000V0Service.getRentalAndMaintenanceFee(in02VO);
    }

    @ApiOperation(value = "임차료/관리비현황 엑셀다운로드")
    @RequestMapping(value = "getRentalAndMaintenanceFee/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getRentalAndMaintenanceFeeExcel(HttpServletResponse response, BRLB1000V0In02VO in02VO)
            throws IOException {
        String fileName = "임차료관리비현황_" + DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
        List<BRLB1000V0Out02VO> brlb1000V0Out02VOList = brlb1000V0Service.getRentalAndMaintenanceFee(in02VO);
        ExcelFile<BRLB1000V0Out02VO> excelFile = new OneSheetExcelFile<>(brlb1000V0Out02VOList, BRLB1000V0Out02VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }

    @ApiOperation(value="본지점임차현황 조회")
    @RequestMapping(value = "getLeaseStatus", method = RequestMethod.POST)
    public List<BRLB1000V0Out00VO> getLeaseStatus(@RequestBody BRLB1000V0In00VO in00VO) {
        return brlb1000V0Service.getLeaseStatus(in00VO);
    }

    @ApiOperation(value = "본지점임차현황 엑셀다운로드")
    @RequestMapping(value = "getLeaseStatus/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getLeaseStatusExcel(HttpServletResponse response, BRLB1000V0In00VO in00VO)
            throws IOException {
        String fileName = "본지점임차현황_"+ DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
        List<BRLB1000V0Out00VO> brlb1000V0Out00VOList = brlb1000V0Service.getLeaseStatus(in00VO);
        ExcelFile<BRLB1000V0Out00VO> excelFile = new OneSheetExcelFile<>(brlb1000V0Out00VOList, BRLB1000V0Out00VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }
    
    @ApiOperation(value="지점임차비용 비교 조회")
    @RequestMapping(value = "selectAT08N101ByOrz", method = RequestMethod.POST)
    public List<BRLB1000V0Out03VO> selectAT08N101ByOrz(@RequestBody BRLB1000V0In03VO inVO) {
        return brlb1000V0Service.selectAT08N101ByOrz(inVO);
    }
    
    @ApiOperation(value = "지점임차비용 비교 엑셀다운로드")
    @RequestMapping(value = "excelByOrz", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getAT08N101ByOrzExcel(HttpServletResponse response, BRLB1000V0In03VO inVO) throws IOException {
        String fileName = "지점임차비용 비교_"+ DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
        List<BRLB1000V0Out03VO> excelList = brlb1000V0Service.selectAT08N101ByOrz(inVO);
        ExcelFile<BRLB1000V0Out03VO> excelFile = new OneSheetExcelFile<>(excelList, BRLB1000V0Out03VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }
}

package com.miraeasset.biz.br.er.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import com.miraeasset.biz.br.er.service.BRER1000U0Service;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0In10VO;
import com.miraeasset.biz.ga.cm.vo.GACM1000U0Out10VO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.miraeasset.biz.br.er.vo.BRER1000U0In00VO;
import com.miraeasset.biz.br.er.vo.BRER1000U0Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/br/er/1000")
public class BRER1000U0Controller extends CustomRequestException {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final BRER1000U0Service brer1000U0Service;

    public BRER1000U0Controller(BRER1000U0Service brer1000U0Service) {
        this.brer1000U0Service = brer1000U0Service;
    }


    /**
     * 지점실내/외관리 CCTV 조회
     */
    @ApiOperation(value = "CCTV 조회")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public List<BRER1000U0Out00VO> selectList00GA02N002(@RequestBody BRER1000U0In00VO brer1000U0In00VO) {
        return brer1000U0Service.selectList00GA02N002(brer1000U0In00VO);
    }

    /**
     * 지점실내/외관리 CCTV 관리
     */
    @ApiOperation(value = "CCTV 저장")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public int merge00GA02N002(@RequestBody List<BRER1000U0Out00VO> brer1000U0Out00VOList) {
        return brer1000U0Service.merge00GA02N002(brer1000U0Out00VOList);
    }


    /**
     * 지점실내/외관리 CCTV 삭제
     */
    @ApiOperation(value = "CCTV 삭제")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public int delete00GA02N002(@RequestBody List<BRER1000U0In00VO> brer1000U0In00VOList) {
        return brer1000U0Service.delete00GA02N002(brer1000U0In00VOList);
    }

    /**
     * 지점실내/외관리 CCTV 엑셀다운로드
     */
    @ApiOperation(value="CCTV 엑셀다운로드")
    @RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void downloadExcel2(BRER1000U0In00VO brer1000U0In00VO, HttpServletResponse response) throws IOException {

        String fileName = "CCTV_"+ DateUtil.getDate()+".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");

        List<BRER1000U0Out00VO> list = brer1000U0Service.selectList00GA02N002(brer1000U0In00VO);
        ExcelFile<BRER1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, BRER1000U0Out00VO.class, new DefaultDataFormatDecider());
        excelFile.write2(response, downFileName);
    }
}

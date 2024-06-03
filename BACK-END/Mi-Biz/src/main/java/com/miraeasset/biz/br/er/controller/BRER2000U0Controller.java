package com.miraeasset.biz.br.er.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.miraeasset.biz.br.er.service.BRER2000U0Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.br.er.vo.BRER2000U0In00VO;
import com.miraeasset.biz.br.er.vo.BRER2000U0Out00VO;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/br/er/2000")
public class BRER2000U0Controller extends CustomRequestException {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final BRER2000U0Service brer2000U0Service;

    public BRER2000U0Controller(BRER2000U0Service brer2000U0Service) {
        this.brer2000U0Service = brer2000U0Service;
    }

    /**
     * 지점실내/외관리 UPS 조회
     */
    @ApiOperation(value = "UPS 조회")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public List<BRER2000U0Out00VO> selectList00GA02N002(@RequestBody BRER2000U0In00VO brer2000U0In00VO) {
        return  brer2000U0Service.selectList00GA02N003(brer2000U0In00VO);
    }

    /**
     * 지점실내/외관리 UPS 관리
     */
    @ApiOperation(value = "UPS 관리")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public int insert00GA02N003(@RequestBody List<BRER2000U0Out00VO> brer2000U0Out00VOList) {
        return brer2000U0Service.merge00GA02N003(brer2000U0Out00VOList);
    }


    /**
     * 지점실내/외관리 UPS 삭제
     */
    @ApiOperation(value = "UPS 삭제")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public int delete00GA02N003(@RequestBody List<BRER2000U0In00VO> brer2000U0In00VOList) {
        return brer2000U0Service.delete00GA02N003(brer2000U0In00VOList);
    }

    /**
     * UPS 엑셀다운로드
     */
    @ApiOperation(value = "UPS 엑셀다운로드")
    @RequestMapping(value = "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void downloadExcel(BRER2000U0In00VO vo, HttpServletResponse response) throws IOException {

        String fileName = "지점실내외관리_UPS_" + DateUtil.getDate() + ".xlsx";
        String downFileName = URLEncoder.encode(fileName, "UTF-8");

        response.setHeader("Content-Disposition", "attachment; fileName=\"" + downFileName + "\"");

        List<BRER2000U0Out00VO> list = brer2000U0Service.selectList00GA02N003(vo);
        ExcelFile<BRER2000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, BRER2000U0Out00VO.class);

        excelFile.write2(response, downFileName);
    }

}

package com.miraeasset.biz.ss.bs.controller;

import com.miraeasset.biz.ss.bs.service.SSBS8000U0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0Out01VO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ss/bs/8000")
public class SSBS8000U0Controller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final SSBS8000U0Service ssbs8000U0Service;

    public SSBS8000U0Controller(SSBS8000U0Service ssbs8000U0Service) {
        this.ssbs8000U0Service = ssbs8000U0Service;
    }

    @ApiOperation(value = "공통코드종류 조회")
    @RequestMapping(value = "/cmn-knd-no/get", method = RequestMethod.POST)
    public List<SSBS8000U0Out00VO> getCmnKndNo(@RequestBody  SSBS8000U0In00VO ssbs8000U0In00VO) {
        return ssbs8000U0Service.getCmnKndNo(ssbs8000U0In00VO);
    }

    @ApiOperation(value = "공통코드종류 저장")
    @RequestMapping(value = "/cmn-knd-no/save", method = RequestMethod.POST)
    public int saveCmnKndNo(@RequestBody SSBS8000U0Out00VO ssbs8000U0Out00VO) {
        return ssbs8000U0Service.saveCmnKndNo(ssbs8000U0Out00VO);
    }

    @ApiOperation(value = "공통코드종류 삭제")
    @RequestMapping(value = "/cmn-knd-no/delete", method = RequestMethod.POST)
    public int deleteCmnKndNo(@RequestBody SSBS8000U0In00VO ssbs8000U0In00VO) {
        return ssbs8000U0Service.deleteCmnKndNo(ssbs8000U0In00VO);
    }

    @ApiOperation(value = "공통코드값 조회")
    @RequestMapping(value = "/cmn-cd-vl/get", method = RequestMethod.POST)
    public List<SSBS8000U0Out01VO> getCmnCdVl(@RequestBody SSBS8000U0In01VO ssbs8000U0In01VO) {
        return ssbs8000U0Service.getCmnCdVl(ssbs8000U0In01VO);
    }

    @ApiOperation(value = "공통코드값 저장")
    @RequestMapping(value = "/cmn-cd-vl/save", method = RequestMethod.POST)
    public int saveCmnCdVl(@RequestBody SSBS8000U0Out01VO ssbs8000U0Out01VO) {
        return ssbs8000U0Service.saveCmnCdVl(ssbs8000U0Out01VO);
    }

    @ApiOperation(value = "공통코드값 삭제")
    @RequestMapping(value = "/cmn-cd-vl/delete", method = RequestMethod.POST)
    public int deleteCmnCdVl(@RequestBody SSBS8000U0In01VO ssbs8000U0In01VO) {
        return ssbs8000U0Service.deleteCmnCdVl(ssbs8000U0In01VO);
    }
}

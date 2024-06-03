package com.miraeasset.biz.common.controller;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.service.CommonScheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main/common/schedule")
public class CommonScheduleController {

    @Autowired
    CommonScheduleService commonScheduleService;

    @ApiOperation(value="인감증명서 만료일 당일 안내 스케줄 실행(신청직원)")
    @RequestMapping(value= "/u0", method = RequestMethod.GET)
    public void ExecScheduleU0() {
        try {
            commonScheduleService.sendScheduledMessage();
        } catch (Exception e) {
            throw new CustomBadRequestException("스케줄 실행 실패", ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}

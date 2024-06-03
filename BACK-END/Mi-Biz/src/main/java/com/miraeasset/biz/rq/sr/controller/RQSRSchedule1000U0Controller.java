package com.miraeasset.biz.rq.sr.controller;

import com.miraeasset.biz.rq.sr.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main/rqsr/schedule")
public class RQSRSchedule1000U0Controller {
    @Autowired
    RQSRSchedule1000U0Service rqsrSchedule1000U0Service;
    @Autowired
    RQSRSchedule1000U1Service rqsrSchedule1000U1Service;
    @Autowired
    RQSRSchedule1000U2Service rqsrSchedule2000U1Service;
    @Autowired
    RQSRSchedule1000U3Service rqsrSchedule1000U3Service;
    @Autowired
    RQSRSchedule1000U4Service rqsrSchedule1000U4Service;
    @Autowired
    RQSRSchedule1000U5Service rqsrSchedule1000U5Service;

    @ApiOperation(value="인감증명서 만료일 당일 안내 스케줄 실행(신청직원)")
    @RequestMapping(value= "/u0", method = RequestMethod.GET)
    public void ExecScheduleU0() {
        rqsrSchedule1000U0Service.mainProc();
    }

    @ApiOperation(value="인감증명서 만료일 당일 안내 스케줄 실행(신청직원의 팀장)")
    @RequestMapping(value= "/u1", method = RequestMethod.GET)
    public void ExecScheduleU1() {
        rqsrSchedule1000U1Service.mainProc();
    }

    @ApiOperation(value="인감증명서 만료 안내 스케줄 실행(인감날인 담당자)")
    @RequestMapping(value= "/u2", method = RequestMethod.GET)
    public void ExecScheduleU2() {
        rqsrSchedule2000U1Service.mainProc();
    }

    @ApiOperation(value="인감증명서 만료 안내 스케줄 실행(총무팀장)")
    @RequestMapping(value= "/u3", method = RequestMethod.GET)
    public void ExecScheduleU3() {
        rqsrSchedule1000U3Service.mainProc();
    }

    @ApiOperation(value="인감증명서 만료 초과 안내 스케줄 실행(신청직원)")
    @RequestMapping(value= "/u4", method = RequestMethod.GET)
    public void ExecScheduleU4() {
        rqsrSchedule1000U4Service.mainProc();
    }

    @ApiOperation(value="인감증명서 만료 초과 안내 스케줄 실행(신청직원의 팀장)")
    @RequestMapping(value= "/u5", method = RequestMethod.GET)
    public void ExecScheduleU5() {
        rqsrSchedule1000U5Service.mainProc();
    }
}

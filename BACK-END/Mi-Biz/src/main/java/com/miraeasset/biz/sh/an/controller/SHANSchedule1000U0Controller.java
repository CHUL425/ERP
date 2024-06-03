package com.miraeasset.biz.sh.an.controller;

import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.sh.an.service.SHANSchedule1000U0Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SHANSchedule1000U0Controller {

    @Autowired
    SHANSchedule1000U0Service shanSchedule1000U0Service;

    @ApiOperation(value="안전보건관리 미확인 대상 알림")
    @RequestMapping(value= "/u0", method = RequestMethod.GET)
    public void ExecScheduleU0() {
        String today = DateUtil.getDate();
        shanSchedule1000U0Service.mainProc(today, today);
    }
}

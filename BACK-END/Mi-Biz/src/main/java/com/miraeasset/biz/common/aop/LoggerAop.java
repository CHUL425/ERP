package com.miraeasset.biz.common.aop;

import com.miraeasset.biz.common.login.service.LoginService;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.login.vo.LoginUserPracticeHistoryVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

@Component
@Aspect
public class LoggerAop {
    final LoginService loginService;

    public LoggerAop(LoginService loginService) {
        this.loginService = loginService;
    }

    @Before("execution(* com.miraeasset.biz..controller..*.*(..))")
    public void loggingControllerPractice(final JoinPoint joinPoint) {
        String controllerName = joinPoint.getSignature().getDeclaringType().getName();

        if (controllerName != null && !controllerName.equals("com.miraeasset.biz.common.login.controller.LoginController")) {
            String[] splitControllerName = controllerName.split("[.]");

            if (splitControllerName.length > 0) {
                String simpleControllerName = splitControllerName[splitControllerName.length - 1];
                String psitMenuId = "";

                // 화면번호 RULE을 따르는 컨트롤러만 이력을 남긴다.
                if (simpleControllerName.length() >= 10 && Pattern.matches("[a-zA-z]{4}[0-9]{4}[a-zA-z][0-9]", simpleControllerName.substring(0, 10))) {
                    psitMenuId = simpleControllerName.substring(0, 10);

                    LoginUserPracticeHistoryVO loginUserPracticeHistoryVO = new LoginUserPracticeHistoryVO(psitMenuId, simpleControllerName);

                    try {
                        loginService.insertLoginUserPracticeHistory(loginUserPracticeHistoryVO);
                    } catch (Exception e) { // 에러나도 SKIP

                    }
                }
            }
        }
    }

    @After("execution(* com.miraeasset.biz..controller.LoginController.loginUserBy*(..))")
    public void loggingLogin(final JoinPoint joinPoint) {
        try {
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
            LoginOutVO loginOutVO = (LoginOutVO) session.getAttribute("loginOutVO");
            if (loginOutVO != null) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String lginDt = new SimpleDateFormat("yyyymmdd").format(timestamp);
                String lginTmd = new SimpleDateFormat("HHmmssSS").format(timestamp).substring(0, 8);

                loginOutVO.setLginDt(lginDt);
                loginOutVO.setLginTmd(lginTmd);

                loginService.insertLoginUserHistory(loginOutVO);
            }
        } catch (Exception e) {

        }
    }

    @Before("execution(* com.miraeasset.biz..controller.LoginController.logoutUser*(..))")
    public void loggingLogout(final JoinPoint joinPoint) {
        try {
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
            LoginOutVO loginOutVO = (LoginOutVO) session.getAttribute("loginOutVO");

            if (loginOutVO != null) {
                loginService.updateLoginUserHistory(loginOutVO);
            }
        } catch (Exception e) {

        }
    }

}

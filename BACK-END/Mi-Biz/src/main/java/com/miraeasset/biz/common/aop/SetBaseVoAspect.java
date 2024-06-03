package com.miraeasset.biz.common.aop;

import com.miraeasset.biz.common.login.service.LoginService;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.vo.BaseVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Component
@Aspect
public class SetBaseVoAspect {

    /*
    private final LoginService loginService;

    @Autowired
    public SetBaseVoAspect(LoginService loginService) {
        this.loginService = loginService;
    }

    @Before("execution(* com.miraeasset.biz..controller..*.*(..))")
    public void setOprtInfo(final JoinPoint joinPoint) {
        String optrId = "0000000";
        String oprtChnlCd = "000";
        String oprtOrzCd = "000000";
        String oprtIpAdr = "0.0.0.0";
        String oprtDttm = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss").format(Calendar.getInstance().getTime());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        LoginOutVO loginOutVO;
        loginOutVO = (LoginOutVO)session.getAttribute("loginOutVO");

        if(loginOutVO != null) {
            if(loginOutVO.getEpno() != null && loginOutVO.getEpno() != "") {
                optrId = loginOutVO.getEpno();
            }
            if(loginOutVO.getOprtChnlCd() != null && loginOutVO.getOprtChnlCd() != "") {
                oprtChnlCd = loginOutVO.getOprtChnlCd();
            }
            if(loginOutVO.getOprtOrzCd() != null && loginOutVO.getOprtOrzCd() != "") {
                oprtOrzCd = loginOutVO.getNowWrkpOrzCd();
            }
            if(loginOutVO.getOprtIpAdr() != null && loginOutVO.getOprtIpAdr() != "") {
                oprtIpAdr = loginOutVO.getOprtIpAdr();
            }
        }

        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++) {
            if(args[i] instanceof BaseVO) {
                ((BaseVO) args[i]).setOptrId(optrId);
                ((BaseVO) args[i]).setOprtChnlCd(oprtChnlCd);
                ((BaseVO) args[i]).setOprtOrzCd(oprtOrzCd);
                ((BaseVO) args[i]).setOprtIpAdr(oprtIpAdr);
                ((BaseVO) args[i]).setOprtDttm(oprtDttm);
            } else if(args[i] instanceof List && args[i] != null) {
                for(int j = 0; j < ((List<?>) args[i]).size(); j++) {
                    if(!!!(((List<?>) args[i]).get(j) instanceof BaseVO)) {
                        continue;
                    }
                    Object arg = ((List<?>) args[i]).get(j);
                    ((BaseVO) arg).setOptrId(optrId);
                    ((BaseVO) arg).setOprtChnlCd(oprtChnlCd);
                    ((BaseVO) arg).setOprtOrzCd(oprtOrzCd);
                    ((BaseVO) arg).setOprtIpAdr(oprtIpAdr);
                    ((BaseVO) arg).setOprtDttm(oprtDttm);

                    ((List<Object>) args[i]).set(j, arg);
                    System.out.println("#############################" + ((BaseVO) arg).getOptrId());
                    System.out.println("#############################" + ((BaseVO) ((List<?>) args[i]).get(j)).getOptrId());
                }
            }
        }

        System.out.println(String.format("%s %s %s %s %s", optrId, oprtChnlCd, oprtOrzCd, oprtIpAdr, oprtDttm));

//        joinPoint.proceed(args);
    }
    */

}

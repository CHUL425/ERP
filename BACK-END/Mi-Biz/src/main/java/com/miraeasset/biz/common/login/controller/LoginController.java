package com.miraeasset.biz.common.login.controller;

import com.aircuve.web.Auth;
import com.covision.covisignone.client.CoviSignOneClient;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomNotFoundException;
import com.miraeasset.biz.common.exception.NoSessionException;
import com.miraeasset.biz.common.exception.vo.CommonErrorResponse;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.LoginManager;
import com.miraeasset.biz.common.login.service.LoginService;
import com.miraeasset.biz.common.login.vo.LoginInOtpVO;
import com.miraeasset.biz.common.login.vo.LoginInVO;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.login.vo.LoginUserMenuVO;
import com.miraeasset.biz.common.vo.CommonResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/common/login/")
public class LoginController { // 아직 테스트용임
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final LoginService loginService;

    private int SESSION_TIMEOUT = 30*60;

    @Value("${SYSTEM_NAME}")
    private String SYSTEM_NAME;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @RequestMapping(value = "/out", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse logoutUser(HttpServletRequest request) {
        LoginManager loginManager = LoginManager.getInstance();
        LoginOutVO loginOutVO = (LoginOutVO)request.getSession().getAttribute("loginOutVO");

        if(loginOutVO == null) {
            throw new CustomBadRequestException("로그인 정보가 없습니다.", ErrorCode.BAD_REQUEST);
        }

        String userId = loginOutVO.getEpno();
        loginManager.removeSession(userId);

        return new CommonResponse(String.format("[%s] 정상 로그아웃되었습니다.", userId));
    }


    @RequestMapping(value = "/sso", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse loginUserBySso(@RequestBody LoginInVO inVO, HttpServletRequest request) {
        CommonResponse response = new CommonResponse();
        LoginManager loginManager = LoginManager.getInstance();
        LoginOutVO outVO = userValidation(inVO);

        // IP 획득
        String ip = getIp(request);
        outVO.setConnIp(ip);
        // 접속 채널 획득
        String chnlCd = getChnlCd(request);
        outVO.setConnChnlCd(chnlCd);
        // 로그인시간
        Date lginDttm = new Date();
        outVO.setLginDttm(lginDttm);


        // OUTPUT 설정
        response.addData(outVO);

        // 세션 저장
        String userId = nvl(inVO.getUserId(), "");
//        loginManager.removeSession(userId);
        loginManager.setSession(request.getSession(), userId);

        // loginManager.printLoginUsers();

        request.getSession().setAttribute("loginOutVO", outVO);
        request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT);

        return response;
    }


    /**
     * 모바일 APP_SSO 연동 로그인_2023-11-20
     */
    @RequestMapping(value= "/ssoMobile",method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse loginSsoMobile(@RequestBody Map<String, String> reqMap, HttpServletRequest request, HttpServletResponse resp) {
        CommonResponse response = new CommonResponse();
        String CAUTK;
        String ssoID;
        String strRtn = "";
        String userAgent = request.getHeader("User-Agent").toLowerCase();

        /*
        String connIp = request.getRemoteAddr();
        if(connIp == null || connIp.isEmpty()){
            String tmpIp = request.getHeader("X-Forwarded-For");
            if(tmpIp != null && !tmpIp.isEmpty()){
                connIp = tmpIp;
            }
        }
        */

        LoginManager loginManager = LoginManager.getInstance();
        CoviSignOneClient coSignOne = new CoviSignOneClient(request, resp);

        //try {
            if(userAgent.indexOf("iphone") > 0 || userAgent.indexOf("ipad") > 0 || userAgent.indexOf("android") > 0 ||
                    userAgent.indexOf("blackberry") > 0 || userAgent.indexOf("symbian") > 0 || userAgent.indexOf("sony") > 0 ||
                    userAgent.indexOf("mobile") > 0) {

                // 모바일 접근
                // log.info("Mobile Access - " + userAgent);
                strRtn = "Mobile Access";

                CAUTK = reqMap.get("CAUTK");
                ssoID = coSignOne.getID(CAUTK);
                if(ssoID.contains("ERROR")) { ssoID = ""; }

                if(ssoID != null && !ssoID.isEmpty()) {
                    log.info("InApp 로그인 ID : " + ssoID);

                    //자동 로그인
                    LoginInVO inVO = new LoginInVO();
                    inVO.setUserId(ssoID);
                    LoginOutVO outVO = userValidation(inVO);

                    // IP 획득
                    outVO.setConnIp(getIp(request));
                    // 접속 채널 - Mobile
                    outVO.setConnChnlCd(getChnlCd(request));
                    // 로그인시간
                    outVO.setLginDttm(new Date());

                    // OUTPUT 설정
                    response.addData(outVO);

                    // 세션 저장
                    String userId = nvl(outVO.getEpno(), "");
                    loginManager.setSession(request.getSession(), userId);

                    // 모바일 경우만 체크?
                    loginManager.printLoginUsers();

                    request.getSession().setAttribute("loginOutVO", outVO);
                    request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT);
                }
                else {
                    strRtn = "error - ID Not Found";
                }
            }
            else {
                strRtn = "error - PC Access";
            }
        //} catch (IOException ex) {
        //    strRtn = ex.getMessage();
        //}

        log.info(strRtn);

        return response;
    }



    @RequestMapping(value="/otp", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse loginUserByOtp(@RequestBody LoginInOtpVO inVO, HttpServletRequest request) {
        CommonResponse response = new CommonResponse();
        LoginManager loginManager = LoginManager.getInstance();

        if(nvl(inVO.getOtp(), "").equals("")) {
            throw new CustomBadRequestException("OTP 값을 입력해주세요.", ErrorCode.BAD_REQUEST);
        }

        LoginOutVO outVO = userValidation(inVO);

        // IP 획득
        String ip = getIp(request);
        outVO.setConnIp(ip);
        // 접속 채널 획득
        String chnlCd = getChnlCd(request);
        outVO.setConnChnlCd(chnlCd);
        // 로그인시간
        Date lginDttm = new Date();
        outVO.setLginDttm(lginDttm);

        log.info("IP: " + ip);

        String userId = nvl(inVO.getUserId(), "");
        String otp  = nvl(inVO.getOtp(), "");
        if(!ip.equals("127.0.0.1")) {
            // OTP 검증
            // HttpsURLConnection 사용 ( 아이피 : 172.16.100.237, 포트 : 80 )  >> 방화벽 신청이 필요
            // otpAuth 매서드로 분리
            String otpResult = "";
            String rtnCd = "";
            String errCode = "";
            String errMsg = "";

            boolean otpAuthFlag = true;
            /* 검증 */
            if(SYSTEM_NAME.equals("test")) {
                if(otp.equals("123456")) {
                    otpAuthFlag = false;
                }
            }
            /* 개발 */
            else if (SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("local")) {
                otpAuthFlag = false;
            }
            /* 운영 */
            //else if(SYSTEM_NAME.equals("real")) {
            //    if(otp.equals("3360135!")) { // [20240405]삭제 요청
            //        otpAuthFlag = false;
            //    }
            //}

            if(otpAuthFlag) {
                Map<String, String> otpAuthResultMap = otpAuth(userId, otp);
                otpResult = otpAuthResultMap.get("otpResult");
                rtnCd = otpAuthResultMap.get("rtnCd");
                errCode = otpAuthResultMap.get("errCode");
                errMsg = otpAuthResultMap.get("errMsg");
            } else {
                rtnCd = "true";
            }

            log.info("OTP RESULT ##############################################################################################################");
            log.info("OTP RESULT  =======>" + otpResult	);
            log.info("OTP rtnCd   =======>" + rtnCd		);
            log.info("OTP errCode =======>" + errCode	);
            log.info("OTP errMsg  =======>" + errMsg		);
            log.info("OTP RESULT ##############################################################################################################");
            if(rtnCd == null || !rtnCd.equals("true")) {
                throw new CustomBadRequestException("OTP 값을 다시 입력해주세요.", ErrorCode.BAD_REQUEST);
            }
        }

        // OUTPUT 설정
        response.addData(outVO);


        // 세션 저장
//        loginManager.removeSession(userId);
        loginManager.setSession(request.getSession(), userId);

        // loginManager.printLoginUsers();

        request.getSession().setAttribute("loginOutVO", outVO);
        request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT);

        return response;
    }


    /**
     * USER 검증
     * */
    public LoginOutVO userValidation(LoginInVO loginInVO) {
        // INPUT 검증
        if( loginInVO == null ) {
            throw new CustomBadRequestException("사용자 id를 입력해주세요", ErrorCode.BAD_REQUEST);
        }
        if(nvl(loginInVO.getUserId(), "").equals("")) {
            throw new CustomBadRequestException("사용자 id를 입력해주세요", ErrorCode.BAD_REQUEST);
        }

        LoginOutVO loginOutVO = loginService.selectOneUserInfo(loginInVO);
        if( loginOutVO == null ) {
            throw new CustomNotFoundException("해당 사용자 id를 갖는 사용자가 존재하지 않습니다. 다시 로그인해주세요. ", ErrorCode.UNAUTHORIZED);
        }

        return loginOutVO;
    }

    /**
     * 접근가능조직 리스트
     * */
    @RequestMapping(value="/accs-abl-orzcd", method = RequestMethod.POST)
    @ResponseBody
    public List<String> selelctListAccsAblOrzCd(HttpServletRequest request) {
        LoginOutVO loginOutVO = getUserbySession(request);
        return loginService.selelctListAccsAblOrzCd(loginOutVO);
    }

    /**
     * 사용자그룹코드 리스트
     * */
    @RequestMapping(value="/user-grp-cd", method = RequestMethod.POST)
    @ResponseBody
    public List<String> selectListUserGrpCd(HttpServletRequest request) {
        LoginOutVO loginOutVO = getUserbySession(request);
        return loginService.selectListUserGrpCd(loginOutVO);
    }

    /**
     * 메뉴리스트
     * */
    @RequestMapping(value="/user-menu", method = RequestMethod.POST)
    @ResponseBody
    public List<LoginUserMenuVO> selectListLoginUserMenu(HttpServletRequest request) {
        LoginOutVO loginOutVO = getUserbySession(request);
        return loginService.selectListLoginUserMenu(loginOutVO);
    }


    public LoginOutVO getUserbySession(HttpServletRequest request) {
        LoginOutVO loginOutVO = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
        return loginOutVO;
    }


    // 함수
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.charAt(0) == '0') { // "0:0:0:0:0:0:0:1" == "127.0.0.1"
            ip = "127.0.0.1";
        }

        return ip;
    }
    public static String getChnlCd(HttpServletRequest request) {
        return "412";
    }


    public static String nvl(String str, String nvlStr) {
        if(str == null || str.trim().equals("")) {
            return nvlStr;
        } else {
            return str;
        }
    }


    static Map<String, String> otpAuth(String userId, String otp) {
        Map<String, String> result = new HashMap<>();

        // OTP 검증
        // HttpsURLConnection 사용 ( 아이피 : 172.16.100.237, 포트 : 80 )  >> 방화벽 신청이 필요
        Auth auth = new Auth();
        String otpResult = auth.otpAuth("172.16.100.237", userId, otp);



        JSONObject otpResultObj = new JSONObject(otpResult);
        String rtnCd    = "";
        String errCode 	= "";
        String errMsg  	= "";

        if(otpResultObj.has("success")) {
            rtnCd    = otpResultObj.getString("success");
        }
        if(otpResultObj.has("err_code")) {
            errCode 	= otpResultObj.getString("err_code");
        }
        if(otpResultObj.has("err_msg")) {
            errMsg  	= otpResultObj.getString("err_msg");
        }

        result.put("otpResult", otpResult);
        result.put("rtnCd", rtnCd);
        result.put("errCode", errCode);
        result.put("errMsg", errMsg);

        return result;
    }









    @ExceptionHandler(value = CustomNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<CommonErrorResponse> handleCustomNotFoundException(CustomNotFoundException e){
        CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSessionException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<CommonErrorResponse> handleNoSessionException(CustomNotFoundException e){
        CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.UNAUTHORIZED);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CustomBadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<CommonErrorResponse> handleCustomBadRequestException(CustomBadRequestException e){
        CommonErrorResponse response = CommonErrorResponse.of(ErrorCode.BAD_REQUEST);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

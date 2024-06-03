package com.miraeasset.biz.common.interceptor;

import com.miraeasset.biz.common.annotation.AllAuth;
import com.miraeasset.biz.common.annotation.GrpAuth;
import com.miraeasset.biz.common.annotation.PrcAuth;
import com.miraeasset.biz.common.annotation.ScrnAuth;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.NoSessionException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.LoginManager;
import com.miraeasset.biz.common.login.service.LoginService;
import com.miraeasset.biz.common.login.vo.LoginInVO;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.login.vo.LoginUserMenuVO;
import com.miraeasset.biz.common.login.vo.LoginUserPracticeHistoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BIZsInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	final String[] EXCEPT_URL_LIST = new String[]{"/api/common/login", "/api/common/code", "/api/common/cm", "/api/common"};

	@Autowired
	LoginService loginService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri;
		uri     	= request.getRequestURI();

		//로그인 체크 제외 URL 처리
		if(uri.contains("/file/dn") && !uri.equals("/api/common/file/dn/tsk")) {
			return true;
		}

		if(uri.contains("/webjars") || uri.equals("/swagger") || uri.equals("/v2")) {
			return true;
		}

		for(String EXCEPT_URL : EXCEPT_URL_LIST) {
			if(uri.contains(EXCEPT_URL)) {
				return true;
			}
		}


		//HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		//=======================================================================//		
		// 변수정의 및 입력값 설정
		//=======================================================================//		
		//String domainUrl  = PropertiesConfigurerService.get("DOMAIN_URL");
		String domainUrl    = "http://localhost";
		//domainUrl  	= "http://localhost";
		//domainUrl  	= PropReader.get("DOMAIN_URL");

		String userId		= "";
		String adminYn      = "";
		String connIpAddr;
		String connIp		= "";

		HttpSession session = request.getSession();

		LoginOutVO vo;
		vo = (LoginOutVO)session.getAttribute("loginOutVO");

		if(vo != null) {
			userId	= vo.getEpno();
			adminYn	= vo.getAdmnYn();
			connIp	= vo.getConnIp();
			
			log.debug("loginOutVO : " + vo);
		}
	
		log.info("###### [uri]_____________:   ["	+ uri    	+"]");
		log.info("###### [userId]__________:   ["	+ userId    +"]");
		log.info("###### [adminYn]_________:   ["	+ adminYn	+"]");
		log.info("###### [connIp]__________:   ["	+ connIp	+"]");

		
		//============================================================================================================================//
		// 로그인 사용자 조회 (2021.03.2. LSC. 테스트를 위하여 추가)
		//============================================================================================================================//
	    LoginManager loginManager = LoginManager.getInstance();
	    
	    // 현재 접속한 사용자리스트 조회
	    /*
		String loginUserId = "";
	    Collection<String> coll = null;
	    coll = loginManager.getUsers();
	    Iterator<String> iter = coll.iterator();
	    while(iter.hasNext()) {
	    	loginUserId = (String) iter.next();
	    	log.info("###### [로그인중인 사용자]__:   ["	+ loginUserId	+"]");
	    }
		*/

		// 개발 테스트 중!!!
		// if (!checkExceptUrl(uri)) {

			//log.info("###### [로그인 페이지]_____________:   ["	+ "http://" + domainUrl+"/logins"    	+"]");
			// log.info("#################THIS IS NO LOGIN REQUEST#################T");
			//=======================================================================//
			// 접속한 IP주소 체크
			//=======================================================================//
			if(request.getRemoteAddr().charAt(0) == '0') {
				connIpAddr = "127.0.0.1";
			} else {
				connIpAddr = request.getRemoteAddr();
			}

			log.info("###### [connIpAddr]______:   ["	+ connIpAddr	+"]");
			
			//=======================================================================//
			// InApp Browser 자동 로그인
			//=======================================================================//

			/*
			if("".equals(userId) || userId == null) {
				log.info("CAUTK - Check");

				String ssoID = "";
				String CAUTK = "";
				CoviSignOneClient coSignOne = new CoviSignOneClient(request, response);
				
				try {
					CAUTK = request.getParameter("CAUTK");
					ssoID = coSignOne.getID(CAUTK);
					if(ssoID.contains("ERROR")) { ssoID = ""; }

					if(ssoID != null && !ssoID.isEmpty()) {
						log.info("InApp 로그인 ID : " + ssoID);
						//자동 로그인
						vo = new loginOutVO();
						vo.setUserId(ssoID);
						loginOutVO getloginOutVO = loginService.selectLoginUserInfo(vo);
						loginManager.setSession(request.getSession(), ssoID);
						request.getSession().setAttribute("loginOutVO", getloginOutVO);
						return true;
					}
					else {
						log.info("CAUTK - Not Found");
					}
				} catch (Exception ex) {
					log.info(ex.getMessage());
					log.info(session.getAttribute("_covi_error_"));
				}
			}
			*/
			
			//=======================================================================//
			// OTP 불가 PC 자동 로그인 적용
			//=======================================================================//
			if( "127.0.0.1".equals(connIpAddr) ) {
				log.info("로컬 개발 중. 자동 로그인합니다.");
				//개발자 용도 자동 로그인
				if ("".equals(userId) || userId == null) {
					LoginInVO inVO = new LoginInVO();
					//inVO.setUserId("3360135"); [20240405]삭제 요청

					LoginOutVO getloginOutVO = loginService.selectOneUserInfo(inVO);
					loginManager.setSession(request.getSession(), userId);

					getloginOutVO.setConnIp(connIpAddr);

					request.getSession().setAttribute("loginOutVO", getloginOutVO);

					//request.getSession().setMaxInactiveInterval(10*30);
					// return true;
				}
			} else if("".equals(userId) || userId == null){
				 throw new CustomBadRequestException("로그인 정보가 없어요.", ErrorCode.UNAUTHORIZED);
			}


		if(vo != null) {
			log.info("##### 세션 유효 시간 임시 로그 ##### - " + request.getSession().getMaxInactiveInterval() );
		}


		/* =================== AUTH CHECK START =================== */
		log.info("=================== AUTH CHECK START ===================");
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		String controllerName = handlerMethod.getBeanType().getSimpleName();

		if(vo != null) {
			/* 사용자 권한 체크 */
			/* 메서드 연결화면번호 확인 */
			String scrnNo = null;
			ScrnAuth scrnAuth = handlerMethod.getMethodAnnotation(ScrnAuth.class);
			if(scrnAuth != null) {
				scrnNo = scrnAuth.value();
			}

			List<LoginUserMenuVO> loginUserMenuVOList =  vo.getLoginUserMenuVOList();
			boolean hasAuth = true;
			for(LoginUserMenuVO loginUserMenuVO : loginUserMenuVOList) {
				if(loginUserMenuVO.getPsitScrnId() == null || loginUserMenuVO.getPsitScrnId().length() < 8) {
					continue;
				}

				// 화면번호 - 컨트롤러명 비교 -> 해당 화면 권한 확인
				if(loginUserMenuVO.getPsitScrnId().substring(0, 8).equals(controllerName.substring(0, 8)) && loginUserMenuVO.getQryAblYn().equals("0")) {
					hasAuth = false;
					break;
				}

				// 메서드 연결화면번호 - 유저 메뉴 비교 -> 해당 메뉴 권한 확인
				if(scrnNo != null && scrnNo.substring(0, 8).equals(loginUserMenuVO.getPsitScrnId().substring(0, 8)) && loginUserMenuVO.getQryAblYn().equals("0")) {
					hasAuth = false;
					break;
				}
			}

			/* 전체 허용 컨트롤러인 경우 권한 true */
			String[] allAcceptScrnIdList = {"RQ", "SSBS5000"};
			for(String allAcceptScrnId : allAcceptScrnIdList) {
				if(controllerName.contains(allAcceptScrnId)) {
					hasAuth = true;
					break;
				}
			}

			/* 전체 허용 매서드인 경우 권한 true */
			AllAuth allAuth = handlerMethod.getMethodAnnotation(AllAuth.class);
			if(allAuth != null) {
				hasAuth = true;
			}

			/* 특정 그룹만 허용된 매서드 check */
			GrpAuth grpAuth = handlerMethod.getMethodAnnotation(GrpAuth.class);
			if(grpAuth != null && grpAuth.value() != null) {
				boolean grpAuthFlag = false;
				for(String grpCd : vo.getUserGrpCdList()) {
					if(grpAuth.value().equals(grpCd)) {
						grpAuthFlag = true;
						break;
					}
				}
				if(!grpAuthFlag) hasAuth = false;
			}

			if(hasAuth == false) {
				throw new CustomBadRequestException("사용 권한이 없어요.", ErrorCode.BAD_REQUEST);
			}
		}


//		// ScrnAuth
//		String scrnNo = null;
//		ScrnAuth scrnAuth = handlerMethod.getMethodAnnotation(ScrnAuth.class);
//		if(scrnAuth != null) {
//			scrnNo = scrnAuth.value();
//		} else {
//			if(request.getRequestURI().split("/").length >= 2) {
//				scrnNo = request.getRequestURI().split("/")[2];
//			}
//		}
//		System.out.println(scrnNo);
//
//		// PrcAuth
//		Boolean prcYn = false;
//		PrcAuth prcAuth = handlerMethod.getMethodAnnotation(PrcAuth.class);
//		if(prcAuth != null) {
//			prcYn = true;
//		}
//
//		// result
//		System.out.println("[SCR_NO]: " + scrnNo);
//		System.out.println("[PRC_YN]: " + prcYn.toString());

		// auth check service



		log.info("=================== AUTH CHECK END ===================");
		/* =================== AUTH CHECK END =================== */






		return true;
	}
	//============================================================================================================================//	
	//제외 URL 체크
	//============================================================================================================================//	
	public boolean checkExceptUrl(String url){
		int result = 0;
		for (String s : EXCEPT_URL_LIST) {
			if (url.contains(s)) {
				result++;
			}
		}
		return result > 0;
	}
}

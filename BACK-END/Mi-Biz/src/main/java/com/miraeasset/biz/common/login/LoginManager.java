package com.miraeasset.biz.common.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class LoginManager implements HttpSessionBindingListener {

	private static final Logger log = LoggerFactory.getLogger(LoginManager.class);
	
	private static LoginManager loginManager = null;  
	
	//로그인한 접속자를 담기위한 해시테이블
	@SuppressWarnings("rawtypes")
	private static final Hashtable loginUsers = new Hashtable();
	
	//싱글톤 패턴 사용
	public static synchronized LoginManager getInstance(){
		
		if(loginManager == null){
			loginManager = new LoginManager();
		}
		
		return loginManager;
	}
	
	/* 
	 * 이 메소드는 세션이 연결될때 호출
	 * session.setAttribute("login",this)
	 * Hashtable에 세션과 접속자 아이디를 저장한다.
	*/
	@SuppressWarnings("unchecked")
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//session값을 put한다.
		loginUsers.put(event.getSession(), event.getName());

		log.debug("로그인ID : " + event.getName()  );
		log.debug("세션ID  : " + event.getSession().getId() );
		log.debug("접속자수 : " + loginUsers.size());
	}

	/*
	 * 이 메소드는 세션이 끊겼을때 호출 inbalidate
	 * Hashtable에 저장된 로그인정보 제거
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//session값을 찾아서 없애준다.
		log.debug("세션ID  : " + event.getSession().getId() );
		loginUsers.remove(event.getSession());
		log.debug("로그아웃   : " + event.getName()  );
		log.debug("접속자수 : " + loginUsers.size());
	}
	
	/*
	 * 입력받은 아이디를 Hashtable에서 삭제
	 */
	@SuppressWarnings("rawtypes")
	public void removeSession(String userId){
		Enumeration e = loginUsers.keys();
		HttpSession session;
		
		while(e.hasMoreElements()){
			session = (HttpSession)e.nextElement();
			if(loginUsers.get(session).equals(userId)){
				session.invalidate();
			}
		}
	}

	/*
	* 접속한 사용자 리스트 조회
	* */
	@SuppressWarnings("rawtypes")
	public void printLoginUsers(){
		Enumeration e = loginUsers.keys();
		HttpSession ssn;

		int i = 0;
		log.debug("==========접속한 사용자 리스트==========");
		while(e.hasMoreElements()){
			ssn = (HttpSession)e.nextElement();
			log.info( (++i) + ". : " + loginUsers.get(ssn) );
		}
		log.debug("=====================================");
	}


	/*
	 * 해당 아이디의 동시 사용을 막이위해서
	 * 이미 사용중인 아이디인지 확인
	 * 이미 사용중인 경우 true, 아니면 false
	 */
	public boolean isUsing(String userId){
		return loginUsers.containsValue(userId);
	}
	
	/*
	 * 로그인을 완료한 사용자의 아이디를 세션에 저장하는 메소드
	 */
	public void setSession(HttpSession session, String userId){
			session.setAttribute(userId, this);
	}
	
	/*
	 * 입력받은 session Object로 아이디를 리턴  
	 */
	public String getUserID(HttpSession session){
		return (String)loginUsers.get(session);
	}
	
	/*
	 * 현재 접속중인 모든 사용자리스트를 리턴
	 */
	@SuppressWarnings("rawtypes")
	public Collection getUsers(){
		return loginUsers.values();
	}
	
	
	/*
	 * 현재 접속한 총 사용자수
	 */
	public int getUserCount(){
		return loginUsers.size();
	}
}

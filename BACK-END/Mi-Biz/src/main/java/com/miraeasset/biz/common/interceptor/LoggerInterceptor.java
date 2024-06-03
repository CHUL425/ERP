package com.miraeasset.biz.common.interceptor;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
//@EnableAspectJAutoProxy
@Aspect
public class LoggerInterceptor{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/*@Pointcut("@target(org.springframework.stereotype.Controller)")
	public void controllerPointcutter(){}
	
	@Pointcut("@target(org.springframework.stereotype.Service)")
	public void servicePointcutter(){}
	
	@Before("controllerPointcutter()")
	public void logBefore(JoinPoint joinPoint){
		log.debug("===log before start===");
		log.debug(joinPoint.getSignature().getName());
		log.debug("===log before end===");
		System.out.println("===log before start===");
	}*/
	/*
	 * @Before("execution(* com.miraeasset.weekly.*.*(..))")
	
	public void logBefore(JoinPoint joinPoint){
		log.debug("===log before start===");
		log.debug(joinPoint.getSignature().getName());
		log.debug("===log before end===");
		System.out.println("===log before start===");
	}
	
	
	@After("execution(* *..*.*(..))")
	public void logAfter(JoinPoint joinPoint){
		log.debug("===log after start===");
		log.debug(joinPoint.getSignature().getName());
		log.debug("===log after end===");
		System.out.println("===log after start===");
	}*/
}

package com.jsp.SpringBoot2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	Logger log;

	// first astercik is return type second is class and third is methods is either
	// with parameter or without parameter

	@Pointcut("execution(* *.*.*.controller.*.*(..))")
	public void controllerLogs() {
	};

	@Before("controllerLogs()")
	public void beforeController(JoinPoint jp) {

		log = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		log.info("Invoked" + jp.getSignature());

	}

	@After("controllerLogs()")
	public void afterController(JoinPoint jp) {

		log = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		log.info("Exited" + jp.getSignature());

	}

	@Pointcut("execution(* *.*.*.service.*.*(..))")
	public void serviceLogs() {

	};

	@AfterThrowing("serviceLogs()")
	public void afterThrew(JoinPoint jp) {

		log = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		log.error("Threw Exception from :" + jp.getSignature());

	}

	@Pointcut("execution(* *.*.*.exceptions.ApplicationExceptionHandler.*(..))")
	public void adviceLogs() {

	};

	@Before("adviceLogs()")
	public void logAfterMethodInvocation(JoinPoint jp) {

		Exception ex = (Exception) jp.getArgs()[0];

		log = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
		log.error(ex.getMessage());
		log.error("Accurred at : " + ex.getStackTrace()[0].getLineNumber());
	}

}

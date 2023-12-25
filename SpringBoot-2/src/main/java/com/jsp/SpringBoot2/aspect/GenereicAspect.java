package com.jsp.SpringBoot2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GenereicAspect {

//	@Pointcut("execution(* com.jsp.SpringBoot2.controller.*.*(..))")
//	public void logger() {
//	};
//
//	public void beforeExecution(JoinPoint jp) {
//		System.out.println(
//				"****************************Before Method Invoation************************" + jp.getSignature());
//	}

}

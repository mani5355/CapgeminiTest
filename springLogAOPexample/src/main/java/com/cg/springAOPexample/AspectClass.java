package com.cg.springAOPexample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectClass {
	
	@Pointcut("execution(* com.cg.springAOPexample.*.*(..))")
	public void p(){}
	
	
	@AfterReturning(pointcut="execution(* com.cg.springAOPexample.*.run(..))" , returning="number" )
	public void afteradvice(Object number)
	{
		System.out.println("after advice is called after returing");
		
		System.out.println("result :"+ number);
	}
	
	
	@After("execution(* com.cg.springAOPexample.*.*(..))")
	public void after()
	{
		System.out.println("after advice is called");
	}
	
	
	@Before("execution(* com.cg.springAOPexample.*.*(..))")
	public void before()
	{
		System.out.println("before advice is called");
	}
	
	
	@Around("execution(* com.cg.springAOPexample.*.*(..))")
	public void read(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("reading is called before");
		joinPoint.proceed();
		System.out.println("reading is over");
	}

	@AfterThrowing("execution(* com.cg.springAOPexample.*.check(..))")
	public void throwingAdvice()
	{
		System.out.println("after throwing is called");
	}
	
}

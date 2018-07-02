package com.duduanan.crm.aspect;


import java.util.logging.Logger;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	
   private Logger logger=Logger.getLogger(getClass().getName());
//   private void logFile(String message){
//	   FileHandler fh=null;
//	   try{
//	     fh=new FileHandler("logFile.log");
//	     logger.addHandler(fh);
//	     SimpleFormatter formatter = new SimpleFormatter();  
//	     fh.setFormatter(formatter);  
//	   }catch (Exception e) {
//		throw new RuntimeException(e);
//	 }
//	  logger.info(message);
//   }
   
   @Pointcut("execution(* com.duduanan.crm.controller.*.*(..))")
   private void forControllerPackage(){}
   @Pointcut("execution(* com.duduanan.crm.service.*.*(..))")
   private void forServicePackage(){}
   @Pointcut("execution(* com.duduanan.crm.dao.*.*(..))")
   private void forDaoPackage(){}	
   
   @Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
   private void forAppFlow(){}
   
   @Before("forAppFlow()")
   public void before(JoinPoint joinPoint){
	   String method=joinPoint.getSignature().toLongString();
	   logger.info("in @Before calling method:" + method );
//	   logFile("in @Before calling method:" + method);
	   for(Object tempArg:joinPoint.getArgs()){
		   logger.info("==>argument: " +tempArg);
	   }
   }
   @AfterReturning(pointcut="forAppFlow()",returning="result")
   public void afterReturning(JoinPoint joinPoint,Object result){
	   String method=joinPoint.getSignature().toLongString();
	   logger.info("in @AfterReturning calling method:" + method );
	   logger.info("===>>result: " + result);
   }
}

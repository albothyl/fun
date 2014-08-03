package org.project.common.aop.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.project.member.controller.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Around("execution(* org.project..*.*(..))")
	public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {		
		/*
		 * TRY, CATCH로 잡아버리면 인터셉터로 가야하는 처리가 여기서 잡혀버림. 때문에 여기에서는 예외처리를 하지안는다.
		 */
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
				
		Object aopResult = null;
		logger.info("START :: " + className + " - " + methodName);			
		aopResult = joinPoint.proceed();			
		logger.info("E N D :: " + className + " - " + methodName);
		
		return aopResult;
	}
	
	/*
	@Pointcut("execution(* org.project..*.*(..))")
    public void logging() {}
	
	
	@Before("logging()")
    public void before() {
	    System.out.println("before");
    }
    
    @After("logging()") 
    public void after() {  
	    System.out.println("after");
    }
	*/
}

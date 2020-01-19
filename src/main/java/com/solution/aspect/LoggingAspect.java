package com.solution.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;


@Component
@Aspect
public class LoggingAspect {

  Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

   @Before("execution( * com.finance..*.*(..))")
  public void logMethodEntry(final JoinPoint joinPoint) {
    logger.info(
        "*******Start : " + joinPoint.getTarget().getClass().getName() + ":"
            + joinPoint.getSignature().getName() + "*****");

    logger.debug("Entering method : " + joinPoint.getSignature().getName());

    Object[] signatureArgs = joinPoint.getArgs();

    logMethodArguments(signatureArgs);

  }

  private void logMethodArguments(Object[] signatureArgs) {

    if (signatureArgs == null) {
      logger.info("No Method Inputs");
      return;
    }

    logger.info("Method Inputs:");
    for (Object signatureArg : signatureArgs) {
      logger.info("Arg: " + signatureArg.toString());
    }

  }

  @After("execution( * com.finance..*.*(..))")
  public void logMethodExit(final JoinPoint joinPoint) {

    logger.debug("Exiting method : " + joinPoint.getSignature().getName());

    logger
        .info("*******End : " + joinPoint.getTarget().getClass().getName() + ":"
            + joinPoint.getSignature().getName() + "*****");
  }

   @Around("execution( * com.finance..*.*(..))")
  public Object logMethodAround(final ProceedingJoinPoint proceedingJoinPoint)
      throws Throwable {

    if (logger.isTraceEnabled()) {
      return logExecutionTime(proceedingJoinPoint);
    } else {
      return logMethodOutputParams(proceedingJoinPoint);
    }

  }

  private Object logMethodOutputParams(
      final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Object returnValue = proceedingJoinPoint.proceed();
    return returnValue;

  }

  private Object logExecutionTime(final ProceedingJoinPoint proceedingJoinPoint)
      throws Throwable {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start(proceedingJoinPoint.toShortString());
    boolean isExceptionThrown = false;
    try {
      return logMethodOutputParams(proceedingJoinPoint);
    } catch (Throwable ex) {
      isExceptionThrown = true;
      // log execption here.
      throw ex;
    } finally {
      stopWatch.stop();
      TaskInfo taskInfo = stopWatch.getLastTaskInfo();

      String profileMessage = "Method " + taskInfo.getTaskName()
          + ": Execution Time: " + taskInfo.getTimeMillis()
          + " ms" + (isExceptionThrown ? " (thrown Exception)" : "");
      logger.trace(profileMessage);
    }

  }

}

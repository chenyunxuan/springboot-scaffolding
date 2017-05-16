package com.mlds.core.aspect;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志处理类
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017-04-26 14:54
 */
@Aspect
public class BaseControllerAspect extends BaseServerAspect{

    //初始化日志
    private Logger logger= LoggerFactory.getLogger(getClass());
    //初始接口调用时间
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.mlds.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //接口开始调用，记录时间
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("Request_IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable{
        logger.info("********************************************************************************");
        logger.info("|---------------------------------RequestBegin---------------------------------|");
        //用改变后的参数执行目标方法
        Object returnValue = point.proceed();
        logger.info("此处可做一些类似after的工作+"+returnValue.toString());
        return returnValue;
    }

    @After(value="log()")
    public void doAfter(){
        //记录处理完后的返回操作信息
        //因为捕捉了异常所以一定会走这个方法
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get())+"ms");
        logger.info("---------------------------------RequestEnd-----------------------------------");
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable{
        //记录处理完后的返回操作信息
        logger.info("---------------------------------ReturnEnd-----------------------------------");
        logger.info("|____________________________________________________________________________|");
}


    @AfterThrowing(value = "log()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Exception e) throws Throwable{
        logger.info("-----doThrowing()开始-----");
        logger.info(" 错误信息："+e.getMessage());
        logger.info(" 此处意在执行核心业务逻辑出错时，捕获异常，并可做一些日志记录操作等等");
        logger.info(" 可通过joinPoint来获取所需要的内容");
        logger.info("-----End of doThrowing()------");
    }

   /* *//**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     *//*
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    map.put("module", method.getAnnotation(SystemLog.class).module());
                    map.put("methods", method.getAnnotation(SystemLog.class).methods());
                    String de = method.getAnnotation(SystemLog.class).description();
                    if(Common.isEmpty(de))de="执行成功!";
                    map.put("description", de);
                    break;
                }
            }
        }
        return map;
    }*/
}

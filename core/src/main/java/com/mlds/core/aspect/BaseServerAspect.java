package com.mlds.core.aspect;

import com.github.pagehelper.PageHelper;
import com.mlds.core.base.Page;
import com.mlds.core.constant.APIMessage;
import com.mlds.core.exception.MldsException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

/**
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017-05-10 10:40
 */
public class BaseServerAspect {
    @Pointcut("execution(public * com.mlds.server.*.page*(..))")
    public void page(){}

    //对分页方法进行切面拦截
    @SuppressWarnings("unchecked")
    @Around("page()")
    public Object doAroundPage(ProceedingJoinPoint point) throws Throwable{
        List<?> returnValueList=null;
        //访问目标方法的参数：取出第一个和第二个目标参数
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == Integer.class) {
            PageHelper.startPage(Integer.parseInt(args[0].toString()),Integer.parseInt(args[1].toString())+1,false);
        }else{
            throw new MldsException(APIMessage.DEMO);
        }
        Object returnValue = point.proceed();
        if(returnValue instanceof List){
            returnValueList= (List<?>) returnValue;
        }

        return new Page(returnValueList,Integer.parseInt(args[0].toString()),Integer.parseInt(args[1].toString()));
    }
}

package cn.afuo.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 模拟AOP下所有方法的执行顺序
 */
@Aspect
@Component
@Slf4j
public class GameAspect {
    /**
     * @description: 匹配
     * * Pointcut("execution(* com.example.service..*.*(..))") 匹配 com.example.service 包及其子包下所有类的所有方法
     * * Pointcut("execution(public void com.example.MyClass.myMethod())") 仅匹配 com.example.MyClass 类中名为 myMethod 的公共方法
     * * Pointcut("execution(* add*(..))") 匹配所有名字以 add 开头的方法
     * * Pointcut("@annotation(com.example.annotation.MyCustomAnnotation)")
     */
    @Pointcut("execution(public * cn.afuo.example.aspect.AspectController.doGame(..))")
    public void game() {}

    @Before("game()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("玩游戏前");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes != null ? servletRequestAttributes.getRequest() : null;
        log.info("url={},method={},ip={},class_method={},args={}",
                request != null ? request.getRequestURL() : null
                , request != null ? request.getMethod() : null
                , request != null ? request.getRemoteAddr() : null
                , joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
                , joinPoint.getArgs());
    }

    @After("game()")
    public void doAfter() {
        log.info("玩游戏后");
    }

    @AfterReturning("game()")
    public void doAfterReturning() {
        log.info("玩游戏后且没有异常");
    }

    @AfterThrowing("game()")
    public void doAfterThrowing() {
        log.info("玩游戏后且有异常");
    }

    @Around(value = "game()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("环绕通知执行前");
        Object obj = pjp.proceed();
        log.info("环绕通知执行后");
        return obj;
    }

}
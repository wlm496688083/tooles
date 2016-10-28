package com.rd.common.config;

import com.rd.common.annotation.Loggable;
import com.rd.common.handler.LoggableInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoggableAutoConfig {

    public LoggableAutoConfig() {
    }

    @Bean
    public DefaultPointcutAdvisor loggableAnnotationClassPointCut() {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(Loggable.class, true);
        LoggableInterceptor interceptor = new LoggableInterceptor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }

}

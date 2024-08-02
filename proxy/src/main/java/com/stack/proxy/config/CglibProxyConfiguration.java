package com.stack.proxy.config;

import com.stack.proxy.service.CglibCustomerService;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CglibProxyConfiguration {

    @Bean
    ApplicationRunner cglibDemo(CglibCustomerService customerService) {
        return args -> {
            customerService.create();
        };
    }

    @Bean
    static CglibBPP cglibBPP() {
        return new CglibBPP();
    }

    static class CglibBPP implements SmartInstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof CglibCustomerService) {
                try {
                    return cglib(bean, bean.getClass()).getProxy(bean.getClass().getClassLoader());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return SmartInstantiationAwareBeanPostProcessor
                    .super.postProcessAfterInitialization(bean, beanName);
        }

        @Override
        public Class<?> determineBeanType(Class<?> beanClass, String beanName) throws BeansException {
            if (beanClass.isAssignableFrom(CglibCustomerService.class))
                return cglib(null, beanClass).getProxyClass(beanClass.getClassLoader());
            return beanClass;
        }
    }

    @Bean
    CglibCustomerService customerService() {
        return new CglibCustomerService();
    }

    private static ProxyFactory cglib(Object target, Class<?> targetClass) {
        var factory = new ProxyFactory();
        factory.setTargetClass(targetClass);
        factory.setInterfaces(targetClass.getInterfaces());
        factory.setProxyTargetClass(true);
        factory.addAdvice((MethodInterceptor) invocation -> {
            var methodName = invocation.getMethod().getName();
            System.out.println("before " + methodName);
            var result = invocation.getMethod().invoke(target, invocation.getArguments());
            System.out.println("after " + methodName);
            return result;
        });
        if (null != target) {
            factory.setTarget(target);
        }
        return factory;
    }
}

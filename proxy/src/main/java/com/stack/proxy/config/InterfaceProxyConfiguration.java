package com.stack.proxy.config;

import com.stack.proxy.service.CustomerService;
import com.stack.proxy.service.DefaultCustomerService;
import com.stack.proxy.service.Transactions;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.aot.BeanFactoryInitializationAotContribution;
import org.springframework.beans.factory.aot.BeanFactoryInitializationAotProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfiguration {

    static <T> T jdk(T target) throws Exception {
        var pfb = new ProxyFactoryBean();
        pfb.setProxyInterfaces(target.getClass().getInterfaces());
        pfb.setTarget(target);
        pfb.addAdvice((MethodInterceptor) invocation -> {
            try {
                Transactions.handleTxStartFor(invocation.getMethod());
                return invocation.proceed();
            } finally {
                Transactions.handleTxStopFor(invocation.getMethod());
            }
        });
        return (T) pfb.getObject();

    }


    @Bean
    ApplicationRunner interfaceDemo(CustomerService customerService) {
        return args -> {
            customerService.create();
        };
    }

    @Bean
    DefaultCustomerService interfaceCustomerService() {
        return new DefaultCustomerService();
    }

    @Bean
    static InterfaceBPP interfaceBPP() {
        return new InterfaceBPP();
    }

    @Bean
    static InterfaceBFIAP interfaceBFIAP() {
        return new InterfaceBFIAP();
    }

    static class InterfaceBFIAP implements BeanFactoryInitializationAotProcessor {
        @Override
        public BeanFactoryInitializationAotContribution processAheadOfTime(ConfigurableListableBeanFactory beanFactory) {
            return (generationContext, beanFactoryInitializationCode) -> generationContext.getRuntimeHints().proxies().registerJdkProxy(
                    CustomerService.class,
                    org.springframework.aop.SpringProxy.class,
                    org.springframework.aop.framework.Advised.class,
                    org.springframework.core.DecoratingProxy.class);
        }

    }

    static class InterfaceBPP implements BeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof DefaultCustomerService) {
                try {
                    return jdk((CustomerService) bean);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        }
    }
}
package com.stack;

import com.stack.service.BankAccountService;
import com.stack.service.DefaultBankAccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SecurityApplication {

    @Bean
    BankAccountService bankAccountService(){
        return new DefaultBankAccountService();
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}

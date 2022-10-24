package com.dev.nangmanski_backend_spring;

import com.dev.nangmanski_backend_spring.util.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NangmanskiBackendSpringApplication {

    public static void main(String[] args) {
        String profile = StringUtil.nvl(System.getProperty("spring.profiles.active"), "local");
        System.setProperty("spring.profiles.active", profile);
        System.setProperty("service.name", "springboot_basic");
        SpringApplication.run(NangmanskiBackendSpringApplication.class, args);
    }

}

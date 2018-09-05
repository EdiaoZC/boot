package com.demo.boot;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BootApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }
}

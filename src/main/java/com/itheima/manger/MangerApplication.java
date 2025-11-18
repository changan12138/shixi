package com.itheima.manger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangerApplication.class, args);
    }

}

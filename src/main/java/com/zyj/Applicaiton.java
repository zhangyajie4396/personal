package com.zyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 17:01 2018/6/12
 */


@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
public class Applicaiton {

    public static void main(String[] args) {
        System.out.println(1111);
        SpringApplication.run(Applicaiton.class, args);
    }
}

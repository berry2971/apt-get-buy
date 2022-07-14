package com.berry.aptgetbuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.berry.aptgetbuy.mapper")
public class AptGetBuyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AptGetBuyApplication.class, args);
    }

}

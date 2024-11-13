package com.hg.tagnew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hg.tagnew.dao")
public class TagNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(TagNewApplication.class, args);
    }

}

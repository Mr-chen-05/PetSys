package com.bdqn.petsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bdqn.petsys.mapper")
public class PetSysApplication {
    // 项目路径
    // http://localhost:8080/BreedInfo
    public static void main(String[] args) {
        SpringApplication.run(PetSysApplication.class, args);
    }

}

package com.demo.camera;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@MapperScan(basePackages = "com.demo.camera.mapper")
@SpringBootApplication
//@EnableSwagger2
public class CameraApplication {

    public static void main(String[] args) {
        SpringApplication.run(CameraApplication.class, args);
    }

}

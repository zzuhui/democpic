package com.weikehui.democpic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zzuhui
 */
@SpringBootApplication
@ComponentScan("com.weikehui.democpic")
public class DemoCpicApplication {

    public static void main(String [] args) {
        SpringApplication.run(DemoCpicApplication.class, args);
    }
}

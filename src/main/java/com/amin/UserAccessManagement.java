package com.amin;

import com.amin.config.Properties;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({Properties.class})
@SpringBootApplication
@Log4j2
public class UserAccessManagement {

    public static void main(String[] args) {

        SpringApplication.run(UserAccessManagement.class, args);
        log.info("UserAccessManagement started");

    }

}
    
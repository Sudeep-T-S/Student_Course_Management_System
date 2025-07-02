package com.studentmgmt.config;

import com.studentmgmt.util.DataMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataMapper dataMapper() {
        return new DataMapper();
    }
}

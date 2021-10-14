package com.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
public class EnvironmentConstants {
    public final String baseURL;

    @Autowired
    EnvironmentConstants(Environment environment) {
        this.baseURL = environment.getProperty("baseURL");
    }
}

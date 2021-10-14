package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages = { "com" })
@PropertySources({
    @PropertySource("classpath:environment/application-${env}.properties"),
    //    @PropertySource("classpath:environment/common.properties")
})
public class ServiceApplication {

}

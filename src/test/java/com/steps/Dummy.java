package com.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import com.config.EnvironmentConstants;
import com.config.ServiceApplication;

@Component
@ContextConfiguration(classes = ServiceApplication.class)
public class Dummy {
    @Autowired
    static EnvironmentConstants environmentConstants;

    public static void main(String[] args) {
        System.out.println(environmentConstants);
    }
}

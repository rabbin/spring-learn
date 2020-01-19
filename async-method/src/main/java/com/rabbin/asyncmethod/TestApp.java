package com.rabbin.asyncmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 0)
public class TestApp implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(TestApp.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("this is a test class!");
    }
}

package com.rabbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"classpath:bean.xml"})
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        context.getBean("beanLife");

        context.close();
        // 根据spring配置文件创建应用上下文
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("bean.xml");
    }
}

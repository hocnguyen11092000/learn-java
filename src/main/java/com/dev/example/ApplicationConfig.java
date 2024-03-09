package com.dev.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {
    @Bean
    @Qualifier("bean1")
//    @Profile("dev")
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("first bean");
    }


    @Bean
    @Qualifier("bean2")
//    @Profile("stg")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("second bean");
    }

    @Bean
//    @Primary // the mean we set priority for this bean
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("third bean");
    }
}

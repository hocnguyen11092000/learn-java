package com.dev.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
//@PropertySources({
//        @PropertySource("classpath:custom.properties"),
//        @PropertySource("classpath:custom-file-2.properties"),
//})
public class MyFirstService {
    //    @Autowired => this is field injection
    //    @Qualifier('mySecondBean') => it's the same way to set at constructor
    //    private MyFirstClass myFirstClass;
    private final MyFirstClass myFirstClass;
    private Environment environment;

    //    @Value("custom")
    //    private String fromAppPropFile;

    @Value("${custom}")
    private String hello;

    //    @Autowired
    // don't need autowired keyword because when the app init it will scan this class
    // and resolve dependency in app context
    // this is constructor injection
    public MyFirstService(
            //that mean we want to inject specify if we have multiple bean of the same type
          @Qualifier("bean1") MyFirstClass myFirstClass
    //    MyFirstClass myFirstClass // if we define @Primary at bean => you don't need to call @Qualifier
    ) {
        this.myFirstClass = myFirstClass;
    }

    //another way to inject deps (simple method)
    //    @Autowired
    //    public void injectDependency(
    //            MyFirstClass myFirstClass
    //    ) {
    //        this.myFirstClass = myFirstClass;
    //    }

    //another way to inject deps (setter method)
    //    @Autowired
    //    public void setMyFirstClass(
    //            MyFirstClass myFirstClass
    //    ) {
    //        this.myFirstClass = myFirstClass;
    //    }

    public String tellAStory() {
        return "the dependency is saying... " + myFirstClass.sayHello();
    }

//    public String getJavaVersion() {
//        return environment.getProperty("java.version");
//    }
//
//    @Autowired
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//    }

    public String getHello() {
        return hello;
    }

//    public String getFromAppPropFile() {
//        return fromAppPropFile;
//    }
}

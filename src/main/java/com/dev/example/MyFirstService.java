package com.dev.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    private final MyFirstClass myFirstClass;

//    @Autowired
// don't need autowired keyword because when the app init it will scan this class
// and resolve dependency in app context
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "the dependency is saying... " + myFirstClass.sayHello();
    }
}

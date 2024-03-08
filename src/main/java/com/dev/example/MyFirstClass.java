package com.dev.example;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class MyFirstClass {
    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello from my first class =>> " + myVar;
    }
}

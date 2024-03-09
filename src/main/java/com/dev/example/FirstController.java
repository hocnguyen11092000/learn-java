package com.dev.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "hello world";
//    }

    @PostMapping("/post")
    public String post(
           @RequestBody String message
    ) {
        return "Post request " + message;
    }

    @PostMapping("/post-order")
    public String post(
           @RequestBody Order order
    ) {
        return "Post request " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ) {
        return "Post request " + order.toString();
    }

//    @GetMapping("/hello/{user-name}")
//    public String pathVar(
//            @PathVariable("user-name") String userName
//    ) {
//        return "path variable: " + userName;
//    }

    @GetMapping("/hello")
    public String paramsVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastName
    ) {
        return "path variable: " + userName + ' ' + userLastName;
    }
}

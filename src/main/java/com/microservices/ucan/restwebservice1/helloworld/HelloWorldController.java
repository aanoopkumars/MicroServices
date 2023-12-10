package com.microservices.ucan.restwebservice1.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String sayHello() {
        return "Hi my dear, pls check yay dude";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean sayHelloBean() {
        return new HelloWorldBean("I am a json");
    }
    
    @GetMapping(path="/hello-world-bean-v2/{name}")
    public HelloWorldBean sayHelloBean(@PathVariable String name) {
       // return new HelloWorldBean(("I am a json, Mr. %s").formatted(name)); or 
        return new HelloWorldBean(String.format("I am a json, Mr. %s", name));
    }
}

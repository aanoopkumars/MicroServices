package com.microservices.ucan.restwebservice1.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	
	
    public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	// @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String sayHello() {
        return "Hi my dear, pls check yay dude";
    }
    
    @GetMapping(path = "/hello-world-i18n")   // if we pass Accept-Language header with value fr , it selects value from messages_fr.properties.
    public String sayHelloi18n() {
        Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default message", locale);
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

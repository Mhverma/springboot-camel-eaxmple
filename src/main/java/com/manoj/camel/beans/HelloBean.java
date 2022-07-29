package com.manoj.camel.beans;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("myBean")
public class HelloBean {
    @Value("${greeting}")
    private String say;
    public String saySomething(String name) throws Exception {
        int random = (int) (Math.random() * 10);
        if(random==1){
            throw new Exception( "Random no less than 5 Exception" );
        }

        return say.toUpperCase() + " " + name;
    }


    public String sayHello(String name){
        return " Again "  + name;
    }
}

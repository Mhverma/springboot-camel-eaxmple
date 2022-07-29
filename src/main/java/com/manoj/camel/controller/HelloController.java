package com.manoj.camel.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "frank") String name) {
        String output = producerTemplate.requestBody("direct:sayHello", name, String.class);
        System.out.println(output );
        return output;
    }
}

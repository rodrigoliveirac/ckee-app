package com.rodcollab.ckeeapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    List<Greeting> greetings = new ArrayList<Greeting>();

    @GetMapping("/greeting")
    public List<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        greetings.add(new  Greeting(counter.incrementAndGet(), String.format(template, name)));
        return greetings;
    }
    @GetMapping("/greeting/deleteAll")
    public void deleteAll() {
        counter = new AtomicLong();
        greetings = new ArrayList<Greeting>();
    }
}

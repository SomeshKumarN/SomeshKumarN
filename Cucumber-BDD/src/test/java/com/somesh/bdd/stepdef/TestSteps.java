package com.somesh.bdd.stepdef;

import io.cucumber.java.en.Given;

public class TestSteps {
    @Given("print something")
    public void print_something() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("printing...");
    }
    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) throws InterruptedException {
        Thread.sleep(2000);
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario,file);
    }
}

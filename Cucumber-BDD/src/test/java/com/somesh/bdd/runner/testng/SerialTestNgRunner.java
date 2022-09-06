package com.somesh.bdd.runner.testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Test.feature",
        glue = {"com.somesh.bdd.stepdef"})

public class SerialTestNgRunner extends AbstractTestNGCucumberTests {

}
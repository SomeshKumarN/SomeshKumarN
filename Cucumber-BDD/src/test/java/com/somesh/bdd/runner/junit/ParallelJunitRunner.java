package com.somesh.bdd.runner.junit;

import courgette.api.CourgetteOptions;
import courgette.api.junit.Courgette;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 20,
        reportTargetDir = "target/junit/report-parallel",
        cucumberOptions = @courgette.api.CucumberOptions(
                features = "src/test/resources/features",
                glue = {"com/somesh/bdd/stepdef"},
                plugin = {"pretty"})
)
public class ParallelJunitRunner {
}

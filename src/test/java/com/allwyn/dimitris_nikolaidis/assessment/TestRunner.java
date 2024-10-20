package com.allwyn.dimitris_nikolaidis.assessment;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"com.allwyn.dimitris_nikolaidis.assessment.tests"},
        plugin = {
                "pretty",
                "html:target/reports/cucumber/cucumber.html",
                "json:target/report.json",
                "junit:target/junit.xml"
        }
)
public class TestRunner {
}

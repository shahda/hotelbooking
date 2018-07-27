package com.packt.hotelbook.base;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue={"com.packt.hotelbook.stepDef"},
        format = {
                "pretty",
                "html:target/site/cucumber-reports",
                "json:target/cucumber.json" },
        tags = {"@Smoketest"}
)

public class CucumberRunnerTest {

}
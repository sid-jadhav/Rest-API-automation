package com.org.api.Acceptance_Test.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue={"com.org.api.Acceptance_Test"},
		plugin={"pretty","json:target/sid/cucumber.json","html:target/output","junit:target/junit/cucumber.xml"}
		)
public class RunnerTest {

}

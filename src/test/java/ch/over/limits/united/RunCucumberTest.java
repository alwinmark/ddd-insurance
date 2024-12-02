package ch.over.limits.united;

import org.junit.runner.RunWith;

import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "ch.over.limits.united", plugin = { "pretty" })
@RunWith(Cucumber.class)
public class RunCucumberTest {
}
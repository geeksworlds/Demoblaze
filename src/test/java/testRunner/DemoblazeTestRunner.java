package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Acer Owner\\Downloads\\DemoBlaze\\src\\test\\java\\feature\\Demoblaze.feature", glue= {"stepDefination"}, 
plugin = {"pretty", "html:target/Htmlreports.html"},
tags="@DemoBlaze") 


public class DemoblazeTestRunner {

}

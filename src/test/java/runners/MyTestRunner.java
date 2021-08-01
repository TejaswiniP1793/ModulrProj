package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources"},
		glue = {"stepDefinitions", "appHooks"},monochrome=true,
		plugin = {"pretty"//,
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"timeline:test-output-thread/"		
		}//,tags= "@Run"
		
		)

public class MyTestRunner {

}
package runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\91817\\eclipse-workspace\\Cucumberproject\\src\\features\\Login.feature",
                 glue="stepdefination",
                 monochrome=true,
                 dryRun=false  )

public class Admnlogin {
	
	
}

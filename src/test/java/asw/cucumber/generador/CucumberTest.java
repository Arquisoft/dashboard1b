package asw.cucumber.generador;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(features = {"src/test/resources/features"},
								glue = {"asw.cucumber.steps"})
	
	
	public class CucumberTest{
		
		
	}

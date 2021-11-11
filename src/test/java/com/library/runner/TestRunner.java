package com.library.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features="src/test/resources/features" ,
                  glue="com/library/step_definitions",
                  publish = true,
                  plugin = {// store the failed scenario into rerun.txt
                          "pretty", "html:target/cucumber.html" ,
                          "rerun:target/rerun.txt" ,// store the failed scenario into rerun.txt
                          "json:target/cucumber.json",
                          "me.jvt.cucumber.report.PrettyReports:target"  // fancy report

                  },

          dryRun = false
          ,tags="@smoke"

)
public class TestRunner {
}

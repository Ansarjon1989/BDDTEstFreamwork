package com.pnt.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CucumberOptions(features = {"src/test/java/com/pnt/bdd/features/"},
        glue = {"com/pnt/bdd/stepdef"},
        //tags = {"@Login"},
        //monochrome = false, // display the console output in readable format
        //strict = false,      // no declaration of any step , strict = false --> pass , true--> fail
        //dryRun = false,     // checking if mapping is in place
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json"})

public class Runner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setupClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeatureWrapper) {
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

    @AfterSuite(alwaysRun = true)
    public void generateReport() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber-reports/CucumberTestReport.json");
        String projectName = "TD Product Pages"; //change accordingly
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber("1");
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Username", "name");
        // add multiple config if you want
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
        int failedFeatures = result.getFailedFeatures();
        int passedFeatures = result.getPassedFeatures();
        System.out.println("Total passed features : " + passedFeatures);
        System.out.println("Total failed features : " + failedFeatures);
    }
}

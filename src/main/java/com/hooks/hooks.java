package com.hooks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.base.baseClass;
import com.base.driverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




public class hooks extends baseClass {
    
  

	private static final String FAILURE_LOG_FILE = "failed_scenarios.txt";
    private static int scenarioCount = 0;
    private static int scenarioCompleted = 0;
    private static boolean browserLaunched = false;
    
    public hooks() throws IOException {
  		super();
  		// TODO Auto-generated constructor stub
  	}
    
 
   
    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
    	
        if (scenarioCount == 0) {
        	scenarioCount = countScenariosInFeatures("src/test/resources/features/Featurefile.feature"); // Update this path as needed
        }
        
        if (!browserLaunched) {
        	
            launchBrowser(); // Initialize WebDriver before the first scenario
            browserLaunched = true;
        }
        
        extentTest = extentReports.createTest(scenario.getName()); // Create a new test in the report
    }

    private int countScenariosInFeatures(String path) throws IOException {
        int count = 0;  // Use a simple integer to hold the count

        // Get a list of all files in the directory
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            for (Path filePath : paths.filter(Files::isRegularFile).toList()) {
                // Check if the file is a .feature file
                if (filePath.toString().endsWith(".feature")) {
                    try {
                        List<String> lines = Files.readAllLines(filePath);
                        for (String line : lines) {
                            // Increment the count for each scenario found
                            if (line.trim().startsWith("Scenario:")) {
                                count++;
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Error reading file: " + filePath + " - " + e.getMessage());
                    }
                }
            }
        }

        return count;  // Return the total count of scenarios
    }

    

	@After
    public void afterScenario(Scenario scenario) throws IOException {
        scenarioCompleted++;
        
        if (scenario.isFailed()) {
            logFailure(scenario);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("C:\\testing_RTP\\my-app\\screenshot.png"));
            
        } else {
            extentTest.pass("Scenario passed: " + scenario.getName());
        }

        flushReports(); // Ensure the reports are flushed at the end
        
        if (scenarioCompleted == scenarioCount) {
            // Close the browser after the last scenario
        }
        closeBrowser(); 
    }

    private void logFailure(Scenario scenario) {
        try {
            // Log failure to the report
            extentTest.fail("Scenario failed: " + scenario.getName());
            
            // Log to failure log file
            BufferedWriter writer = new BufferedWriter(new FileWriter(FAILURE_LOG_FILE, true));
            writer.write(scenario.getId());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error while logging failure: " + e.getMessage());
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            try {
                driver.quit();
                driverManager.resetDriverManagerInstance();
            } catch (Exception e) {
                System.out.println("Exception occurred while closing WebDriver: " + e.getMessage());
            } 
        }
    }
}

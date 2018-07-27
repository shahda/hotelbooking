package com.packt.hotelbook.stepDef;


import com.packt.hotelbook.utilis.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Cucumberhooks {

    public static WebDriver driver;
    public static String browser = "internet explorer";
    public static String URL ="http://hotel-test.equalexperts.io/";
    String Path;


    public Cucumberhooks() {
        driver = null;
//        PropertyReader envproperties  = new PropertyReader();
//        browser = envproperties.reaadProperty("browser");
//        URL= envproperties.reaadProperty("URL");
//       Log.info("The browser is "+browser);
//        Log.info("The URL is" +URL);

        }

    @Before
    public void beforeScenario (Scenario s) throws Exception {
            String sScenarioName = s.getName();
            Log.info("The scenario name is " +sScenarioName);
          if(driver == null) {
             try {
                 createNewDriverInstance();
            }

            catch (Exception e) {
            e.printStackTrace();
            throw e;
             }
        }
          driver.manage().window().maximize();
        }


    @After
    public void afterScenario (Scenario scenario) throws Exception
    {
        try {
            boolean ScenarioStatus = scenario.isFailed();
            if (ScenarioStatus) {
                Log.info("Scenario is failed");
                if (driver != null) {
                    driver.quit();
                    driver = null;
                    Log.info("The driver is closed for scenario " + scenario.getName());
                }
            } else if (!ScenarioStatus) {
                Log.info("Scenario is passed " + scenario.getName());
                if (driver != null) {
                    driver.quit();
                    driver = null;
                    Log.info("The driver is closed for scenario " + scenario.getName());
                }
                Log.info("**************SCENARIO Ended*********************");
            }
        }
        catch (Exception e)
        {
            Log.info("Browser has issue while quiting ");
            Log.info("**************SCENARIO Ended*********************");
        }
    }

    private void createNewDriverInstance()
    {
        try{
            Log.info("**************SCENARIO STARTED*********************");

//            String browser = "internet explorer";

            if (browser.equalsIgnoreCase("chrome"))
            {
                Path = "D:\\hotelbooking\\Browsers\\chrome\\win\\chromedriver.exe";
                driver = new ChromeDriver();
                Log.info("Driver selected is " +browser);
            }
            else if (browser.equalsIgnoreCase("internet explorer"))
            {
                Path = "D:\\hotelbooking\\Browsers\\ie\\win\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", Path);
                driver = new InternetExplorerDriver();
                Log.info("Driver selected is " +browser);
            }
            else if (browser.equalsIgnoreCase("firefox"))
            {
                Path = "D:\\hotelbooking\\Browsers\\firefox\\win\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", Path);
                driver = new FirefoxDriver();
                Log.info("Driver selected is " +browser);
            }
        }
        catch (AssertionError e)
        {
            driver = null;
            Log.info("URL or browser is not correct, Please correct URL or browser");
            Assert.fail();
        }
        catch(Exception e){
            driver = null;
            e.printStackTrace();
            Log.info("There is issue in Initializing the browser");
            Assert.fail();
        }
    }

}

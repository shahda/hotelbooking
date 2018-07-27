package com.packt.hotelbook.utilis;

import com.packt.hotelbook.stepDef.Cucumberhooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.apache.log4j.spi.Configurator.NULL;

public class TechnicalLibrary {
    WebDriver driver = Cucumberhooks.driver;

    public boolean IsElementPresent(WebElement element, String elementname)
    {
        try {
            return element.isDisplayed();
        }
        catch (Exception e) {
            Log.info("Webelement is not found -" +elementname );
            return false;
        }
    }

    public String gettextvalue(WebElement element, String elementname) {
        String value;
        try {
            if (IsElementPresent(element, elementname)) {
                value = element.getText();
                return value;
            } else {
                Log.info("Webelement is not found - " + elementname);
                Assert.fail("Webelement is not found - " + elementname);
                return NULL;
            }
        } catch (Exception e) {
            Log.info("The Webelement is not accessible - " + elementname);
            Assert.fail("The Webelement is not accessible - " + elementname);
            return NULL;
        }
    }
        //Entering the text
        public void enterText(WebElement element, String value, String elementname)
        {
            try {
                if (IsElementPresent(element,elementname))
                {
                    if(!(value.isEmpty()))      //Input element null check
                    {
                        element.clear();
                        element.sendKeys(value);
                        Log.info("Entered value in element - "+elementname);
                    }
                    else
                    {
                        Log.info("Input value is empty for field - " +elementname );
                        Assert.fail("Input value is empty for field - "+elementname);
                    }
                }
                else
                {
                    Log.info("Webelement is not found - " +elementname );
                    Assert.fail("Webelement is not found - "+elementname);
                }
            }
            catch (Exception e)
            {
                Log.info("The Webelement is not editable - " +elementname);
                Assert.fail("The Webelement is not editable - "+elementname);
            }
        }

        //Button click
        public void click(WebElement element, String elementname)
        {
            try {
                if (IsElementPresent(element,elementname))
                    if(element.isEnabled())
                    {
                        Log.info("button is enabled - "+elementname);
                        element.click();
                    }
                    else
                    {
                        Assert.fail("button is disabled - "+elementname);
                    }
                else
                {
                    Log.info("Webelement is not found -" +elementname );
                    Assert.fail("Webelement is not found - "+elementname);
                }
            }
            catch (Exception e)
            {
                Log.info("The webelement is not editable - " +elementname);
                Assert.fail("The webelement is not editable - "+elementname);
            }
        }
}

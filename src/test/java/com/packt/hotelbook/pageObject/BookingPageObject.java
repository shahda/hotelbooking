package com.packt.hotelbook.pageObject;


import com.packt.hotelbook.stepDef.Cucumberhooks;
import com.packt.hotelbook.utilis.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class BookingPageObject {

    WebDriver driver = Cucumberhooks.driver;

    @FindBy(id ="firstname")
    private static WebElement firstNameText;

    @FindBy(id ="lastname")
    private static WebElement lastNameText;

    @FindBy(id ="totalprice")
    private static WebElement priceText;

    @FindBy(id ="depositpaid")
    private static WebElement depositDropdown;

    @FindBy(id ="checkin")
    private static WebElement checkInDateCal;

    @FindBy(id ="checkout")
    private static WebElement checkOutDateCal;

    @FindBy(xpath = "//input[@value=' Save ']")
    private WebElement saveButton;

    @FindBy(css = "#bookings>.row:last-child>.col-md-1:nth-child(7)>input")
    private WebElement lastDeleteButton;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(1)")
    private WebElement lastFirstnameDiv;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(2)")
    private WebElement lastSurnameDiv;

    @FindBy(css = "#bookings>.row:last-child>.col-md-1:nth-child(3)")
    private WebElement lastPriceDiv;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(4)")
    private WebElement lastDepositDiv;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(5)")
    private WebElement lastCheckinDiv;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(6)")
    private WebElement lastCheckoutDiv;

    private static final String CURRENT_BOOKINGS = "#bookings>.row";

    public BookingPageObject(WebDriver driver){ PageFactory.initElements(driver, this);
    }

    public void addBookingDetails(String FirstName, String LastName, String Price, Boolean DepositPaid,String CheckInDate,String CheckOutDate) throws Exception
     {
       firstNameText.sendKeys(FirstName);
       lastNameText.sendKeys(LastName);
       priceText.sendKeys(Price);
       new Select(depositDropdown).selectByVisibleText(String.valueOf(DepositPaid));
       checkInDateCal.sendKeys(CheckInDate);
       checkOutDateCal.sendKeys(CheckOutDate);
       Thread.sleep(3000);
      }

    public void clickSave() throws Exception {
        int currentBookingCount = getCurrentBookingCount();
        saveButton.click();
        Thread.sleep(6000);
    }

    public int getCurrentBookingCount() {
        try {
            return driver.findElements(By.cssSelector(CURRENT_BOOKINGS)).size();
        }
        catch (AssertionError e)
        {
            driver = null;
            Log.info("Issue in Get Current Booking Count");
            Assert.fail();
            return 0;
        }
    }

    public void clickDelete() throws Exception
    {
        try{
            Integer currentBookingCount = getCurrentBookingCount();
            lastDeleteButton.click();
            Thread.sleep(5000);
        }
        catch (AssertionError e)
        {
            driver = null;
            Log.info("Issue in Delete Booking Count");
            Assert.fail();
        }
    }

}
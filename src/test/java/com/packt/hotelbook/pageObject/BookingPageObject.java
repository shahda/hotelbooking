package com.packt.hotelbook.pageObject;


import com.packt.hotelbook.stepDef.Cucumberhooks;
import com.packt.hotelbook.utilis.Log;
import com.packt.hotelbook.utilis.TechnicalLibrary;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.apache.log4j.spi.Configurator.NULL;

public class BookingPageObject {

    WebDriver driver = Cucumberhooks.driver;

    TechnicalLibrary TL = new TechnicalLibrary();

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
    private WebElement lastFirstName;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(2)")
    private WebElement lastName;

    @FindBy(css = "#bookings>.row:last-child>.col-md-1:nth-child(3)")
    private WebElement lastPrice;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(4)")
    private WebElement lastDeposit;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(5)")
    private WebElement lastCheckIn;

    @FindBy(css = "#bookings>.row:last-child>.col-md-2:nth-child(6)")
    private WebElement lastCheckOut;


    @FindBy(css = "#bookings>.row>id")
    private WebElement bookingNumber;

    private static final String CURRENT_BOOKINGS = "#bookings>.row";


    public BookingPageObject(WebDriver driver){ PageFactory.initElements(driver, this);
    }

    public void addBookingDetails(String FirstName, String LastName, String Price, Boolean DepositPaid,String CheckInDate,String CheckOutDate) {

       TL.enterText(firstNameText,FirstName,"FIRSTNAME");
       TL.enterText(lastNameText,LastName,"LASTNAME");
       TL.enterText(priceText,Price,"PRICE");
       new Select(depositDropdown).selectByVisibleText(String.valueOf(DepositPaid));
       TL.enterText(checkInDateCal,CheckInDate,"CHECKINDATE");
       TL.enterText(checkOutDateCal,CheckOutDate,"CHECKOUTDATE");

     }

    public void clickSave() throws Exception {
        int currentBookingCount = getCurrentBookingCount();

        Log.info("The booking count is "+currentBookingCount);

        TL.click(saveButton,"SAVEBUTTON");

        Thread.sleep(4000);
    }



    public void clickDelete() {
        try{
            Integer currentBookingCount = getCurrentBookingCount();

            TL.click(lastDeleteButton,"DELETEBUTTON");
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            driver = null;
            Log.info("Issue in Delete Booking Count");
            Assert.fail();
        }
    }

    public int getCurrentBookingCount() {
        try {

            return driver.findElements(By.cssSelector(CURRENT_BOOKINGS)).size();
        }
        catch (Exception e)
        {
            Log.info("Issue in Get Current Booking Count");
            Assert.fail();
            return 0;
        }
    }


    public String getFirstName() {
        try{
            return TL.gettextvalue(lastFirstName,"LASTFIRSTNAME");
        }
        catch (Exception e)
        {
            Log.info("Issue in getting last name Booking Count");
            Assert.fail();
            return NULL;
        }
    }

    public String getlastName() {
        try{
            return TL.gettextvalue(lastName,"LASTNAME");
        }
        catch (Exception e)
        {
            Log.info("Issue in getting last name Booking Count");
            Assert.fail();
            return NULL;
        }
    }

    public String getlastPrice() {
        try{
            return TL.gettextvalue(lastPrice,"LATESTPRICE");
        }
        catch (Exception e) {
            Log.info("Issue in getting last name Booking Count");
            Assert.fail();
            return NULL;
        }
    }

    public String getlastChecin() {
        try{
            return TL.gettextvalue(lastCheckIn,"LASTCHECKINDATE");
        }
        catch (Exception e)
        {
            Log.info("Issue in getting last name Booking Count");
            Assert.fail();
            return NULL;
        }
    }

    public String getlastChecout() {
        try{
            return TL.gettextvalue(lastCheckOut,"LASTCHECKOUTDATE");
        }
        catch (Exception e)
        {
            Log.info("Issue in getting last name Booking Count");
            Assert.fail();
            return NULL;
        }


    }
}
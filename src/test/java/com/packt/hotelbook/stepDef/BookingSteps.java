package com.packt.hotelbook.stepDef;

import com.packt.hotelbook.pageObject.BookingPageObject;
import com.packt.hotelbook.utilis.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BookingSteps {

    WebDriver driver = Cucumberhooks.driver;
    String iFirstName, iLastName,iPrice,iCheckInDate,iCheckOutDate;
    Boolean iDepositPaid;
    public int bookingCount;

    String URL  = Cucumberhooks.URL;

    @Given("^Client has Hotel booking page$")
    public void client_has_Hotel_booking_page() throws Throwable {
        driver.get(URL);
        Thread.sleep(2000);
    }

    @When("^Client enters booking details \"([^\"]*)\" ,\"([^\"]*)\" ,\"([^\"]*)\" ,\"([^\"]*)\" ,\"([^\"]*)\" ,\"([^\"]*)\" and saves it$")
    public void client_enters_booking_details_and_saves_it(String FirstName, String LastName, String Price, Boolean DepositPaid, String CheckInDate, String CheckOutDate) throws Throwable {
        BookingPageObject bookPO = new BookingPageObject(driver);
        bookPO.addBookingDetails(FirstName,LastName,Price,DepositPaid,CheckInDate,CheckOutDate);
        bookPO.clickSave();
        iFirstName = FirstName;
        iLastName = LastName;
        iPrice= Price;
        iDepositPaid = DepositPaid;
        iCheckInDate= CheckInDate;
        iCheckOutDate = CheckOutDate;

    }
    @Then("^Booking is completed$")
    public void booking_is_completed() {
        try {
            BookingPageObject bookPO = new BookingPageObject(driver);
            //Assert each details after it is saved and response is received
            Assert.assertEquals(iFirstName, bookPO.getFirstName());
            Assert.assertEquals(iLastName, bookPO.getlastName());
            Assert.assertEquals(iPrice, bookPO.getlastPrice());
            Assert.assertEquals(iCheckInDate, bookPO.getlastChecin());
            Assert.assertEquals(iCheckOutDate, bookPO.getlastChecout());
        }
        catch(Exception e)
        {
            Assert.fail("Details are not saved in Booking site");
        }
    }

    @Given("^I have Booking$")
    public void i_have_Booking() throws Throwable {
        client_has_Hotel_booking_page();
        BookingPageObject bookPO = new BookingPageObject(driver);
        bookingCount = bookPO.getCurrentBookingCount();
        Log.info("BookingCount before delete "+bookingCount);
    }

    @When("^I click the delete button for that booking$")
    public void i_click_the_delete_button_for_that_booking() {
        BookingPageObject bookPO = new BookingPageObject(driver);
        new BookingPageObject(driver).clickDelete();

     }

    @Then("^the booking is deleted$")
    public void the_booking_is_deleted() {
        try{
            BookingPageObject bookPO = new BookingPageObject(driver);
            Assert.assertEquals(bookingCount-1,bookPO.getCurrentBookingCount());
            Log.info("BookingCount after delete "+bookPO.getCurrentBookingCount());
        }
        catch(Exception e)
        {
            Assert.fail("Booking is not deleted correctly ");
        }

    }
}
package com.packt.hotelbook.stepDef;

import com.packt.hotelbook.pageObject.BookingPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BookingSteps {



    WebDriver driver = Cucumberhooks.driver;
    String iFirstName, iLastName,iPrice,iCheckInDate,iCheckOutDate;
    Boolean iDepositPaid;

    String URL  = "http://hotel-test.equalexperts.io/";

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
    public void booking_is_completed() throws Throwable {

        BookingPageObject bookPO = new BookingPageObject(driver);
    }

    @Given("^I have Booking$")
    public void i_have_Booking() throws Throwable {
        client_has_Hotel_booking_page();
    }

    @When("^I click the delete button for that booking$")
    public void i_click_the_delete_button_for_that_booking() throws Throwable {
        new BookingPageObject(driver).clickDelete();
            }

    @Then("^the booking is deleted$")
    public void the_booking_is_deleted() throws Throwable {

    }


}
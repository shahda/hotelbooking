Feature: Hotel Booking for Client

@Smoketest
Scenario Outline: Booking Hotel for client
Given Client has Hotel booking page
When Client enters booking details "<FirstName>" ,"<LastName>" ,"<Price>" ,"<DepositPaid>" ,"<CheckInDate>" ,"<CheckOutDate>" and saves it
Then Booking is completed

Examples:
|FirstName||LastName||Price||DepositPaid||CheckInDate||CheckOutDate|
|Sample||Sample||355||fale||2018-07-27||2018-07-31|
Feature: Hotel Booking for Client

@Smoketest
Scenario Outline: Booking Hotel for client
Given Client has Hotel booking page
When Client enters booking details "<FirstName>" ,"<LastName>" ,"<Price>" ,"<DepositPaid>" ,"<CheckInDate>" ,"<CheckOutDate>" and saves it
Then Booking is completed

Examples:
|FirstName||LastName||Price||DepositPaid||CheckInDate||CheckOutDate|
|John||Thomas||355||false||2018-08-03||2018-08-10|
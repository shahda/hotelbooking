Feature: Hotel Booking for Client

@Smoketest
Scenario Outline: Booking Hotel for client
Given Client has Hotel booking page
When Client enters booking details "<FirstName>" ,"<LastName>" ,"<Price>" ,"<DepositPaid>" ,"<CheckInDate>" ,"<CheckOutDate>" and saves it
Then Booking is completed

Examples:
|FirstName||LastName||Price||DepositPaid||CheckInDate||CheckOutDate|
|John||Travolta||356||false||2018-08-23||2018-08-24|
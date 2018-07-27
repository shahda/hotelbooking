Feature: Delete Booking for Client

@Smoketest
Scenario: Delete Booking  Hotel for client
Given I have Booking
When I click the delete button for that booking
Then the booking is deleted

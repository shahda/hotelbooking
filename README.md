Part 1

Summary of exploratory testing session:

Main findings
 UI Test - Issues

o There are no clear instructions on what the website is for, and the branding does not make it clear to whom it belongs. o There is no validation in first name and last name field about format/length/special characters. o Price field has no length validation. we can enter negative price in price field. We can enter infinite numbers after decimal point. Price field has no currency format o Deposit field should have checkbox and field does not provide any details as to what is meant for. Deposit dropdown box is not correctly aligned with other fields o Space between Price and Deposit labels is not correctly placed o As it is hotel Booking form, all the required fields should be marked as mandatory o Email address should be added for Booking confirmation and there should be way to search the booking after confirmation o Check in Date can be of Past which is issue and check in date can be greater than check out date o Check Out date can be of past and can less than check-in date
 System Testing - Issues

o When we enter the URL, in the console, error message related to unable to get booking id property id is seen with null reference. This is issue as it is trying get booking ID as we hit the website. o When we click the save button without input, front end does not prompt any user error as no input is added and HTTP error 500 is displayed as server is not able to process the request without details. o When all fields are entered and save button is clicked, it confirms that record is saved but no booking id or reference is provided. o Booking after saving is displayed to another session on another browser and allows to delete. o There is information missing in the form: email, currency, type of room etc. o When we enter alphabets or comma in price field there is server error but nothing displayed on UI. There is no frontend validation for any of the fields and also there are no error displayed to user when any action is incorrect. o Site does not provide any information on what is the relation of price to deposit. Is the price related to deposit paid or entire amount of booking?  

Security - Issues
o The site is unencrypted HTTP (NO SSL certificate) o No privacy policy or cookie message

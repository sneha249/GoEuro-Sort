# GoEuro-Sort
#This project is an automated test that will make a search between Berlin and Prague and will verify that the sorting by price is correct for trains.

#Technology Used
#Java (1.8),TestNG,Logger

#Instructions for executing the test
#Run the testng.xml in SuiteXML folder.

#Details on the java files
#There are 3 packages - one for the page object, one for the main test and constants and the third one for logging utilities
#GoEuroSearchPage.java - Page object for the home page of GoEuro.
#GoEuroResultPage.java - Page object for the result page of the query made
#GoEuroConstants.java - This a file to maintain the constants required , similar can be achieved by using a .property file as well.
#MainTest.java - This is the main test where the page objects and constant files are used. I have included the validation in this test itself in a different method named "price_Validation". This method can be reused for any mode like flight,bus,train
#ListenerUtil.java - Listener Class to make the testng execution more informative
#LoggingUtil.java - Util class to use logger for debugging/analysing the test results


#Reports:
#Refresh your project after execution to see the updated reports
# The log file is generated under the logs folder in the user directory with the name of GoEuroTest-Timestamp
# The index.html in the test-output folder in the user directory


# GoEuro-Sort
#This project is an automated test that will make a search between Berlin and Prague and will verify that the sorting by price is correct for trains.

#Instructions for executing the test
#Run the testng.xml in SuiteXML folder.

#Details on the java files
#There are 2 packages - one for the page object and the other one for the main test and constants
#GoEuroSearchPage.java - Page object for the home page of GoEuro.
#GoEuroResultPage.java - Page object for the result page of the query made
#GoEuroConstants.java - This a file to maintain the constants required , similar can be achieved by using a .property file as well.
#MainTest.java - This is the main test where the page objects and constant files are used. I have included the validation in this test itself in a different method named "price_Validation". This method can be reused for any mode like flight,bus,train
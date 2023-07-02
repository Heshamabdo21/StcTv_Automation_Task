STCTV_Subscriptions
An assessment repo for an interview process Scenario : Given I have navigated to https://subscribe.stctv.com/sa-en When I Click on Country selection Button And I Select one of the listed countries ex.[KSA] Then Packages names will be listed accordingly to the selected country And Packages prices will be changed to the selected country's national currency This code is to validate packages type , price and cuurency for KSA , Kuwait and Bahrain
====================================================
Description
A simple test automation framework build with Java, TestNG, Selenium WebDriver ,DDT ,Extent Report and allure.
====================================================
Requirements:
JDK 17
Eclipse IDE
Eclipse TestNG Plugin: https://testng.org/doc/eclipse.html
==================================
Tech Stach:
===================================
Maven
TestNG
Selenium
Log4j2
Allure-reports
Extent Report
=======================================
Run Configuration
Eclipse IDE TestNG Plugin
Right-click on 'TestNG.xml' file
Choose Run As -> TestNG Suite
Generate allure report via cmd 'allure serve allure-results'
Eclipse IDE Maven
Right-click on project 'pom.xml' file
Choose Run As -> Maven test
Generate allure report via cmd 'allure serve allure-results'
Maven
Run command 'mvn clean test'
Navigate to the project directory.
Generate allure report via cmd 'allure serve allure-results'
===========================================
Test output
===========================================
===Allure Report path : ./allure-results 
===Logs path : ./Log4j2 
===Extent Report Path : ./SavedExtentReports

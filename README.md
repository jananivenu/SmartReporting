Smart Reporting Demo

I have  prepare Automated Tests for the demo application available at
https://computer- database.gatling.io/computers
Task 1) 

I have created feature file with 3 scenarios for automation considering the following user stories (US):
•US-01: As an inventory manager, I want to add a computer to the system, including its introduction and discontinuation dates, so I can track product lifecycles, identify outdated equipment, and make informed decisions about purchasing,
upgrades, and support
•US-02: As an inventory manager, I want to filter computers by their names. To search by name, I want the ability to enter at least two letters in the search field. This will allow me to easily track similar or exact product lines
•US-03: As an inventory manager, I want to edit the details of a specific computer in the system. I should be able to
select a computer by name from a list or search bar. Once selected, I want to be able to update Computer name, Introduced, Discontinued, and the Company from a prefilled list

I have followed the test demo with below technologies:
- Java JDK 17
- Selenium
- Junit5
- Cucumber [Gherkin Syntax]
- Automated the execution (CI/CD) with Github actions
I have executed the tests only with Chrome Driver using WebDriver Manager
We can include other drivers further if required.





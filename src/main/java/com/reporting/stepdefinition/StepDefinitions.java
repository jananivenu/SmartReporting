package com.reporting.stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StepDefinitions {

    private WebDriver driver;
    private String computerName;

    public StepDefinitions() {
        this.driver = Hooks.getDriver();
    }


    @Given("I am in the computer database")
    public void i_am_in_the_computer_database() {
        driver.get("https://computer-database.gatling.io/computers");
        System.out.println("I am in the computer database");
        //throw new io.cucumber.java.PendingException();
    }

    @When("I click Add a new computer button")
    public void i_click_Add_a_new_computer_button() {
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Add a new computer')]"));
        button.click();
        System.out.println("Add a new computer Button clicked");
        //throw new PendingException();
    }

    @When("Enter the computer name field {string}")
    public void enter_the_computer_name_field(String computerName) {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(computerName);
        System.out.println("Entered the computer name");
    }
    @When("Enter the computer introduced date field {string}")
    public void enter_the_computer_introduced_date_field(String introducedDate) {
        driver.findElement(By.xpath("//input[@id='introduced']")).sendKeys(introducedDate);
        System.out.println("Entered the introduced date");
    }
    @When("Enter the computer discontinued date date field {string}")
    public void enter_the_computer_discontinued_date_date_field(String discontinuedDate) {
        driver.findElement(By.xpath("//input[@id='discontinued']")).sendKeys(discontinuedDate);
        System.out.println("Entered the discontinued date");
    }
    @When("Select the computer company manufacturer field {string}")
    public void select_the_computer_company_manufacturer_field(String company) {
        Select company_dropdown = new Select(driver.findElement(By.id("company")));
        company_dropdown.selectByVisibleText(company);
        System.out.println("Selected the company");
    }

    @When("Click the Create this computer button")
    public void click_the_create_this_computer_button() {
        WebElement createButton= driver.findElement(By.xpath("//input[@value='Create this computer']"));
        createButton.click();
        System.out.println("Create this computer button clicked");
    }

    @Then("A new computer is added to the inventory with a success message")
    public void a_new_computer_is_added_to_the_inventory_with_a_success_message() throws InterruptedException {

        String actualString = driver.findElement(By.xpath("//*[contains(text(), 'Computer test has been created')]")).getText();
        String expectedString = "Done ! Computer test has been created";
        assertTrue(actualString.equals(expectedString));
        Thread.sleep(5000);
        System.out.println("A new computer is added to the inventory");

    }


    @When("I search for computer names with min two letters {string}")
    public void i_search_for_computer_names_with_min_two_letters(String computerName) {
        this.computerName = computerName;
        driver.findElement(By.xpath("//input[@type='search' and  @placeholder='Filter by computer name...']")).sendKeys(computerName);
        System.out.println("I search for computer names with min two letters");
        //throw new io.cucumber.java.PendingException();
    }

    @When("click Filter by name button")
    public void click_Filter_by_name_button() {
        WebElement filterButton = driver.findElement(By.xpath("//input[@value='Filter by name']"));
        filterButton.click();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("filtered list of computer names are displayed containing the searched name")
    public void filtered_list_of_computer_names_are_displayed_containing_the_searched_name() {
        String xpathExpression = String.format(
                "//a[contains(@href, '/computers/') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]",
                computerName.toLowerCase()
        );
        List<WebElement> filteredResult = driver.findElements(By.xpath(xpathExpression));
//        String actualUpdateString = driver.findElement(By.xpath("//*[contains(text(), 'Computer ACE has been updated')]")).getText();
//        String expectedUpdateString = "Done ! Computer ACE has been updated";
//        assertTrue(actualUpdateString.equals(expectedUpdateString));
        if(filteredResult.size()>0) {
            System.out.println("filtered list of computer names are displayed below:");
            for (WebElement element : filteredResult) {
                System.out.println(element.getText());
            }
        }
        else
            System.out.println("No computer names found/Nothing to display");
        //throw new io.cucumber.java.PendingException();
    }

    @When("I select on the computer name from list {string}")
    public void i_select_on_the_computer_name_from_list(String filterName) {
        WebElement computerSearch = driver.findElement(By.xpath("//a[contains(@href, '/computers/') and text()='" + filterName + "']"));
        computerSearch.click();
        System.out.println("I selected the computer name from list");
        //throw new io.cucumber.java.PendingException();
    }

    @When("updated Computer details")
    public void updated_computer_details() {
//        driver.findElement(By.xpath("//input[@type='search' and  @placeholder='Filter by computer name...']")).sendKeys(computerName);
//        WebElement filterButton = driver.findElement(By.xpath("//input[@value='Filter by name']"));
//        filterButton.click();
        driver.findElement(By.id("introduced")).sendKeys("2014-04-04");
        WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Save this computer']"));
        saveButton.click();
        System.out.println("edited Computer details");
    }

    @Then("Computer details should be updated")
    public void computer_details_should_be_updated() {
        String actualUpdateString = driver.findElement(By.xpath("//*[contains(text(), 'Computer ACE has been updated')]")).getText();
        String expectedUpdateString = "Done ! Computer ACE has been updated";
        assertTrue(actualUpdateString.equals(expectedUpdateString));
        System.out.println("Computer details are  be updated");
    }
}

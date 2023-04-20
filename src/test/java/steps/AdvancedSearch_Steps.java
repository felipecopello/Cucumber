package steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdvancedSearch_Steps {

    WebDriver driver;

    public AdvancedSearch_Steps(Common_Steps common) {
	this.driver = common.getDriver();
    }

    @Given("I am in Ebay advanced page")
    public void i_am_on_the_ebay_homepage() {
	driver.get("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay logo")
    public void i_click_the_advanced_search_button() {
	driver.findElement(By.xpath("//a[text()='Home']")).click();
    }

    @Then("I navigate to Ebay home page")
    public void i_should_be_taken_to_advanced_search_page() {
	String expectedURLString = "https://www.ebay.com/";
	String actualURLString = driver.getCurrentUrl();
	if (!expectedURLString.equalsIgnoreCase(actualURLString)) {
	    fail("urls do not match");
	}
    }

}

package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_Steps {
    WebDriver driver;

    public EbayHome_Steps(Common_Steps common) {
	this.driver = common.getDriver();
    }

    @Given("I am on the Ebay Homepage")
    public void i_am_on_the_ebay_homepage() {
	driver.get("https://www.ebay.com/");
    }

    @When("I click the advanced search button")
    public void i_click_the_advanced_search_button() {
	driver.findElement(By.id("gh-as-a")).click();
    }

    @Then("I should be taken to advanced search page")
    public void i_should_be_taken_to_advanced_search_page() {
	String expectedURLString = "https://www.ebay.com/sch/ebayadvsearch";
	String actualURLString = driver.getCurrentUrl();
	if (!expectedURLString.equalsIgnoreCase(actualURLString)) {
	    fail("urls do not match");
	}
    }

    @When("I input the search parameters {string}")
    public void i_input_the_search_parameters(String parameter) {
	driver.findElement(By.id("gh-ac")).sendKeys(parameter);

    }

    @When("I click the search button")
    public void i_click_the_search_button() {
	driver.findElement(By.id("gh-btn")).click();
    }

    @Then("I should see at least {int} results")
    public void i_should_see_at_least_results(int resultAmmount) {
	String ammountString = driver.findElement(By.cssSelector("h1>span:first-child")).getText().trim().replace(".",
		"");
	int ammount = Integer.parseInt(ammountString);
	if (ammount < resultAmmount) {
	    fail("less than 1000 matches found");
	}
    }

    @When("I select {string} category")
    public void i_select_category(String category) {
	driver.findElement(By.id("gh-cat")).click();
	List<WebElement> optionsList = driver.findElements(By.cssSelector("select#gh-cat>option"));
	for (WebElement wb : optionsList) {
	    if (wb.getText().trim().equalsIgnoreCase(category)) {
		wb.click();
		break;
	    }
	}
	;
    }

}

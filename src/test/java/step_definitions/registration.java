package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class registration {

    @And("User can navigate to home page")
    public void navigateHome(){
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("User click on the register link")
    public void clickRegister(){
        Hooks.driver.findElement(By.className("ico-register")).click();
    }

    @When("User Enter valid Your Personal Details")
    public void validPersonalDetails(){
        Hooks.driver.findElement(By.cssSelector("input[id^=\"FirstName\"]")).sendKeys("Test");
        Hooks.driver.findElement(By.cssSelector("input[id^=\"LastName\"]")).sendKeys("Website");
        Hooks.driver.findElement(By.name("Email")).sendKeys("test1@examble.com");
    }

    @And("User Enter valid Password")
    public void EnterValidPassword (){
        Hooks.driver.findElement(By.id("Password")).sendKeys("P@ssword");
        Hooks.driver.findElement(By.id("ConfirmPassword")).sendKeys("P@ssword");
    }

    @And("User clicks on register button")
    public void clicksRegisterButton(){
        Hooks.driver.findElement(By.xpath("//button[contains(@name,\"register-button\")]")).click();
    }

    @Then("Success message is displayed")
    public void successMessageDisplayed() {
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).isDisplayed());

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).isDisplayed());
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/register?returnUrl=%2F"));
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("<a href=\"/customer/info\" class=\"ico-account\">My account</a>")).isDisplayed());

        soft.assertAll();

    }

    @And("User quits driver")
    public void quitsDriver(){
        Hooks.driver.quit();
    }
}

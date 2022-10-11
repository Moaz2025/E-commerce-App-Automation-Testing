package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Hooks {

   static WebDriver driver;
    @Given("User can open the Chrome Browser")
    public static void openBrowser(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        }

    public static void closeBrowser(){
        driver.quit();
    }

}

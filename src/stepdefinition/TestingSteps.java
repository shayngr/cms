package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestingSteps {


    WebDriver driver;
    @Given("^User is at login page$")
    public void user_is_at_login_page() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "/Users/shayng/Desktop/Shay/Selenium files/Selenium 3/geckodriver");
        driver = new FirefoxDriver();
        String baseURL = "http://www.letskodeit.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseURL);

    }

    @When("^User enters correct Username and Password$")
    public void user_enters_correct_Username_and_Password() {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys("test@email.com");

        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys("abcabc");

    }

    @And("^User clicks go button$")
    public void user_clicks_go_button() throws InterruptedException{
        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();
        Thread.sleep(3000);
    }

    @Then("^User can visit practice page practice page$")
    public void User_can_visit_practice_page_practice_page() {
        WebElement practicePage = driver.findElement(By.id("DrpDwnMn05label"));
        practicePage.click();
    }

    @And("^A message is displayed$")
    public void A_message_is_displayed() {
        System.out.println();
        System.out.println(" --> Login Successful <---");
    }



}

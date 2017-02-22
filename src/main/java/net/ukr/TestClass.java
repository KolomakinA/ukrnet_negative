package net.ukr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by kolom on 21.02.2017.
 */
public class TestClass {
    private WebDriver driver;
    private UkrNetSignUpPage signUp;
    private UkrNetLoginPage logIn;


    @BeforeTest
    public void openPage(){
        driver = new ChromeDriver();
        driver.get("https://oauth.ukr.net/registration");
        signUp = PageFactory.initElements(driver,UkrNetSignUpPage.class);
        logIn = PageFactory.initElements(driver,UkrNetLoginPage.class);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeChrome(){
        driver.quit();
    }

    @Test(priority=1)
    public void negLoginIsTaken() throws InterruptedException {
        Assert.assertEquals(signUp.negLoginIsTakken("admin"), true,"\n ERROR: \"Login is already taken\" message is not displayed \n");
        signUp.clearLoginField();
    }

    @Test(priority=2)
    public void negDotAtTheBeginning(){
        Assert.assertEquals(signUp.negDotAtTheBeginning(".admin"), true,"\n ERROR: No error message has been printed out when user entered a dot at the beginning of the login \n");
        signUp.clearLoginField();
    }

    @Test(priority=3)
    public void negDotAtTheEnd(){
        Assert.assertEquals(signUp.negDotAtTheEnd("admin."),true,"\n ERROR: No error message has been printed out when user entered a dot at the end of the login \n");
        signUp.clearLoginField();
    }

    @Test(priority=4)
    public void negContainExclamMark(){
        Assert.assertEquals(signUp.negContainExclamMark("ad!min"),true,"\n ERROR: No error message has been printed out when user entered an exclamation mark \n");
        signUp.clearLoginField();
    }

    @Test(priority = 5)
    public void negContainAt(){
        Assert.assertEquals(signUp.negContainAt("ad@min"),true,"\n ERROR: No error message has been printed out when user entered an extra @ character\n");
        signUp.clearLoginField();
    }

    @Test(priority = 6)
    public void negEmptyField(){
        Assert.assertEquals(signUp.negEmptyField(""),true,"\n ERROR: No error message has been printed out when user did not enter anything\n");
        signUp.clearLoginField();
    }
    @Test(priority = 7)
    public void negContainSpace(){
        Assert.assertEquals(signUp.negContainSpace("a dmin"),true,"\n ERROR: No error message has been printed out when user printed a space in the string\n");
        signUp.clearLoginField();
    }
    @Test(priority = 8)
    public void posLogIn() throws InterruptedException {
        driver.get("https://www.ukr.net/");
        Assert.assertEquals(logIn.logInFormIsDisplayed(),true,"\n ERROR: Login form is not displayed\n");
        logIn.loginToSystem("main_acad_hw@ukr.net","123123123");
        Assert.assertEquals(logIn.isLoggedIn(),true,"\n ERROR: Login failed\n");
    }
}


package net.ukr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kolom on 21.02.2017.
 */
public class UkrNetLoginPage {
    @FindBy(name="Login")
    private WebElement login;

    @FindBy(name="Password")
    private WebElement password;

    @FindBy(linkText = "Листи")
    private WebElement mailBoxLink;

    public boolean logInFormIsDisplayed()throws org.openqa.selenium.NoSuchElementException{
        if(login.isDisplayed() && password.isDisplayed()) return true;
        else return false;
    }


    public void loginToSystem(String uname, String upass)throws org.openqa.selenium.NoSuchElementException{
        login.sendKeys(uname);
        password.sendKeys(upass);
        password.submit();
    }
     public boolean isLoggedIn(){
        if(mailBoxLink.isDisplayed()) return true;
        return false;
     }
}

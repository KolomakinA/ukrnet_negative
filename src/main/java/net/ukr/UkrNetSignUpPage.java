package net.ukr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by kolom on 21.02.2017.
 */
public class UkrNetSignUpPage {

        //Objects for login form
        @FindBy(css = "input.field-login")
        private WebElement mailName;
        @FindBy(css = ".error-message")
        private WebElement errorMessage;
        @FindBy (css = "p.error")
        private WebElement loginIsTaken;





        @FindBy(id = "LJgfS")
        private WebElement mailPass;
        @FindBy(id = "b6dxY")
        private WebElement mailPassConf;
        @FindBy(id = "Wphdu")
        private WebElement uFName;
        @FindBy(id = "HL0np")
        private WebElement uLName;
        @FindBy(id = "birth-day")
        private WebElement uBDay;
        @FindBy(id = "birth-month")
        private WebElement uBMonth;
        @FindBy(id = "birth-year")
        private WebElement uBYear;
        @FindBy(id = "sex-1")
        private WebElement uSexIsMale;
        @FindBy(id = "yhQ0k")
        private WebElement senderCreds;
        @FindBy(id = "w7Lgb")
        private WebElement backupMail;
        @FindBy(id = "Wq23b")
        private WebElement phoneNumb;
        @FindBy(xpath = "/html/body/main/section[2]/button/strong")
        private WebElement sendCodeToThePhoneNumb;
        @FindBy(xpath = "/html/body/footer/button")
        private WebElement signUpButton;


        //--------------------------------------------------------------------------------------------------------------

    public void clearLoginField() throws org.openqa.selenium.NoSuchElementException{
        mailName.clear();
    }
    public boolean negLoginIsTakken(String p) throws org.openqa.selenium.NoSuchElementException, InterruptedException {
        mailName.sendKeys(p);
        Thread.sleep(500);
        if (loginIsTaken.isDisplayed()) return true;
        else return false;
    }
    public boolean negDotAtTheBeginning(String p) throws org.openqa.selenium.NoSuchElementException{
        mailName.sendKeys(p);
        if (errorMessage.isDisplayed()) return true;
        else return false;
    }
    public boolean negDotAtTheEnd(String p) throws org.openqa.selenium.NoSuchElementException{
        mailName.sendKeys(p);
        if (errorMessage.isDisplayed()) return true;
        else return false;
    }
    public boolean negContainExclamMark(String p) throws org.openqa.selenium.NoSuchElementException{
        mailName.sendKeys(p);
        if (errorMessage.isDisplayed()) return true;
        else return false;
    }
    public boolean negContainAt(String p)throws org.openqa.selenium.NoSuchElementException{
        mailName.sendKeys(p);
        if (errorMessage.isDisplayed()) return true;
        else return false;
    }
    public boolean negEmptyField(String p)throws org.openqa.selenium.NoSuchElementException{
        mailName.sendKeys(p);
        if (errorMessage.isDisplayed()) return true;
        else return false;
    }
    public boolean negContainSpace(String p)throws org.openqa.selenium.NoSuchElementException{
        mailName.sendKeys(p);
        if (errorMessage.isDisplayed()) return true;
        else return false;
    }
}

package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HerokuapPage {
    public HerokuapPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "email")
    public WebElement emailText;
    @FindBy(id = "password")
    public WebElement passwordText;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement verify;



}

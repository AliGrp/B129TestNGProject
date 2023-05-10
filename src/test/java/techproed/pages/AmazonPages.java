package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonPages {
    public AmazonPages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "searchDropdownBox")
    public WebElement dropDownMenu;
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    // C02_Raporlama LOCATE

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi1;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement sonucYazisi2;

}

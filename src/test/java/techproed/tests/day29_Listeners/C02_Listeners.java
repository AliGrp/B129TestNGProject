package techproed.tests.day29_Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
@Listeners(techproed.utilities.Listeners.class)
public class C02_Listeners {

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));
        Driver.getDriver().findElement(By.xpath("//*[@class='sdadfsfsd']"));//yanlis locate aldim
    }
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
    }
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test03() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys("erol@gmail.com", Keys.TAB,"12345",Keys.ENTER);
    }

}

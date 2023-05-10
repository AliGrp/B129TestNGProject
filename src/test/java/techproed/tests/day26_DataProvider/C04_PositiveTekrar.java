package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

import java.util.Iterator;

public class C04_PositiveTekrar {
 /*

Acceptance Criteria:
Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
Ve giris yapilmadiginda
Hata mesaji almali : Please first login
Giris yapildiginda hata mesaji alınmamalı

         */
    @DataProvider
    public Object[][] kullaniciBilgileri(){

        String path = "C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfaIsmi= "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sayfaIsmi);

        return excelUtils.getDataArrayWithoutFirstRow();
    }


    @Test(dataProvider = "kullaniciBilgileri",retryAnalyzer = techproed.utilities.Listeners.class)
    public void test01(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();

        Actions actions = new Actions(Driver.getDriver());
        WebElement secim =blueRentalPage.aracSecimi;
        actions.click(secim).keyDown(Keys.PAGE_DOWN).perform();
        actions.keyDown(Keys.ESCAPE).perform();

        blueRentalPage.pickUp.sendKeys("Istanbul",Keys.TAB,"Ankara",Keys.TAB,"10.05.2023",
                Keys.TAB,"1200",Keys.TAB,"15.05.2023",Keys.TAB,"1200");

        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email,Keys.TAB,password,Keys.ENTER);
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());

        Driver.closeDriver();


    }
}

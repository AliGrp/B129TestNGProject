package techproed.tests.practise_day02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.TestBase;
import techproed.utilities.TestBaseRapor;

public class C02_Raporlama extends TestBaseRapor {
// 'https://www.amazon.com' adresine gidin
// arama kutusuna "Java" yazip aratın
// sonuc yazisinin "Java" icerdigini test edin
// kontrollu olarak yeni bir sayfa acın
// yeni acılan sayfada "Kitap" aratın
// sonuc yazisinin Kitap icerdigini test edin

// test raporu alınız

    @Test
    public void test01() {
        extentTest=extentReports.createTest("testname,tanim");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPages amazonPages = new AmazonPages();
        amazonPages.searchBox.sendKeys("Java", Keys.ENTER);
        extentTest.pass("arama kutusuna java yazilip aratildi");

        Assert.assertTrue(amazonPages.sonucYazisi1.getText().contains("Java"));
        extentTest.pass("sonuc yazisi java icerdigi test edildi");

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        extentTest.pass("yeni pencere acildi amazona gidildi");
        amazonPages.searchBox.sendKeys("Kitap",Keys.ENTER);
        extentTest.pass("arama kutusunda kitap aratildi");
        Assert.assertTrue(amazonPages.sonucYazisi2.getText().contains("Kitap"));
        extentTest.pass("sonuz yazisinin kitap icerdigi test edildi");


    }
}

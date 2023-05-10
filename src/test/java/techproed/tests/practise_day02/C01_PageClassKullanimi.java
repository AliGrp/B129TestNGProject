package techproed.tests.practise_day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.TestBase;

import java.io.File;

public class C01_PageClassKullanimi {

            // amazon sayfasına gidin
        // dropdown'dan "Computers" optionunu secin
        // arama motoruna "Asus" yazıp aratın
        // ikinci urunun fotografını cekin
        // ikinci urune tıklayın
        // title'ının "ASUS" icerdigini test edin
        // sayfayı kapatın


    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPages amazonPages = new AmazonPages();
        Select select = new Select(amazonPages.dropDownMenu);
        select.selectByVisibleText("Computers");

        amazonPages.searchBox.sendKeys("Asus", Keys.ENTER);

        WebElement ikinciUrun =Driver.getDriver().findElement(By.xpath("(//*[@class='s-image'])[2]"));
        String dosyaYolu = "TestOutput/screenShot/screenShot.png";
        try {
            FileUtils.copyFile(ikinciUrun.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        ikinciUrun.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("ASUS"));

        Driver.closeDriver();

    }
}

package techproed.tests.practise_day01;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DemoQAPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.io.ObjectInputFilter;

public class Task13 {

    //https://demoqa.com/ url'ine gidin.
//Alerts, Frame & Windows Butonuna click yap
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
//New Tab butonunun görünür olduğunu doğrula
//New Tab butonuna click yap
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
//İlk Tab'a geri dön
////New Tab butonunun görünür olduğunu doğrula


    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("demoQa_Url"));
    }
    @Test(dependsOnMethods = "test01")
    public void test02() {
        DemoQAPage demoQAPage = new DemoQAPage();
        demoQAPage.aFWButonu.click();
        System.out.println(demoQAPage.message.getText());


        Assert.assertEquals(demoQAPage.message.getText(),"Please select an item from left to start practice.");
    }
}

package techproed.tests.practise_day02;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HerokuapPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_NegativeLoginDataProvider {
    @DataProvider
    public static Object[][] test() {
        return new Object[][]{{"ali@gmail.com","12345"},{"veli@gmail.com","1234"}};
    }

    // https://id.heroku.com/login sayfasına gidin
// yanlıs email ve yanlıs password giriniz
// login butonuna tıklayınız
// "There was a problem with your login." yazisinin gorunur oldugunu test edin
// sayfayı kapatınız


// NOT: birden fazla email ve password'u dataProvider kullanarak sırayla deneyin

    @Test(dataProvider = "test")
    public void test01(String email, String password) {
        Driver.getDriver().get("https://id.heroku.com/login");

        HerokuapPage herokuapPage=new HerokuapPage();
        herokuapPage.emailText.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        Assert.assertTrue(herokuapPage.verify.isDisplayed());
    }
}

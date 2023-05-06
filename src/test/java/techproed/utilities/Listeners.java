package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static techproed.utilities.ReusableMethods.tumSayfaResmi;

public class Listeners implements ITestListener {
    /*
        Listeners; TestNG de bir test'in durumunu ve sonucunu izleyen ve bu duruma yanıt veren bir yapıdır.
        Testlerin passed ve failed olma durumlarını, başlangıç ve bitişini takip eder ve raporlayabilir.
            Bunun için TestNG'den ITestListener arayüzünü(interface) kullanırız. Oluşturduğumuz Listeners
        class'ına ITestListener arayüzündeki methodları Override etmek için implements ederiz.
         */
    public  void onStart(ITestContext context){//BeforeClass gibi
        System.out.println("onStart()==> Tüm testlerden önce bir kez çalışır(Class'tan önce)"+context.getName());
    }

    public  void onFinish(ITestContext context){
        System.out.println("onFinish()==> Tüm testlerden sonra bir kez çalışır(Class'tan sonra)"+context.getName());
    }

    public void onTestStart(ITestResult result){//before gibi
        System.out.println("onTestStart()==> Her bir @Test'ten önce bir kez çalışır"+result.getName());
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("onTestSuccess()==> Sadece PASS olan testlerden sonra çalışır"+result.getName());
    }

    public void onTestFailure(ITestResult result){
        System.out.println("onTestFailure()==> Sadece FAIL olan testlerden sonra çalışır"+result.getName());
        tumSayfaResmi(result.getName());
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("onTestSkipped()==> Sadece SKIP olan testlerden sonra çalışır"+result.getName());
    }
}

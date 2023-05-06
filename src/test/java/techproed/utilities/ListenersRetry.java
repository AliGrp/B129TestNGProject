package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry implements IRetryAnalyzer {
    /*
    Test class'ımızda fail olma durumu olan bir testin listeners ile tekrar çalışmasını istersek
    @Test notasyonundan sonra parametre olarak retryAnalyzer yazar ve oluşturmuş olduğumuz ListenersRetry class'ının
    yolunu belirtiriz.
    */
    private int retryCount = 0;
    private static final int maxRetryCount = 1;//Fail sonrasi tekrar sayisi
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}

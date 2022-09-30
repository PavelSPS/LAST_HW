import Screens.CartModal;
import Screens.MobileTopUpScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MobileTopUpTest {
    private WebDriver driver;

    String testPaymentCard = "5169 3305 2361 2213";

    String testExpiredDate = "10/24";

    String testCvv = "188";

    String testReceiverCard = "4149 4390 4868 9115";

    String minAmount = "1";

    String fromCardValue = "5169 3305 2361 2213";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://next.privat24.ua/money-transfer/card");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTopUpMinSum() throws InterruptedException {
        MobileTopUpScreen mobileTopUpScreen = new MobileTopUpScreen(driver);
        mobileTopUpScreen.navigate();
        mobileTopUpScreen.fillPaymentCard(testPaymentCard);
        mobileTopUpScreen.fillExpiredDate(testExpiredDate);
        mobileTopUpScreen.fillCvv(testCvv);
        mobileTopUpScreen.fillReceiverCard(testReceiverCard);
        mobileTopUpScreen.fillAmount(minAmount);
        mobileTopUpScreen.submitButtonClick();
        Thread.sleep(3000);
        CartModal cartModal = new CartModal(driver);
        Assert.assertEquals(fromCardValue, cartModal.getTestCardValue());
    }
}

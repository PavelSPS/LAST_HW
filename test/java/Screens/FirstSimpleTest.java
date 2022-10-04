package Screens;

import org.junit.Assert;;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstSimpleTest {
    By paymentCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By receiverCard = By.xpath("//input[@data-qa-node='numberreceiver']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By submitButton = By.xpath("//button[@type='submit']");
    By fromCard = By.xpath("//span[@data-qa-node='payer-card']");


    String testPaymentCard = "5169 3305 2361 2213";

    String testExpiredDate = "10/24";

    String testCvv = "***";

    String testReceiverCard = "4149 4390 4868 9115";

    String minAmount = "1";

    String fromCardValue = "5169 3305 2361 2213";

    private WebDriver driver;

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
        driver.findElement(paymentCard).sendKeys(testPaymentCard);
        driver.findElement(expiredDate).sendKeys(testExpiredDate);
        driver.findElement(cvv).sendKeys(testCvv);
        driver.findElement(receiverCard).sendKeys(testReceiverCard);
        driver.findElement(amount).sendKeys(minAmount);
        driver.findElement(submitButton).submit();

        Thread.sleep(3000);
        Assert.assertEquals(fromCardValue, driver.findElement(fromCard).getText());


    }

}

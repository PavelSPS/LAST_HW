package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileTopUpScreen {
        By paymentCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By receiverCard = By.xpath("//input[@data-qa-node='numberreceiver']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By submitButton = By.xpath("//button[@type='submit']");

        String mobileTopUpUrl = "https://next.privat24.ua/money-transfer/card";

        private static WebDriver driver;

        public MobileTopUpScreen (WebDriver driver){
            this.driver = driver;
        }

        public void navigate(){
            driver.get(mobileTopUpUrl);
        }

        public void fillPaymentCard(String paymentCard){
            driver.findElement(this.paymentCard).sendKeys(paymentCard);
        }

        public void fillExpiredDate(String expiredDate){
             driver.findElement(this.expiredDate).sendKeys(expiredDate);
        }

        public void fillCvv(String cvv){
                driver.findElement(this.cvv).sendKeys(cvv);
        }

        public void fillReceiverCard(String receiverCard){
                driver.findElement(this.receiverCard).sendKeys(receiverCard);
        }

        public void fillAmount(String amount){
                driver.findElement(this.amount).sendKeys(amount);
        }

        public void submitButtonClick(){
                driver.findElement(submitButton).submit();
        }











}

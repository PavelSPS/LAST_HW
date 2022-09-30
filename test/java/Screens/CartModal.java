package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartModal {

    By fromCard = By.xpath("//span[@data-qa-node='payer-card']");
    private static WebDriver driver;

    public CartModal(WebDriver driver){
        this.driver = driver;
    }

    public String getTestCardValue(){
        return driver.findElement(fromCard).getText();
    }
}

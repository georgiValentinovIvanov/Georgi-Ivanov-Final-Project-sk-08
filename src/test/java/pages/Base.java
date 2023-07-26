package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected final WebDriver driver;
    protected WebDriverWait smallWait;
    protected WebDriverWait mediumWait;


    public Base(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mediumWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void clickElement(WebElement element) {
        smallWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }
    public String getElementText(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void waitForVisibility(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyUrl(String URL) {
        mediumWait.until(ExpectedConditions.urlToBe(URL));
    }


    public void verifyUrlContains(String url) {
        mediumWait.until(ExpectedConditions.urlContains(url));
    }

}

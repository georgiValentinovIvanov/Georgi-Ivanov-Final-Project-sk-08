package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Modal extends Base {
    @FindBy(tagName = "app-post-modal")
    WebElement modal;
    @FindBy(css = "input[placeholder='Comment here']")
    WebElement commentt;
    @FindBy(tagName = "app-post")
    WebElement newModal;

    public Modal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForDialogAppear() {
        mediumWait.until(ExpectedConditions.visibilityOf(modal));
    }

    public void writeComment(String comment) {
        enterText(commentt, comment);
        commentt.sendKeys(Keys.RETURN);
    }

    public String getCommentText() {
        WebElement newComment =driver.findElement(By.xpath(".//*[contains(text(), 'exa')]"));
        return newComment.getText();
    }

}

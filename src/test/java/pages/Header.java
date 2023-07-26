package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Header extends Base {

    @FindBy(id = "nav-link-login")
    WebElement loginLink;
    @FindBy(linkText = "Profile")
    WebElement profileLink;
    @FindBy(id = "nav-link-new-post")
    WebElement newPostLink;
    @FindBy(linkText = "Delete post")
    WebElement deleteBtn;
    @FindBy(linkText = "Yes")
    WebElement confirmBtn;
    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void goToLogin() {
        clickElement(loginLink);
    }
    public void goToProfile() {
        clickElement(profileLink);
    }
    public void goToNewPost() {
        clickElement(newPostLink);
    }
    public void clickDeleteBtn() {
        clickElement(deleteBtn);
    }
    public void clickConfirmBtn() {
        clickElement(confirmBtn);
    }
}

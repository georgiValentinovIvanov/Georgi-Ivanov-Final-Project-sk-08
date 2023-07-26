package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Profile extends Base {
    private final String BASE_urll = "http://training.skillo-bg.com:4200/users/";
    @FindBy(css = ".profile-user-settings > h2")
    WebElement username;
    @FindBy(css = "app-post")
    List<WebElement> existingPosts;
    @FindBy(css = ".btn-all")
    WebElement goToAllPosts;

    public Profile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getUsernameHeaderText() {
        return getElementText(username);
    }

    public void verifyUrl() {
        verifyUrlContains(BASE_urll);
    }

    public int getExistingPost() {
        return existingPosts.size();
    }

    public void openPostByIndex(int index) {
        if (existingPosts.size() > 0 && index >= 0 && index < existingPosts.size()) {
            clickElement(existingPosts.get(index));
        } else {
            System.out.println("No posts available.");

        }

    }

    public void goToAllPosts() {
        clickElement(goToAllPosts);
    }
}
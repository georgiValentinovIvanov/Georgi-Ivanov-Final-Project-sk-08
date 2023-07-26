package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class NewPost extends Base {
    private final String URL = "http://training.skillo-bg.com:4200/posts/create";
    @FindBy(css = "input.file[type = 'file']")
    WebElement fileUpload;
    @FindBy(id = "create-post")
    WebElement submitBtn;
    @FindBy(name = "caption")
    WebElement captionInput;
    @FindBy(css = "input.input-lg")
    WebElement fileName;
    @FindBy(css = ".image-preview")
    WebElement imagePreview;

    public NewPost(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(URL);
    }

    public void uploadPost(File file) {
        fileUpload.sendKeys(file.getAbsolutePath());
    }

    public void waitForPicToShow() {
        smallWait.until(ExpectedConditions.visibilityOf(imagePreview));
    }

    public String getPicName() {
        smallWait.until(ExpectedConditions.visibilityOf(fileName));
        return fileName.getAttribute("placeholder");
    }

    public void caption(String text) {
        enterText(captionInput, text);
    }

    public void clickSubmit() {
        clickElement(submitBtn);
    }
}

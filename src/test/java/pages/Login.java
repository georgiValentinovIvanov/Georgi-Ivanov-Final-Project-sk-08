package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends Base {
    public final String URL="http://training.skillo-bg.com:4200/users/login";
    WebDriverWait wait;
    @FindBy(css = "form .h4")
    WebElement signIn;
    @FindBy(name = "usernameOrEmail")
    WebElement userName;
    @FindBy(name = "password")
    WebElement pass;
    @FindBy(id = "sign-in-button")
    WebElement signInBtn;
    @FindBy(linkText = "Register")
    WebElement registerBtn;
    @FindBy(css = ".fa-sign-out-alt")
    WebElement LogoutBtn;
    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public String getSignInText(){
        wait.until(ExpectedConditions.visibilityOf(signIn));
        return signIn.getText();
    }
    public void usernameText (String username){
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys(username);;
    }
    public void passwortText(String password){
        enterText(pass , password);

    }
    public void signIn(){
        clickElement(signInBtn);
    }
    public void verifyUrl(){
        verifyUrl(URL);
    }
    public void login(String username, String password){
        usernameText(username);
        passwortText(password);
        signIn();
    }
    public void RegisterBtn(){
        clickElement(registerBtn);
    }
    public void clickLogOut(){
        clickElement(LogoutBtn);
    }
}

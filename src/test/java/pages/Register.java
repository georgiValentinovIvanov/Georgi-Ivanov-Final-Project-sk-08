package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register extends Base{
    public final String REGISTER_URL = "http://training.skillo-bg.com/users/register";
    @FindBy(css=".text-center.mb-4")
    WebElement SignUp;
    @FindBy(name="username")
    WebElement usernameTextt;
    @FindBy(css=".form-control.ng-untouched.ng-pristine")
    WebElement emailTextt;
    @FindBy(name="password")
    WebElement passwordTextt;
    @FindBy(name="verify-password")
    WebElement confirmPasswordTextt;
    @FindBy(id="sign-in-button")
    WebElement submitBtn;
    public Register(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void signUpHeader(){
        waitForVisibility(SignUp);
    }
    public void enterUsername(String username){
        enterText(usernameTextt ,username);
    }
    public void enterEmail(String email){
        enterText(emailTextt, email);
    }
    public void enterPassword (String password){
        enterText(passwordTextt, password);
    }
    public void enterVerifyPassword(String confrimPassword){
        enterText(confirmPasswordTextt , confrimPassword);
    }
    public void clickSubmitBtn(){
        clickElement(submitBtn);
    }
}

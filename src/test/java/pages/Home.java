package pages;

import org.openqa.selenium.WebDriver;

public class Home extends Base {
    private final String URL="http://training.skillo-bg.com:4200/posts/all";
    public Home(WebDriver driver) {
        super(driver);
    }
    public void openSite(){
        driver.get(URL);
    }
    public void verifyUrl(){
        verifyUrl(URL);
    }
}

package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.Home;
import pages.Login;
import pages.Register;

public class TestCase07 extends BaseMethod{
    @DataProvider(name="getUsers")
    public Object[][] getUsers(){
        return new Object[][]{{"Joro.QA2","joroQA2@abv.bg","joroQA123","joroQA123"}};
    }
    @Test(dataProvider = "getUsers")
    public void userРegistration(String username, String email , String password , String confirmPassword){
        System.out.println("1. Open web site.");
        Home homePage=new Home(driver);
        homePage.openSite();

        System.out.println("2. Click Login Btn.");
        Header headerPage=new Header(driver);
        headerPage.goToLogin();

        System.out.println("3.Go to Register Btn.");
        Login loginPage=new Login(driver);
        loginPage.RegisterBtn();

        System.out.println("4. Enter username with credit data.");
        Register register=new Register(driver);
        register.enterUsername(username);
        System.out.println("5. Enter email with credit data.");
        register.enterEmail(email);
        System.out.println("6. Enter email with credit data.");
        register.enterPassword(password);
        System.out.println("7.Enter confirm password.");
        register.enterVerifyPassword(confirmPassword);
        System.out.println("8. Click to submit Btn.");
        register.clickSubmitBtn();

        System.out.println("9.Go to home page.");
        Home home=new Home(driver);
        home.openSite();
    }
}

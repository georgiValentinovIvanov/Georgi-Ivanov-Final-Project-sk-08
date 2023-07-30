package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.Home;
import pages.Login;
import pages.Register;

public class TestCase06 extends BaseMethod {
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"Joro.QA", "joroQA123"}};
    }

    @Test(dataProvider = "getUsers")
    public void LogOut(String username, String password) {
        System.out.println("1. Open site.");
        Home homePage = new Home(driver);
        homePage.openSite();

        System.out.println("2. Click loginBtn.");
        Header headerPage = new Header(driver);
        headerPage.goToLogin();
        Login loginPage = new Login(driver);
        loginPage.verifyUrl();
        loginPage.login(username, password);

        System.out.println("3. Click Logout Btn.");
        loginPage.clickLogOut();
        loginPage.verifyUrl();

        System.out.println("4.Verify Profile Btn is not visible");
        headerPage.invisibleProfileButton();
    }
}

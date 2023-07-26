package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.Home;
import pages.Login;
import pages.Profile;

public class TestCase01 extends BaseMethod{
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"Joro.QA", "joroQA123", "Joro.QA"},
                {"joroQA@abv.bg", "joroQA123", "Joro.QA"}
        };
    }
    @Test(dataProvider = "getUsers")
    public void loginTest(String userNameOrEmail, String pass, String username) {

        System.out.println("1. Open Web Site to ISkillo training platform");
        Home homePage = new Home(driver);
        homePage.openSite();

        System.out.println("2. Click to login btn");
        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        System.out.println("3. Verify the URL is correct");
        Login loginPage = new Login(driver);
        loginPage.verifyUrl();

        System.out.println("4. Sign in is displayed ");
        String headerText = loginPage.getSignInText();
        Assert.assertEquals(headerText, "Sign in", "Incorrect Sign in header text!");

        System.out.println("5. Enter user name");
        loginPage.usernameText(userNameOrEmail);

        System.out.println("6. Enter pass");
        loginPage.passwortText(pass);

        System.out.println("7. Click sign in btn");
        loginPage.signIn();

        System.out.println("8. Verify the URL is correct");
        homePage.verifyUrl();

        System.out.println("9. Profile Btn is visible and user can clickable ");
        headerPage.goToProfile();
        System.out.println("10. Verify the URL is correct");
        Profile profilePage = new Profile(driver);
        profilePage.verifyUrl();
        System.out.println("11. Verify the user name");

        String usernameHeaderText = profilePage.getUsernameHeaderText();
        Assert.assertEquals(usernameHeaderText, username, "Incorrect username!");
    }
}

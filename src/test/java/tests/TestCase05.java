package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class TestCase05 extends BaseMethod{
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"Joro.QA", "joroQA123"}};
    }

    @Test(dataProvider = "getUsers")
    public void commentPost(String username, String password) {

        System.out.println("1. Open Skillo Site URL.");
        Home homePage = new Home(driver);
        homePage.openSite();

        System.out.println("2. Click loginBtn.");
        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        Login loginPage = new Login(driver);
        loginPage.verifyUrl();
        loginPage.login(username, password);

        System.out.println("3. Go to profile page.");
        headerPage.goToProfile();

        System.out.println("4. Open the latest post.");
        Profile profilePage = new Profile(driver);
        int currentPostCount = profilePage.getExistingPost();
        profilePage.openPostByIndex(currentPostCount - 1);
        Modal postModalPage = new Modal(driver);
        postModalPage.waitForDialogAppear();

        System.out.println("5. Comment on the post.");
        postModalPage.waitForDialogAppear();
        postModalPage.writeComment("exa");

        System.out.println("6. Confirm that the comment is displayed.");
        String commentText = postModalPage.getCommentText();
        Assert.assertEquals(commentText, "exa", "The comment is not displayed");
    }
}

package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;


public class TestCase04 extends BaseMethod{
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"Joro.QA", "joroQA123"}};
    }

    @Test(dataProvider = "getUsers")
    public void deletePost(String username, String password)throws InterruptedException {
        System.out.println("1. Open Skillo Site URL.");
        Home homePage = new Home(driver);
        homePage.openSite();

        System.out.println("2. Click LoginBtn and login.");
        Header headerPage = new Header(driver);
        headerPage.goToLogin();
        Login loginPage = new Login(driver);
        loginPage.verifyUrl();
        loginPage.login(username, password);

        System.out.println("3. Go to profile page on all posts and get current posts count.");
        Profile profilePage = new Profile(driver);
        profilePage.goToAllPosts();
        profilePage.verifyUrl();

        int currentPostCount = profilePage.getExistingPost();

        if (currentPostCount == 0) {
            System.out.println("No posts available for deletion.");
            return;
        }

        System.out.println("4. Open the last post.");
        profilePage.openPostByIndex(0);

        System.out.println("5. Click delete and confirm.");
        headerPage.clickDeleteBtn();
        headerPage.clickConfirmBtn();

        System.out.println("6. Check if the pop-up confirmation has appeared.");
        Assert.assertTrue(driver.findElement(By.id("toast-container")).isDisplayed(), "Confirmation does not appear.");

        System.out.println("7. Confirm that there are no posts.");
        profilePage.goToAllPosts();
        int existingPosts = profilePage.getExistingPost();
        Assert.assertEquals(existingPosts, currentPostCount - 1, "Incorrect post number.");
    }
}

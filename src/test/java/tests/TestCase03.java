package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;

public class TestCase03 extends BaseMethod{
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"Joro.QA", "joroQA123", new File("src/test/java/upload/project-sk08.png"), "The best QA academy"}};
    }

    @Test(dataProvider = "getUsers")
    public void NewPostTest(String username, String password, File file, String caption) {
        System.out.println("1. Open WebSite to Skillo trainig platform.");
        Home homePage = new Home(driver);
        homePage.openSite();

        System.out.println("2. Login.");
        Header header = new Header(driver);
        header.goToLogin();
        Login loginPage = new Login(driver);
        loginPage.verifyUrl();
        loginPage.login(username, password);

        System.out.println("3. Go to profile page.");
        header.goToProfile();

        Profile profilePage = new Profile(driver);
        profilePage.verifyUrl();
        int existingPosts = profilePage.getExistingPost();

        System.out.println("4. Go to new post.");
        header.goToNewPost();
        NewPost postPage = new NewPost(driver);
        postPage.verifyUrl();

        System.out.println("5. Upload a new picture.");
        postPage.uploadPost(file);

        System.out.println("6. Verify that the image is visible.");
        postPage.waitForPicToShow();

        System.out.println("7. Verify the image name is correct.");
        Assert.assertEquals(postPage.getPicName(), file.getName());

        System.out.println("8. Populate the post caption.");
        postPage.caption(caption);

        System.out.println("9. Click create post.");
        postPage.clickSubmit();
        profilePage.verifyUrl();

        System.out.println("10. Verify the post number has increased.");
        int currentPostCount = profilePage.getExistingPost();
        Assert.assertEquals(currentPostCount, existingPosts+1 , "Incorrect post number");

        System.out.println("11. Open the latest post.");
        profilePage.openPostByIndex(currentPostCount-1);
        Modal postModal = new Modal(driver);
        postModal.waitForDialogAppear();
    }
}

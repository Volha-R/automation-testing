package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.pastebin.MainPage;
import pageobject.pastebin.UsersPastePage;

public class PasteBinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver.quit();
    }

    @Test(description = "Create new paste with code, expiration time, name")
    public void shouldCreateNewPasteWithParticularCodeExpirationTimeName() {
        UsersPastePage usersPastePage = new MainPage(driver)
                .openPasteBinMainPage()
                .pasteTextInNewPasteField("Hello from WebDriver")
                .setExpirationTime()
                .setName("helloweb")
                .submitNewPaste();
        Assert.assertEquals("helloweb", usersPastePage.getPasteName());
    }

    @Test(description = "Create new paste with code, syntax highlighting, expiration time, name")
    public void shouldCreateNewPasteWithParticularCodeSyntaxHighlightingExpirationTimeName() {
        UsersPastePage usersPastePage = new MainPage(driver)
                .openPasteBinMainPage()
                .pasteTextInNewPasteField("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .setSyntaxHighlighting()
                .setExpirationTime()
                .setName("how to gain dominance among developers")
                .submitNewPaste();

        Assert.assertEquals("how to gain dominance among developers", usersPastePage.getPasteName());
        Assert.assertEquals("Bash", usersPastePage.getSyntaxHighlightingAppliedToText());
        Assert.assertEquals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force", usersPastePage.getRawPasteData());
    }

}

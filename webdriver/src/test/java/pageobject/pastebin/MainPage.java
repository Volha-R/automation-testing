package pageobject.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static final String MAIN_PAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(id = "paste_code")
    private WebElement pasteField;

    @FindBy(xpath = "//select[@name='paste_format']/following-sibling::span")
    private WebElement syntaxHighlightingPasteDropdown;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashSyntaxHihglightingOption;

    @FindBy(xpath = "//select[@name='paste_expire_date']/following-sibling::span")
    private WebElement expirationPasteDropdown;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMinutesExpirationTimeOption;

    @FindBy(name = "paste_name")
    private WebElement nameTitleField;

    @FindBy(id = "submit")
    private WebElement createNewPasteButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPasteBinMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public MainPage pasteTextInNewPasteField(String text) {
        pasteField.sendKeys(text);
        return this;
    }

    public MainPage setSyntaxHighlighting() {
        syntaxHighlightingPasteDropdown.click();
        bashSyntaxHihglightingOption.click();
        return this;
    }

    public MainPage setExpirationTime() {
        expirationPasteDropdown.click();
        tenMinutesExpirationTimeOption.click();
        return this;
    }

    public MainPage setName(String name) {
        nameTitleField.click();
        nameTitleField.sendKeys(name);
        return this;
    }

    public UsersPastePage submitNewPaste() {
        createNewPasteButton.click();
        return new UsersPastePage(driver);
    }

}

package pageobject.pastebin;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

public class UsersPastePage {
    private WebDriver driver;
    public UsersPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='paste_box_info']/child::div[@class='paste_box_line1']")
    private WebElement pastedDataPageTitle;

    @FindBy(xpath = "//div[@id='code_buttons']/span[@class='h_640']/a")
    private WebElement bashSyntaxHighlightingApplayedToText;

    @FindBy(xpath = "//textarea[@id='paste_code']")
    private WebElement rawPasteDataField;

    public String getPasteName() {
        return pastedDataPageTitle.getAttribute("title");
    }

    public String getSyntaxHighlightingAppliedToText() {
        return bashSyntaxHighlightingApplayedToText.getText();
    }

    public String getRawPasteData() {
        return rawPasteDataField.getText();
    }

}

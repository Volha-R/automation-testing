package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TemporaryEmailPage {
    private WebDriver driver;
    private String emailAddress;

    public TemporaryEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='mailAddress']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//div[@id='messagesList']")
    private WebElement emailReceivedField;

    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost')]")
    private WebElement costField;

    public String getEmailAddress() {
        return emailAddress;
    }

    public TemporaryEmailPage openPage() {
        driver.get("https://10minutemail.com");
        return this;
    }
    public TemporaryEmailPage copyEmail() {
        emailAddress = emailAddressField.getAttribute("value");
        return this;
    }

    public TemporaryEmailPage openEmail() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(emailReceivedField))
                .click();
        return this;
    }

    public String getEstimatedCoast() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(costField));

        return costField.getText();
    }
}

package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailEstimationWindow extends EstimationResultComponent {

    public EmailEstimationWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ("//label[contains(text(), 'Email')]/following-sibling::input"))
    private WebElement emailField;

    @FindBy(xpath = ("//*[@aria-label='Send Email']"))
    private WebElement sendEmailButton;

    public EmailEstimationWindow pasteEmailAddress(String emailAddress) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("idIframe"));
        emailField.sendKeys(emailAddress);
        return this;
    }

    public void sendEmail() {
        sendEmailButton.click();
    }
}

package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EstimationResultComponent extends PricingCalculatorPage {

    public EstimationResultComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'VM class')]")
    private WebElement vMClassField;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'Instance type')]")
    private WebElement instancetypeField;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'Region')]")
    private WebElement regionField;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'local SSD')]")
    private WebElement localSSDField;

    @FindBy(xpath = "//md-content[@id='compute']//div[contains(text(), 'Commitment term')]")
    private WebElement commitmentTermField;

    @FindBy(xpath = "//md-content[@id='compute']//*[contains(text(), 'Estimated Component Cost:')]")
    private WebElement estimatedComponentCostField;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;

    public String getVMClass() {
        return vMClassField.getText();
    }

    public String getInstanceType() {
        return instancetypeField.getText();
    }

    public String getRegion() {
        return regionField.getText();
    }

    public String getLocalSSD() {
        return localSSDField.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTermField.getText();
    }

    public String getEstimatedComponentCost() {
        return estimatedComponentCostField.getText();
    }

    public EmailEstimationWindow chooseEmailEstimation() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return new EmailEstimationWindow(driver);
    }
}

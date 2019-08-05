package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage {
    protected WebDriver driver;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computeEngineOptionButton;

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ComputeEngineComponent chooseComputeEngineOption() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("idIframe"));
        computeEngineOptionButton.click();
        return new ComputeEngineComponent(driver);
    }
}

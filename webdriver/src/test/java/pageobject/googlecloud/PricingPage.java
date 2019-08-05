package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@track-name='pricingNav/calculators']")
    private WebElement calculatorButton;

    public PricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage openPricingCalculatorPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(calculatorButton))
                .click();
        return new PricingCalculatorPage(driver);
    }
}

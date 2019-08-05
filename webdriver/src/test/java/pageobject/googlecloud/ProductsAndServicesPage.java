package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsAndServicesPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@track-name='seePricing']")
    private WebElement seePricingButton;

    public ProductsAndServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingPage openPricingPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(seePricingButton))
                .click();
        return new PricingPage(driver);
    }
}

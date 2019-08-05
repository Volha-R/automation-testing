package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'See all products')]")
    private WebElement seeAllProductsButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openMainPage() {
        driver.get("https://cloud.google.com");
        return this;
    }

    public ProductsAndServicesPage openProductsAndServicesPage() {
        seeAllProductsButton.click();
        return new ProductsAndServicesPage(driver);
    }
}

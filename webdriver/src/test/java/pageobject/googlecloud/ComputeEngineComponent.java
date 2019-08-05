package pageobject.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputeEngineComponent extends PricingCalculatorPage{

    public ComputeEngineComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='input_52']")
    private WebElement numberOfInstancesOption;

    @FindBy(xpath = "//*[@id='select_value_label_45']")
    private WebElement operatingSystemSoftwareOption;

    @FindBy(xpath = "//*[@id='select_option_54']")
    private WebElement operatingSystemSoftwareIsFree;

    @FindBy(xpath = "//*[@id='select_68']")
    private WebElement machineClassOption;

    @FindBy(xpath = "//*[@id='select_option_66']")
    private WebElement machineClassIsRegular;

    @FindBy(xpath = "//*[@id='select_75']")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//*[@id='select_option_211']")
    private WebElement machineTypeIsN1Standard8vCPUs8RAM30GB;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement gPUsCheckbox;

    @FindBy(xpath = "//*[@id='select_336']")
    private WebElement numberOfGPUsOption;

    @FindBy(xpath = "//*[@id='select_option_341']")
    private WebElement numberOfGPUsIsOne;

    @FindBy(xpath = "//*[@id='select_value_label_335']")
    private WebElement gPUTypeOption;

    @FindBy(xpath = "//*[@id='select_option_346']")
    private WebElement gPUTypeIsNVIDIATeslaV100;

    @FindBy(xpath = "//*[@id='select_value_label_49']")
    private WebElement localSSDOption;

    @FindBy(xpath = "//*[@id='select_option_167']")
    private WebElement localSSSIs2times375;

    @FindBy(xpath = "//*[@id='select_value_label_50']")
    private WebElement datacenterLocationOption;

    @FindBy(xpath = "//*[@id='select_option_181']")
    private WebElement datacenterLocationIsFrankfurt;

    @FindBy(xpath = "//*[@id='select_value_label_51']")
    private WebElement committedUsageOption;

    @FindBy(xpath = "//*[@id='select_option_82']")
    private WebElement committedUsageIsOneYear;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button")
    private WebElement addToEstimateButton;


    public ComputeEngineComponent setNumberOfInstancesOption() {
        numberOfInstancesOption.click();
        numberOfInstancesOption.sendKeys("4");
        return this;
    }

    public ComputeEngineComponent expandOperatingSystemDropdown() {
        operatingSystemSoftwareOption.click();
        return this;
    }

    public ComputeEngineComponent setOperatingSystemOptionIsFree() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(operatingSystemSoftwareIsFree))
                .click();
        return this;
    }

    public ComputeEngineComponent expandMachineClassDropdown() {
        machineClassOption.click();
        return this;
    }

    public ComputeEngineComponent setMachineClassOptionIsRegular() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(machineClassIsRegular))
                .click();
        return this;
    }

    public ComputeEngineComponent expandMachineTypeDropdown() {
        machineTypeOption.click();
        return this;
    }

    public ComputeEngineComponent setMachineTypeOptionIsN1Standard8vCPUs8RAM30GB() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(machineTypeIsN1Standard8vCPUs8RAM30GB))
                .click();
        return this;
    }

    public ComputeEngineComponent toggleGPUsCheckbox() {
        gPUsCheckbox.click();
        return this;
    }

    public ComputeEngineComponent expandGPUsNumberDropdown() {
        numberOfGPUsOption.click();
        return this;
    }

    public ComputeEngineComponent setGPUsNumberToOne() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(numberOfGPUsIsOne))
                .click();
        return this;
    }

    public ComputeEngineComponent expandGPUTypeDropdown() {
        gPUTypeOption.click();
        return this;
    }

    public ComputeEngineComponent setGPUTypeIsNVIDIATeslaV100() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(gPUTypeIsNVIDIATeslaV100))
                .click();
        return this;
    }

    public ComputeEngineComponent expandLocalSSDOption() {
        localSSDOption.click();
        return this;
    }

    public ComputeEngineComponent setLocalSSDIs2times375() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(localSSSIs2times375))
                .click();
        return this;
    }

    public ComputeEngineComponent expandDatacenterLocationDropdown() {
        datacenterLocationOption.click();
        return this;
    }

    public ComputeEngineComponent setDatacenterLocationToFrankfurt() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(datacenterLocationIsFrankfurt))
                .click();
        return this;
    }

    public ComputeEngineComponent expandCommittedUsageDropdown() {
        committedUsageOption.click();
        return this;
    }

    public ComputeEngineComponent setCommittedUsageToOneYear() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(committedUsageIsOneYear))
                .click();
        return this;
    }

    public EstimationResultComponent clickAddToEstimateButton() {
        addToEstimateButton.click();
        return new EstimationResultComponent(driver);
    }
}

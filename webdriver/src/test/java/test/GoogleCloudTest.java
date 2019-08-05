package test;

import pageobject.googlecloud.TemporaryEmailPage;
import pageobject.googlecloud.EmailEstimationWindow;
import pageobject.googlecloud.EstimationResultComponent;
import pageobject.googlecloud.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GoogleCloudTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver.quit();
    }

    @Test(description = "Check if input data matches expected after estimation in correspondent fields")
    public void shouldCheckInputDataMatchesExpectedDataAfterEstimation() {
        EstimationResultComponent productsAndServicesPage = new MainPage(driver)
                .openMainPage()
                .openProductsAndServicesPage()
                .openPricingPage()
                .openPricingCalculatorPage()
                .chooseComputeEngineOption()
                .setNumberOfInstancesOption()
                .expandOperatingSystemDropdown()
                .setOperatingSystemOptionIsFree()
                .expandMachineClassDropdown()
                .setMachineClassOptionIsRegular()
                .expandMachineTypeDropdown()
                .setMachineTypeOptionIsN1Standard8vCPUs8RAM30GB()
                .toggleGPUsCheckbox()
                .expandGPUsNumberDropdown()
                .setGPUsNumberToOne()
                .expandGPUTypeDropdown()
                .setGPUTypeIsNVIDIATeslaV100()
                .expandLocalSSDOption()
                .setLocalSSDIs2times375()
                .expandDatacenterLocationDropdown()
                .setDatacenterLocationToFrankfurt()
                .expandCommittedUsageDropdown()
                .setCommittedUsageToOneYear()
                .clickAddToEstimateButton();

        Assert.assertTrue(productsAndServicesPage.getVMClass().contains("regular"));
        Assert.assertTrue(productsAndServicesPage.getInstanceType().contains("n1-standard-8"));
        Assert.assertTrue(productsAndServicesPage.getRegion().contains("Frankfurt"));
        Assert.assertTrue(productsAndServicesPage.getLocalSSD().contains("2x375 GB"));
        Assert.assertTrue(productsAndServicesPage.getCommitmentTerm().contains("1 Year"));
    }

    @Test(description = "Check if final cost matches expected cost after estimation with particular input data")
    public void shouldCheckIfEstimationPriceIsCorrect() {
        EstimationResultComponent productsAndServicesPage = new MainPage(driver)
                .openMainPage()
                .openProductsAndServicesPage()
                .openPricingPage()
                .openPricingCalculatorPage()
                .chooseComputeEngineOption()
                .setNumberOfInstancesOption()
                .expandOperatingSystemDropdown()
                .setOperatingSystemOptionIsFree()
                .expandMachineClassDropdown()
                .setMachineClassOptionIsRegular()
                .expandMachineTypeDropdown()
                .setMachineTypeOptionIsN1Standard8vCPUs8RAM30GB()
                .toggleGPUsCheckbox()
                .expandGPUsNumberDropdown()
                .setGPUsNumberToOne()
                .expandGPUTypeDropdown()
                .setGPUTypeIsNVIDIATeslaV100()
                .expandLocalSSDOption()
                .setLocalSSDIs2times375()
                .expandDatacenterLocationDropdown()
                .setDatacenterLocationToFrankfurt()
                .expandCommittedUsageDropdown()
                .setCommittedUsageToOneYear()
                .clickAddToEstimateButton();

        Assert.assertTrue(productsAndServicesPage.getEstimatedComponentCost().contains("USD 1,187.77 per 1 month"));
    }

    @Test(description = "Check if cost in email matches cost shown after estimation as Total Estimated Coast")
    public void shouldCheckIfCoastInEmailCorrect() {
        EmailEstimationWindow emailEstimationWindow = new MainPage(driver)
                .openMainPage()
                .openProductsAndServicesPage()
                .openPricingPage()
                .openPricingCalculatorPage()
                .chooseComputeEngineOption()
                .setNumberOfInstancesOption()
                .expandOperatingSystemDropdown()
                .setOperatingSystemOptionIsFree()
                .expandMachineClassDropdown()
                .setMachineClassOptionIsRegular()
                .expandMachineTypeDropdown()
                .setMachineTypeOptionIsN1Standard8vCPUs8RAM30GB()
                .toggleGPUsCheckbox()
                .expandGPUsNumberDropdown()
                .setGPUsNumberToOne()
                .expandGPUTypeDropdown()
                .setGPUTypeIsNVIDIATeslaV100()
                .expandLocalSSDOption()
                .setLocalSSDIs2times375()
                .expandDatacenterLocationDropdown()
                .setDatacenterLocationToFrankfurt()
                .expandCommittedUsageDropdown()
                .setCommittedUsageToOneYear()
                .clickAddToEstimateButton()
                .chooseEmailEstimation();

        ((JavascriptExecutor)driver).executeScript("window.open();");

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        TemporaryEmailPage temporaryEmailPage = new TemporaryEmailPage(driver)
                .openPage()
                .copyEmail();

        driver.switchTo().window(windowHandles.get(0));

        emailEstimationWindow.pasteEmailAddress(temporaryEmailPage.getEmailAddress()).sendEmail();

        driver.switchTo().window(windowHandles.get(1));

        temporaryEmailPage = temporaryEmailPage.openEmail();
        Assert.assertEquals(temporaryEmailPage.getEstimatedCoast(), "Estimated Monthly Cost: USD 1,187.77");
    }
}

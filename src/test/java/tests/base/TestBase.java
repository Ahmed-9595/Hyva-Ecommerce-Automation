package tests.base;

import com.revton.qa.factoryPage.DriverFactory;
import com.revton.qa.pages.*;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(Method method) {
        // Initialize drivers
        driver = new DriverFactory().initialization();

    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        String testResult = result.getMethod().getMethodName();
        String fileName = "target/screenshots/" + testResult + ".png";
        captureScreenShot(fileName);
        if (driver != null) {
            driver.quit();
        }
    }
    // Take screenShot after finishing test
    public void captureScreenShot(String fileName) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream inputStream = new FileInputStream(fileName)) {
            Allure.addAttachment("screenshots",inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

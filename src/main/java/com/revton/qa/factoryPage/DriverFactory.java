package com.revton.qa.factoryPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver initialization() {
        // Handle different browsers
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver;

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--force-device-scale-factor=0.9"); // Set zoom to 90%
                options.addArguments("--high-dpi-support=0.9");
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize(); // Firefox does not support zoom via options
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--force-device-scale-factor=0.9"); // Set zoom to 90%
                driver = new EdgeDriver(options);
            }
            default -> throw new RuntimeException("The browser is not supported");
        }

        driver.manage().window().maximize();
        return driver;
    }
}

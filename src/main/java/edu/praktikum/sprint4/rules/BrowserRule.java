package edu.praktikum.sprint4.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserRule extends ExternalResource {

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    protected void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Override
    protected void after() {
        webDriver.quit();
    }
}

package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotFoundError {

    private final WebDriver webDriver;

    private final By notFound = By.xpath(".//img[@alt='Not found']");

    public NotFoundError(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkShown() {
        return webDriver.findElements(notFound).size() > 0;
    }
}

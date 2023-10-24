package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru";

    private final WebDriver webDriver;

    private final By checkOrderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final By orderInputField = By.xpath(".//input[contains(@class, 'Header_Input__xIoUq')]");
    private final By goButton = By.xpath(".//button[text()='Go!']");

    private final NotFoundError notFoundError;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        notFoundError = new NotFoundError(webDriver);
    }

    public MainPage open() {
        webDriver.get(URL);
        return this;
    }

    public MainPage clickCheckOrder() {
        webDriver.findElement(checkOrderButton).click();
        return this;
    }

    public MainPage inputOrder(String orderName) {
        webDriver.findElement(orderInputField).sendKeys(orderName);
        return this;
    }

    public MainPage clickGo() {
        webDriver.findElement(goButton).click();
        return this;
    }

    public NotFoundError notFoundError() {
        return notFoundError;
    }

    public By getCheckOrderButton() {
        return checkOrderButton;
    }

    public By getOrderInputField() {
        return orderInputField;
    }

    public By getGoButton() {
        return goButton;
    }
}

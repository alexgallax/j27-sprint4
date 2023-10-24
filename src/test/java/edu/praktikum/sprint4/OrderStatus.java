package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.steps.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static edu.praktikum.sprint4.utils.Utils.randomString;
import static org.junit.Assert.assertTrue;

public class OrderStatus {

    private static final String NOT_EXISTING_ORDER = randomString();

    private WebDriver webDriver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void notFoundIfOrderNotExists() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage
                .open()
                .clickCheckOrder()
                .inputOrder(NOT_EXISTING_ORDER)
                .clickGo();

        assertTrue("Не показано сообщение об отсутствии заказа",
                mainPage.notFoundError().checkShown());
    }

    @Test
    public void notFoundIfOrderNotExists2() {
        MainPage mainPage = new MainPage(webDriver);
        Steps steps = new Steps(webDriver);

        steps
                .open(MainPage.URL)
                .click(mainPage.getCheckOrderButton())
                .inputText(mainPage.getOrderInputField(), NOT_EXISTING_ORDER)
                .click(mainPage.getGoButton());

        assertTrue("Не показано сообщение об отсутствии заказа",
                mainPage.notFoundError().checkShown());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}

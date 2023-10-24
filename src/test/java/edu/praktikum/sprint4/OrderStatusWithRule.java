package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.rules.BrowserRule;
import edu.praktikum.sprint4.steps.Steps;
import org.junit.Rule;
import org.junit.Test;

import static edu.praktikum.sprint4.utils.Utils.randomString;
import static org.junit.Assert.assertTrue;

public class OrderStatusWithRule {

    private static final String NOT_EXISTING_ORDER = randomString();

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void notFoundIfOrderNotExists() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

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
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        Steps steps = new Steps(browserRule.getWebDriver());

        steps
                .open(MainPage.URL)
                .click(mainPage.getCheckOrderButton())
                .inputText(mainPage.getOrderInputField(), NOT_EXISTING_ORDER)
                .click(mainPage.getGoButton());

        assertTrue("Не показано сообщение об отсутствии заказа",
                mainPage.notFoundError().checkShown());
    }
}

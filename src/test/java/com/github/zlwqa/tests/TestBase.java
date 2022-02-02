package com.github.zlwqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.zlwqa.drivers.BrowserstackMobileDriver;
import com.github.zlwqa.drivers.LocalMobileDriver;
import com.github.zlwqa.drivers.RealDeviceMobileDriver;
import com.github.zlwqa.drivers.SelenoidMobileDriver;
import com.github.zlwqa.helpers.Attach;
import com.github.zlwqa.helpers.RunHelper;
import com.github.zlwqa.page.GettingStartedPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.github.zlwqa.helpers.Attach.getSessionId;
import static com.github.zlwqa.helpers.RunHelper.runHelper;
import static io.qameta.allure.Allure.step;

public class TestBase {

    GettingStartedPage gettingStartedPage = new GettingStartedPage();

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

/*        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "selenoid":
                Configuration.browser = SelenoidMobileDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "real":
                Configuration.browser = RealDeviceMobileDriver.class.getName();
                break;
            default:
                throw new RuntimeException("Необходимо запустить со следующим параметром " +
                        "-DdeviceHost=browserstack/selenoid/local/real");
        }*/
        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        step("Открыть браузер", () -> {
            Selenide.open();
        });
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        if (runHelper().getDriverClass().getName().equals("selenoid") ||
                runHelper().getDriverClass().getName().equals("browserstack")) {
            String sessionId = getSessionId();
            Attach.attachVideo(sessionId);
        }

        step("Закрыть браузер", Selenide::closeWebDriver);
    }
}

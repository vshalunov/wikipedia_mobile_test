package com.github.zlwqa.tests;

import com.github.zlwqa.page.GettingStartedPage;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("real")
public class RealDeviceTests extends TestBase {

    GettingStartedPage gettingStartedPage = new GettingStartedPage();

    @Test
    @DisplayName("Отображение результатов поиска в приложении Wikipedia")
    void checkingTheFirstFourScreensOfGettingStarted() {

        // First Screen
        gettingStartedPage.titleDisplayOnFirstScreen()
                .clickForwardButton();
        // Second Screen
        gettingStartedPage.titleDisplayOnSecondScreen()
                .clickForwardButton();
        // Third Screen
        gettingStartedPage.titleDisplayOnThirdScreen()
                .clickForwardButton();
        // Fourth Screen
        gettingStartedPage.titleDisplayOnFourthScreen()
                .clickOnTheDoneButton();
        // Search Bar
        gettingStartedPage.displaySearchBar();
    }
}
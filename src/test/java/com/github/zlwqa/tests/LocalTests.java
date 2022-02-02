package com.github.zlwqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("local")
public class LocalTests extends TestBase {

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
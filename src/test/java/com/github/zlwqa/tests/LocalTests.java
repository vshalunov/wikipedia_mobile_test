package com.github.zlwqa.tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("local")
@Layer("UI")
@Owner("vshalunov")
@JiraIssues({@JiraIssue("HOMEWORK-330")})
@DisplayName("Тестирование мобильного-приложения Wikipedia")
public class LocalTests extends TestBase {

    @Test
    @DisplayName("Отображение результатов поиска в приложении Wikipedia")
    @Tags({@Tag("SearchResults"), @Tag("Highest")})
    @Microservice("Search Results")
    @Feature("Поиск")
    @Story("Отображение результатов поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Wikipedia", url = "https://en.wikipedia.org/")
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
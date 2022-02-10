package com.github.zlwqa.tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import io.appium.java_client.MobileBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("browserstack")
@Layer("UI")
@Owner("vshalunov")
@JiraIssues({@JiraIssue("HOMEWORK-330")})
@DisplayName("Тестирование мобильного приложения Wikipedia")
public class BrowserstackTests extends TestBase {

    @Test
    @AllureId("6971")
    @DisplayName("Отображение результатов поиска в приложении Wikipedia")
    @Tags({@Tag("SearchResults"), @Tag("Highest")})
    @Microservice("Search Results")
    @Feature("Поиск")
    @Story("Отображение результатов поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Wikipedia", url = "https://en.wikipedia.org/")
    void searchTest() {

        step("Открыть строку поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });

        step("Ввести поисковое значение", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Отображение результатов поиска", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @AllureId("6970")
    @DisplayName("Отображение конкретной страницы в приложении Wikipedia")
    @Tags({@Tag("DisplayPage"), @Tag("Highest")})
    @Microservice("DisplayPage")
    @Feature("Отображение страницы")
    @Story("Отображение конкретной страницы")
    @Owner("majorDoigrales")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Wikipedia", url = "https://en.wikipedia.org/")
    void searchPageNavalnyTest() {

        step("Открыть строку поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });

        step("Ввести поисковое значение Navalny", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Navalny");
        });

        step("Нажать на результат поиска с заголовком 'Alexei Navalny'", () -> {
            $$(byClassName("android.widget.TextView")).find(text("Alexei Navalny")).click();
        });

        step("Отображение страницы про Алексея Навального ", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).shouldHave(text("Alexei Navalny"));
        });
    }
}
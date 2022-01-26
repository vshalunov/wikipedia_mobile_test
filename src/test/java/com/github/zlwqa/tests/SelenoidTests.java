package com.github.zlwqa.tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("selenoid")
public class SelenoidTests extends TestBase {

    @Test
    @DisplayName("Отображение результатов поиска в приложении Wikipedia")
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
    @DisplayName("Отображение страницы про Алексея Навального в приложении Wikipedia")
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
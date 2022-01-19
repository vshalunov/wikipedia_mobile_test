package com.github.zlwqa.tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Поиск в приложении Wikipedia")
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
    @DisplayName("Поиск в приложении Wikipedia")
    void searchTest1() {

        step("Открыть строку поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });

        step("Ввести поисковое значение", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Navalny");
        });

        step("Отображение результатов поиска", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).shouldHave(text("Alexei Navalny"));
        });
    }
}
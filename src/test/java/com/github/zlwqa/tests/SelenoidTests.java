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

        step("первый экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("далее", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("второй экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });

        step("далее", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("третий экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("далее", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("четвертый экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });

        step("готово", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });

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

        step("первый экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("далее", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("второй экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });

        step("далее", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("третий экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("далее", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("четвертый экран", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });

        step("готово", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });

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
            $(byClassName("android.view.View")).shouldHave(text("Alexei Navalny"));
        });
    }
}
package com.github.zlwqa.page;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GettingStartedPage {

    // Locators & Elements
    private static final String
            FIRST_SCREEN_TEXT_TITLE = "The Free Encyclopedia …in over 300 languages",
            SECOND_SCREEN_TEXT_TITLE = "New ways to explore",
            THIRD_SCREEN_TEXT_TITLE = "Reading lists with sync",
            FOURTH_SCREEN_TEXT_TITLE = "Send anonymous data";
    private static final SelenideElement
            FIRST_SCREEN = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            FORWARD_BUTTON = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            SECOND_SCREEN = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            THIRD_SCREEN = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            FOURTH_SCREEN = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            DONE_BUTTON = $(MobileBy.id("org.wiki]pedia.alpha:id/fragment_onboarding_done_button")),
            SEARCH_BAR = $(MobileBy.AccessibilityId("Search Wikipedia"));

    // Actions
    @Step("Проверить отображение заголовка с текстом 'The Free Encyclopedia …in over 300 languages' на первом экране")
    public GettingStartedPage titleDisplayOnFirstScreen() {
        FIRST_SCREEN.shouldHave(text(FIRST_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Нажать на кнопку 'Далее'")
    public GettingStartedPage clickForwardButton() {
        FORWARD_BUTTON.click();

        return this;
    }

    @Step("Проверить отображение заголовка с текстом 'New ways to explore' на втором экране")
    public GettingStartedPage titleDisplayOnSecondScreen() {
        SECOND_SCREEN.shouldHave(text(SECOND_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Проверить отображение заголовка с текстом 'Reading lists with sync' на третьем экране")
    public GettingStartedPage titleDisplayOnThirdScreen() {
        THIRD_SCREEN.shouldHave(text(THIRD_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Проверить отображение заголовка с текстом 'Send anonymous data' на четвертом экране")
    public GettingStartedPage titleDisplayOnFourthScreen() {
        FOURTH_SCREEN.shouldHave(text(FOURTH_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Нажать на кнопку 'Готово'")
    public GettingStartedPage clickOnTheDoneButton() {
        DONE_BUTTON.click();

        return this;
    }

    @Step("Проверить отображение поисковой строки")
    public GettingStartedPage displaySearchBar() {
        SEARCH_BAR.shouldBe(visible);

        return this;
    }
}

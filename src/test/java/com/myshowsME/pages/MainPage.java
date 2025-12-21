package com.myshowsME.pages;

import com.myshowsME.config.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class MainPage extends BasePage {
    private static final String URL = ConfigReader.getUrl();
    private final Locator enterWindows = $("div.HeaderLogin__user div.HeaderLogin__username");

    public MainPage(Page page) {
        super(page);
    }

    @Step("Открытие главной страницы")
    public MainPage open(){
        open(URL);
        page.waitForTimeout(1000);
        return this;
    }

    @Step("Открытие модального окна логина")
    public BasePage openLoginModal(){
        waitForClickable(enterWindows);// Открытие формы логина
        enterWindows.click();
        return this;
    }



}

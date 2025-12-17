package com.dellin.core;

import com.dellin.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {
    protected BrowserManager browserManager;
    protected MainPage mainPage;

    @BeforeEach
    public void setup() {
        browserManager = new BrowserManager();         // создаём новый браузер
        mainPage = new MainPage(browserManager.getPage()); // передаём Page в MainPage
    }

    @AfterEach
    public void teardown() {
        browserManager.close(); // закрываем браузер после теста
    }



}

package com.myshowsME.core;

import com.myshowsME.pages.LoginPage;
import com.myshowsME.pages.MainPage;
import com.myshowsME.pages.ProfilePage;
import com.myshowsME.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {
    protected BrowserManager browserManager;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected ProfilePage profilePage;

    @BeforeEach
    public void setup() {
        browserManager = new BrowserManager();         // создаём новый браузер
        mainPage = new MainPage(browserManager.getPage()); // передаём Page в MainPage
        loginPage = new LoginPage(browserManager.getPage());
        registerPage =  new RegisterPage(browserManager.getPage());
        profilePage = new ProfilePage(browserManager.getPage());
    }

    @AfterEach
    public void teardown() {
        browserManager.close(); // закрываем браузер после теста
    }



}

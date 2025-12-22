package com.myshowsME.tests.MainPage;

import com.myshowsME.core.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Web UI")
@Feature("Авторизация")
public class LoginTests extends BaseTest {
    @Test
    @Story("Вход в аккаунт с помощью логина")
    public void enterAccountWithLogin(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
    }

    @Test
    @Story("Вход в аккаунт с помощью мейла")
    public void enterAccountWithEmail(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithEmail();
    }

    @Test
    @Story("Попытка входа в аккаунт с помощью пустого логина")
    public void  enterAccountWithEmptyLogin(){
        mainPage.open().openLoginModal();
        loginPage.enterWithEmptyLoginInput();
    }

    @Test
    @Story("Попытка входа в аккаунт с помощью пустого пароля")
    public void  enterAccountWithEmptyPassword(){
        mainPage.open().openLoginModal();
        loginPage.enterWithEmptyPasswordInput();
    }

    @Test
    @Story("Попытка входа в аккаунт с помощью некорректного логина")
    public void enterWithIncorrectLogin(){
        mainPage.open().openLoginModal();
        loginPage.enterWithIncorrectLogin();
    }

    @Test
    @Story("Попытка входа в аккаунт с помощью некорректного мейла")
    public void enterWithIncorrectEmail(){
        mainPage.open().openLoginModal();
        loginPage.enterWithIncorrectEmail();
    }

    @Test
    @Story("Попытка входа в аккаунт с помощью некорректного пароля")
    public void enterWithIncorrectPassword(){
        mainPage.open().openLoginModal();
        loginPage.enterWithIncorrectPassword();
    }
}

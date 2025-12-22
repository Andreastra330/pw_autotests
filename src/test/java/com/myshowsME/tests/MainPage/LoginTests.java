package com.myshowsME.tests.MainPage;

import com.myshowsME.core.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Web UI")
@Feature("Авторизация")
public class LoginTests extends BaseTest {
    @Test
    @DisplayName("Вход в аккаунт с помощью логина")
    @AllureId("78")
    public void enterAccountWithLogin(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
    }

    @Test
    @DisplayName("Вход в аккаунт с помощью мейла")
    @AllureId("80")
    public void enterAccountWithEmail(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithEmail();
    }

    @Test
    @DisplayName("Попытка входа в аккаунт с помощью пустого логина")
    @AllureId("70")
    public void  enterAccountWithEmptyLogin(){
        mainPage.open().openLoginModal();
        loginPage.enterWithEmptyLoginInput();
    }

    @Test
    @DisplayName("Попытка входа в аккаунт с помощью пустого пароля")
    @AllureId("68")
    public void  enterAccountWithEmptyPassword(){
        mainPage.open().openLoginModal();
        loginPage.enterWithEmptyPasswordInput();
    }

    @Test
    @DisplayName("Попытка входа в аккаунт с помощью некорректного логина")
    @AllureId("79")
    public void enterWithIncorrectLogin(){
        mainPage.open().openLoginModal();
        loginPage.enterWithIncorrectLogin();
    }

    @Test
    @DisplayName("Попытка входа в аккаунт с помощью некорректного мейла")
    @AllureId("85")
    public void enterWithIncorrectEmail(){
        mainPage.open().openLoginModal();
        loginPage.enterWithIncorrectEmail();
    }

    @Test
    @DisplayName("Попытка входа в аккаунт с помощью некорректного пароля")
    @AllureId("81")
    public void enterWithIncorrectPassword(){
        mainPage.open().openLoginModal();
        loginPage.enterWithIncorrectPassword();
    }
}

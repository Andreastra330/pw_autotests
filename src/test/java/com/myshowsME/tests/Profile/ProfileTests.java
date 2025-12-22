package com.myshowsME.tests.Profile;

import com.myshowsME.core.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

@Epic("Web UI")

@Feature("Действия в профиле")
public class ProfileTests extends BaseTest {

    @Test
    @DisplayName("Открытие страницы профиля")
    @AllureId("65")
    public void openProfilePage(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage();
    }

    @Test
    @DisplayName("Проверка наличия сериалов в блоке сериалы")
    @AllureId("82")
    public void itemsExistInSerialBlocks(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage()
                .serialWillExist()
                .serialWatchExist()
                .serialStopedExist()
                .serialLookedExist();
    }

    @Test
    @DisplayName("Проверка наличия фильмов в блоке фильмы")
    @AllureId("69")
    public void itemsExistInFilmBlocks(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage()
                .filmWillExist()
                .filmLookedExist();
    }

    @Test
    @DisplayName("Проверка наличия друзей в блоке друзья")
    @AllureId("83")
    public void userFriendExist(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage().userFriendExist();
    }


}

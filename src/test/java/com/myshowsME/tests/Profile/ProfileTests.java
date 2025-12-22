package com.myshowsME.tests.Profile;

import com.myshowsME.core.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Web UI")
@Feature("Действия в профиле")
public class ProfileTests extends BaseTest {

    @Story("Открытие страницы профиля")
    @Test
    public void openProfilePage(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage();
    }

    @Story("Проверка наличия сериалов в блоке сериалы")
    @Test
    public void itemsExistInSerialBlocks(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage()
                .serialWillExist()
                .serialWatchExist()
                .serialStopedExist()
                .serialLookedExist();
    }


    @Story("Проверка наличия фильмов в блоке фильмы")
    @Test
    public void itemsExistInFilmBlocks(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage()
                .filmWillExist()
                .filmLookedExist();
    }


    @Story("Проверка наличия друзей в блоке друзья")
    @Test
    public void userFriendExist(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage().userFriendExist();
    }


}

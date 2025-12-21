package com.myshowsME.tests.Profile;

import com.myshowsME.core.BaseTest;
import org.junit.jupiter.api.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void openProfilePage(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage();
    }

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


    @Test
    public void itemsExistInFilmBlocks(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage()
                .filmWillExist()
                .filmLookedExist();
    }

    @Test
    public void userFriendExist(){
        mainPage.open().openLoginModal();
        loginPage.enterAccountWithLogin();
        profilePage.openProfilePage().userFriendExist();
    }


}

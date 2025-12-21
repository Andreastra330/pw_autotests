package com.myshowsME.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProfilePage extends BasePage{
    private final Locator profileBtn = $("a.Sidebar__item div.Sidebar__item-text",
            new Page.LocatorOptions().setHasText("Профиль"));
    private final Locator profilePage = $("div.Page.UserPage");
    private final Locator serialWatch = $("div.UserShowsBlock div.TabsItem-title",
            new Page.LocatorOptions().setHasText("Смотрю"));
    private final Locator serialWatchName = $("div.UserShowsBlockList[title='Смотрю'] a.UserShowItem-title",
            new Page.LocatorOptions().setHasText("Из многих"));
    private final Locator serialWill = $("div.UserShowsBlock div.TabsItem-title",
            new Page.LocatorOptions().setHasText("Буду"));
    private final Locator serialWillName = $("div.UserShowsBlockList[title='Буду'] a.UserShowItem-title",
            new Page.LocatorOptions().setHasText("Рик и Морти"));
    private final Locator serialStopped = $("div.UserShowsBlock div.TabsItem-title",
            new Page.LocatorOptions().setHasText("Перестал"));
    private final Locator serialStoppedName = $("div.UserShowsBlockList[title='Перестал'] a.UserShowItem-title",
            new Page.LocatorOptions().setHasText("Молокососы"));
    private final Locator serialLooked = $("div.UserShowsBlock div.TabsItem-title",
            new Page.LocatorOptions().setHasText("Посмотрел"));
    private final Locator serialLookedName = $("div.UserShowsBlockList[title='Посмотрел'] a.UserShowItem-title",
            new Page.LocatorOptions().setHasText("Игра в кальмара"));
    private final Locator filmLooked = $("div.UserMoviesBlock div.TabsItem-title",
            new Page.LocatorOptions().setHasText("Посмотрел"));
    private final Locator filmLookedName = $("div.UserMoviesBlock__movies img[alt='Достать ножи']");
    private final Locator filmWill = $("div.UserMoviesBlock div.TabsItem-title",
            new Page.LocatorOptions().setHasText("Буду"));
    private final Locator filmWillName = $("div.UserMoviesBlock__movies img[alt='Чебурашка 2']");
    private final Locator userFriend = $("div.UserFriendsBlock__list div.UserFriendsBlock__name",
            new Page.LocatorOptions().setHasText("nuhan"));

    public ProfilePage(Page page) {super(page);}

    public ProfilePage openProfilePage(){
        profileBtn.click();
        profilePage.waitFor();
        return this;
    }

    public ProfilePage serialWatchExist(){
        serialWatch.click();
        serialWatchName.waitFor();
        return this;
    }

    public ProfilePage serialWillExist(){
        serialWill.click();
        serialWillName.waitFor();
        return this;
    }

    public ProfilePage serialStopedExist(){
        serialStopped.click();
        serialStoppedName.waitFor();
        return this;
    }

    public ProfilePage serialLookedExist(){
        serialLooked.click();
        serialLookedName.waitFor();
        return this;
    }

    public ProfilePage filmLookedExist(){
        filmLooked.click();
        filmLookedName.waitFor();
        return this;
    }

    public ProfilePage filmWillExist(){
        filmWill.click();
        filmWillName.waitFor();
        return this;
    }

    public ProfilePage userFriendExist(){
        userFriend.waitFor();
        return this;
    }

}

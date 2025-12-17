package com.dellin.pages;

import com.dellin.config.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class MainPage extends BasePage {
    private static final String URL = ConfigReader.getUrl();
    private final Locator orderSearchButton = $("button[arial-label='Искать по номеру заказа']");
    private final Locator catalogButton = $("button[data-testid='header-catalog-button']");
    private Locator catalogButton()      { return $("button[data-testid='header-catalog-button']"); }
//    private final Locator subMenu = $("div[data-testid='genres_popup']");

    public MainPage(Page page) {
        super(page);
    }

    public MainPage open(){
        open(URL);
        return this;
    }

    //OrderManager основные действия
    public MainPage openCatalogDropdown(){
        //$("button[data-testid='header-catalog-button']").click();
        catalogButton.click();
        $("div[data-testid='genres_popup']").waitFor();
        return this;
    }

    public MainPage orderSearchRedirect(){
        orderSearchButton.click();
        return this;
    }


    //HeaderMenu проверки

    public MainPage catalogSubMenuShouldBeVision(){
        Assertions.assertTrue($("div[data-testid='genres_popup']").isVisible());
        return this;
    }

    public MainPage orderPageIsVisible(){
        var title = page.title();
        Assertions.assertEquals("Статус доставки груза. Отследить груз по номеру отправления - Деловые Линии", title);
        return this;
    }
}

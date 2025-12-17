package com.dellin.tests.MainPage.Header;

import com.dellin.core.BaseTest;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseTest {

    @Test
    public void catalogSubMenuShouldBeVision_AfterClick(){
        mainPage.open().openCatalogDropdown();
        mainPage.catalogSubMenuShouldBeVision();
    }

    @Test
    public void orderSearchShouldBeRedirect(){
        mainPage.open().orderSearchRedirect().orderPageIsVisible();
    }
}

package com.dellin.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

public class BasePage {

    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void open(String url){
        page.navigate(url,new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    protected Locator $(String selector){
        return page.locator(selector);
    }
}

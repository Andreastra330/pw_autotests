package com.myshowsME.core;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class BrowserManager {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;


    // Конструктор запускает браузер и создаёт Page
    // c Видимым окном
    public BrowserManager() {
        ArrayList<String> args = new ArrayList<>(List.of("--start-maximized"));
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        //.setSlowMo(2000)
                        .setArgs(args)

        );
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null)
        );
        page = context.newPage();
    }


    public Page getPage() {
        return page;
    }

    public void close() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}

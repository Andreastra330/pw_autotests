package com.myshowsME.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.myshowsME.config.ConfigReader;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends BasePage{
    private static final String LOGIN = ConfigReader.getRealLogin();
    private static final String EMAIL = ConfigReader.getRealEmail();
    private static final String PASSWORD = ConfigReader.getRealPassword();
    private final Locator loginInput = $("input.Input__field[name='login']");
    private final Locator passwordInput = $("input.Input__field[name='password']");
    private final Locator enterButton = $("button[type='submit']",new Page.LocatorOptions().setHasText("Войти"));
    private final Locator errorLoginInput = $("input.Input__field.error[name='login']");
    private final Locator errorPasswordInput = $("input.Input__field.error[name='password']");
    private final Locator errorIncorrectLogPass = $("section[aria-label='Notifications alt+T'] div[data-title='']", new Page.LocatorOptions().setHasText("Неправильный логин или пароль"));

    public LoginPage(Page page){
        super(page);
    }

    @Step("Попытка входа с корректными данными через Login")
    public LoginPage enterAccountWithLogin(){ // Войти по логину+пароль, с проверкой успешности
        fillLoginInfo(LOGIN,PASSWORD);
        enterButton.click();
        enterSuccess();
        return this;
    }
    @Step("Попытка входа с корректными данными через Email")
    public LoginPage enterAccountWithEmail(){// Войти по почта + пароль с проверкой успешности
        fillLoginInfo(EMAIL,PASSWORD);
        enterButton.click();
        enterSuccess();
        return this;
    }

    @Step("Попытка входа с пустым логином")
    public LoginPage enterWithEmptyLoginInput(){ // Попытка войти с пустым полем Логин-Емейл, проверкой что есть красная обводка у поля
        fillLoginInfo("",PASSWORD);
        enterButton.click();
        Assertions.assertTrue(errorLoginInput.count()>0);
        return this;
    }
    @Step("Попытка входа с пустым паролем")
    public LoginPage enterWithEmptyPasswordInput(){ // Попытка войти с пустым полем Пароль, с проверкой что есть красная обводка у поля
        fillLoginInfo(LOGIN,"");
        enterButton.click();
        Assertions.assertTrue(errorPasswordInput.count()>0);
        return this;
    }

    @Step("Попытка входа с некорректным логином")
    public LoginPage enterWithIncorrectLogin(){
        fillLoginInfo("kijasbas",PASSWORD);
        enterButton.click();
        errorIncorrectLogPass.waitFor();
        Assertions.assertTrue(errorIncorrectLogPass.count()>0);
        return this;
    }
    @Step("Попытка входа с некорректным мейлом")
    public LoginPage enterWithIncorrectEmail(){
        fillLoginInfo("kijasbas@qieosk.ru",PASSWORD);
        enterButton.click();
        errorIncorrectLogPass.waitFor();
        Assertions.assertTrue(errorIncorrectLogPass.count()>0);
        return this;
    }

    @Step("Попытка входа с некорректным паролем")
    public LoginPage enterWithIncorrectPassword(){
        fillLoginInfo(LOGIN,"trybest");
        enterButton.click();
        errorIncorrectLogPass.waitFor();
        Assertions.assertTrue(errorIncorrectLogPass.count()>0);
        return this;
    }

    @Step("Заполнение данных модального окна логина")
    private void  fillLoginInfo(String login, String password){
        loginInput.isVisible();
        loginInput.fill(login);
        passwordInput.fill(password);
    }

    @Step("Проверка успешности входа")
    private void enterSuccess(){
        page.waitForTimeout(3000);
        Assertions.assertEquals(LOGIN,$("div.HeaderLogin__user div.HeaderLogin__username").innerText());
    }
}

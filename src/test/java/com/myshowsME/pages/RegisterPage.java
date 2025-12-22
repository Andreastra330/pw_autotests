package com.myshowsME.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;


public class RegisterPage extends BasePage{
    private final Locator registerForm = $("//div[@class='AuthLayout__form']");
    private final Locator registerBtn =  $("a.ModalLoginForm__signup");
    private final Locator usernameInput = $("div.RegistrationPage__input input.Input__field[name='login']");
    private final Locator inputEmail = $("div.RegistrationPage__input input.Input__field[name='email']");
    private final Locator inputPassword1= $("div.RegistrationPage__input input.Input__field[name='password']");
    private final Locator inputPassword2= $("div.RegistrationPage__input input.Input__field[name='password2']");
    private final Locator checkboxConfirm = $("div.Checkbox__input");
    private final Locator makeRegisterBtn = $("button.RegistrationPage__button[type='submit']");
    private final Locator errorUsernameInput = $("input.Input__field.error[name='login']");
    private final Locator errorEmailInput = $("div.RegistrationPage__input input.Input__field.error[name='email']");
    private final Locator errorPasswordInput = $("div.RegistrationPage__input input.Input__field.error[name='password']");
    private final Locator errorPassword2Input = $("div.RegistrationPage__input input.Input__field.error[name='password2']");
    private final Locator errorCheckbox = $("label.Checkbox--error div.Checkbox__input");
    private final Locator incorrectNameFormatError = $("div.Input__error",
            new Page.LocatorOptions().setHasText("Неправильный формат имени пользователя"));
    private final Locator alreadyRegisterNameError = $("div.Input__error",
            new Page.LocatorOptions().setHasText("Имя пользователя уже занято"));
    private final Locator userName = $("div.HeaderLogin__user div.HeaderLogin__username",
            new Page.LocatorOptions().setHasText("kiv"));


    public RegisterPage(Page page){super(page);}

    @Step("Открытие формы регистрации")
    public RegisterPage openRegisterForm(){
        registerBtn.click();
        registerForm.waitFor();
        return this;
    }
    @Step("Нажатие кнопки чекбокса")
    public RegisterPage checkbox(){
        checkboxConfirm.click();
        return this;
    }
    @Step("Нажатие кнопки Зарегистрироваться")
    public RegisterPage register(){
        makeRegisterBtn.click();
        return this;
    }

    @Step("Заполнение формы регистрации")
    public RegisterPage fillRegisterForm(String login, String email, String password1, String password2)
    {
        usernameInput.fill(login);
        inputEmail.fill(email);
        inputPassword1.fill(password1);
        inputPassword2.fill(password2);
        return this;
    }

    @Step("Проверка что регистрация успешна")
    public RegisterPage registerSuccess(){
        page.waitForTimeout(10000);
        Assertions.assertEquals("https://myshows.me/hi/",page.url());
        return this;
    }

    @Step("Проверка что поле логин окрасилось красным при ошибке")
    public RegisterPage loginFieldError(){
        errorUsernameInput.waitFor();
        Assertions.assertTrue(errorUsernameInput.isVisible());
        return this;
    }
    @Step("Проверка что поле email окрасилось красным при ошибке")
    public RegisterPage emailFieldError(){
        errorEmailInput.waitFor();
        Assertions.assertTrue(errorEmailInput.isVisible());
        return this;
    }

    @Step("Проверка что поле пароль1 окрасилось красным при ошибке")
    public RegisterPage passwordFieldError(){
        errorPasswordInput.waitFor();
        Assertions.assertTrue(errorPasswordInput.isVisible());
        return this;
    }
    @Step("Проверка что поле пароль2 окрасилось красным при ошибке")
    public RegisterPage password2FieldError(){
        errorPassword2Input.waitFor();
        Assertions.assertTrue(errorPassword2Input.isVisible());
        return this;
    }
    @Step("Проверка что поле чекбокс окрасилось красным при ошибке")
    public RegisterPage checkboxFieldError(){
        errorCheckbox.waitFor();
        Assertions.assertTrue(errorCheckbox.isVisible());
        return this;
    }
    @Step("Проверка налачие алерта при некорректном логине")
    public RegisterPage loginIncorrectAlert(){
        incorrectNameFormatError.waitFor();
        Assertions.assertTrue(incorrectNameFormatError.isVisible());
        return this;
    }
    @Step("Проверка налачие алерта при ужа зарегистрированном логине")
    public RegisterPage loginAlreadyRegisterAlert(){
        Assertions.assertTrue(alreadyRegisterNameError.isVisible());
        return this;
    }


}


package com.myshowsME.tests.MainPage;

import com.myshowsME.Utils.CommonUtils;
import com.myshowsME.core.BaseTest;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Web UI")
@Feature("Регистрация")
public class RegisterTests extends BaseTest {
    @Test
    @DisplayName("Регистрация с корректными данными")
    @AllureId("67")
    public void registerWithCorrectData(){
        var login = CommonUtils.randomString(12).toLowerCase();
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm(login,CommonUtils.randomEmail(5,3).toLowerCase(),pass,pass)
                .checkbox()
                .register()
                .registerSuccess();
    }

    @Test
    @DisplayName("Регистрация с пустым логином")
    @AllureId("74")
    public void registerWithEmptyLogin(){
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm("",CommonUtils.randomEmail(5,3).toLowerCase(),pass,pass)
                .checkbox()
                .register()
                .loginFieldError();
    }

    @Test
    @DisplayName("Регистрация с меньше 3 символов")
    @AllureId("76")
    public void registerWithLoginLessThreeSymbl(){
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm("12",CommonUtils.randomEmail(5,3).toLowerCase(),pass,pass)
                .checkbox()
                .register()
                .loginFieldError()
                .loginIncorrectAlert();
    }

    @Test
    @DisplayName("Регистрация с логином где есть запрещенные символы")
    @AllureId("75")
    public void registerWithLoginBadSymbl(){
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm("kivaz!",CommonUtils.randomEmail(5,3).toLowerCase(),pass,pass)
                .checkbox()
                .register()
                .loginFieldError()
                .loginIncorrectAlert();
    }

    @Test
    @DisplayName("Регистрация с логином который уже зарегистрирован")
    @AllureId("77")
    public void registerWithAlreadyCreatedLogin(){
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm("kev",CommonUtils.randomEmail(5,3).toLowerCase(),pass,pass)
                .checkbox()
                .register()
                .loginFieldError()
                .loginAlreadyRegisterAlert();
    }

    @Test
    @DisplayName("Регистрация с Китайским алфавитом")
    @AllureId("66")
    public void registerWithChinaSymbLogin(){
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm("你好",CommonUtils.randomEmail(5,3).toLowerCase(),pass,pass)
                .checkbox()
                .register()
                .loginFieldError()
                .loginIncorrectAlert();
    }

    @Test
    @DisplayName("Регистрация с пустым мейлом")
    @AllureId("72")
    public void registerWithEmptyEmail(){
        var login = CommonUtils.randomString(5).toLowerCase();
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm(login,"",pass,pass)
                .checkbox()
                .register()
                .emailFieldError();
    }

    @Test
    @DisplayName("Регистрация с пустым паролем1")
    @AllureId("84")
    public void registerWithEmptyPassword(){
        var login = CommonUtils.randomString(5).toLowerCase();
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm(login,CommonUtils.randomEmail(5,5),"",pass)
                .checkbox()
                .register()
                .passwordFieldError();
    }

    @Test
    @DisplayName("Регистрация с пустым паролем2")
    @AllureId("71")
    public void registerWithEmptyPassword2(){
        var login = CommonUtils.randomString(5).toLowerCase();
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm(login,CommonUtils.randomEmail(5,5),pass,"")
                .checkbox()
                .register()
                .password2FieldError();
    }

    @Test
    @DisplayName("Регистрация с пустым чекбоксом")
    @AllureId("73")
    public void registerWithEmptyCheckbox(){
        var login = CommonUtils.randomString(5).toLowerCase();
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm(login,CommonUtils.randomEmail(5,5),pass,pass)
                .register()
                .checkboxFieldError();
    }


}

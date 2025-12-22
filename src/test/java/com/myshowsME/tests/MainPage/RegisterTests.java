package com.myshowsME.tests.MainPage;

import com.myshowsME.Utils.CommonUtils;
import com.myshowsME.core.BaseTest;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Web UI")
@Feature("Регистрация")
public class RegisterTests extends BaseTest {
    @Story("Регистрация с корректными данными")
    @Test
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
    @Story("Регистрация с пустым логином")
    @Test
    public void registerWithEmptyLogin(){
        var pass = CommonUtils.randomString(6);
        mainPage.open().openLoginModal();
        registerPage.openRegisterForm()
                .fillRegisterForm("",CommonUtils.randomEmail(5,3).toLowerCase(),pass,pass)
                .checkbox()
                .register()
                .loginFieldError();
    }
    @Story("Регистрация с меньше 3 символов")
    @Test
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

    @Story("Регистрация с логином где есть запрещенные символы")
    @Test
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

    @Story("Регистрация с логином который уже зарегистрирован")
    @Test
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

    @Story("Регистрация с Китайским алфавитом")
    @Test
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

    @Story("Регистрация с пустым мейлом")
    @Test
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

    @Story("Регистрация с пустым паролем1")
    @Test
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

    @Story("Регистрация с пустым паролем2")
    @Test
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

    @Story("Регистрация с пустым чекбоксом")
    @Test
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

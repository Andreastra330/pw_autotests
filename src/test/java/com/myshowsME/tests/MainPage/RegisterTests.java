package com.myshowsME.tests.MainPage;

import com.myshowsME.Utils.CommonUtils;
import com.myshowsME.core.BaseTest;
import org.junit.jupiter.api.Test;

public class RegisterTests extends BaseTest {

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

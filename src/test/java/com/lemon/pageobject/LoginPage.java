package com.lemon.pageobject;

import com.lemon.base.BasePage;
import com.lemon.base.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    //登录页面手机号码输入框
    By phoneBy = MobileBy.xpath("//*[@resource-id='com.lemon.lemonban:id/et_mobile']");
    //登录页面密码输入框
    By pwdBy = MobileBy.xpath("//*[@resource-id='com.lemon.lemonban:id/et_password']");
    //登录按钮
    By loginButtonBy = MobileBy.xpath("//*[@text='登录']");

    public void login(String phone,String pwd){
        sendKeys(phoneBy,phone,"登录页面-输入手机号：");
        sendKeys(pwdBy,pwd,"登录页面-输入密码：");
        click(loginButtonBy,"登录页面-登录按钮");
    }
}

package com.lemon.testcases;

import com.lemon.base.BaseTest;
import com.lemon.pageobject.LoginPage;
import com.lemon.pageobject.MainPage;
import com.lemon.pageobject.MyLemonPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        openApp();
        MainPage mainPage = new MainPage();
        MyLemonPage myLemonPage = new MyLemonPage();
        //点击我的柠檬
        mainPage.myLemonEntrance();
        //点击头像登录
        myLemonPage.loginEntrance();
    }

    @Test
    public void loginSuccess(){
        LoginPage loginPage = new LoginPage();
        MyLemonPage myLemonPage = new MyLemonPage();

        //登录成功
        loginPage.login("18770636562","636562");
        //断言头像名字是否一致
        String expectedName = "for";
        Assert.assertEquals(myLemonPage.getUsernameText(),expectedName);

        //断言页面是否一致
        String expectedActivity = ".activity.MainActivity";
        Assert.assertEquals(driver.currentActivity(),expectedActivity);

    }

    @Test(dataProvider="loginFailureData")
    public void loginFailure(String phoneNum, String pwd, String toastTips){
        LoginPage loginPage = new LoginPage();
        loginPage.login(phoneNum,pwd);
        //断言失败结果
        Assert.assertEquals(loginPage.getToastText(toastTips),toastTips);
    }

    @DataProvider
    public Object[][] loginFailureData(){
        Object [][] datas ={
                {"18770636562","123456","错误的账号信息"},
                {"187706","123456","手机号码格式不正确"},
                {"18770636562","","手机号码或密码不能为空"},
                {"","123456","手机号码或密码不能为空"}
        };
        return datas;
    }

    @AfterClass
    public void tearDown(){
       driver.quit();
    }
}

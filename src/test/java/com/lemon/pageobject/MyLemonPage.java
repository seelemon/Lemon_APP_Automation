package com.lemon.pageobject;

import com.lemon.base.BasePage;
import com.lemon.base.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MyLemonPage extends BasePage {
    //登录
    By myLemonBy = MobileBy.AndroidUIAutomator("new UiSelector().text(\"点击头像登录\")");
    //头像
    By usernameBy = MobileBy.xpath("//*[@resource-id='com.lemon.lemonban:id/fragment_my_lemon_avatar_title']");


    public void loginEntrance(){
        click(myLemonBy,"我的柠檬页面-点击头像登录");
    }

    public String getUsernameText(){
        return getText(usernameBy);
    }
}

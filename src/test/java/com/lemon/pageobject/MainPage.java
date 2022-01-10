package com.lemon.pageobject;

import com.lemon.base.BasePage;
import com.lemon.base.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    //我的柠檬
    By myLemonBy = MobileBy.AndroidUIAutomator("new UiSelector().text(\"我的柠檬\")");

    public void myLemonEntrance(){
        click(myLemonBy,"我的柠檬页面-我的柠檬");
    }

}

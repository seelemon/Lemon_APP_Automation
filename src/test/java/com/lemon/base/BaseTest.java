package com.lemon.base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
   public static AndroidDriver driver;
   private static Logger logger = Logger.getLogger(BaseTest.class);

    public void openApp(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","emulator-5554");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.lemon.lemonban");
        desiredCapabilities.setCapability("appActivity","com.lemon.lemonban.activity.WelcomeActivity");
        desiredCapabilities.setCapability("noReset",false);
        desiredCapabilities.setCapability("automationName","uiautomator2");
        try {
            driver = new AndroidDriver(new URL
                    ("http://192.168.31.15:4723/wd/hub"),desiredCapabilities);
        } catch (MalformedURLException e) {
            logger.error("连接appium失败，失败原因：" + e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        logger.info("sghjk");
    }
}

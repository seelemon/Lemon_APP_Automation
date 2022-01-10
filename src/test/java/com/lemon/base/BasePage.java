package com.lemon.base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private Logger logger = Logger.getLogger(BasePage.class);

    /**
     * 元素是否可见
     * @param by 元素定位
     * @return webElement对象
     */
    public WebElement waitElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(BaseTest.driver,10);
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            logger.error("元素不可见，错误原因：" + e);
        }
        return element;
    }

    /**
     * 元素是否存在
     * @param by 元素定位
     * @return webElement对象
     */
    public WebElement waitElementPresence(By by){
        WebDriverWait wait = new WebDriverWait(BaseTest.driver,10);
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            logger.error("元素不存在，错误原因：" + e);
        }
        return element ;
    }

    /**
     * 元素是否可点击
     * @param by 元素定位
     * @return webElement对象
     */
    public WebElement waitElementClickable(By by){
        WebDriverWait wait = new WebDriverWait(BaseTest.driver,10);
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            logger.error("元素不可点击，错误原因：" + e);
        }
        return element ;
    }

    /**
     * 点击元素
     * @param by
     */
    public void click(By by,String desc){
        logger.info("点击元素：" + desc);
        waitElementVisible(by).click();
    }

    public void sendKeys(By by,String text,String desc){
//        waitElementVisible(by).clear();
        logger.info(desc + text);
        waitElementVisible(by).sendKeys(text);
    }
    /**
     * 获取元素文本值
     * @param by
     * @return 返回元素文本
     */
    public String getText(By by){
        return waitElementVisible(by).getText();
    }

    /**
     * 安卓机向下滑动刷新
     * @param ms 传入毫秒时间
     */
    public  void swipeDownToRefresh(long ms){
        //获取屏幕宽度
        int width = BaseTest.driver.manage().window().getSize().width;
        //获取屏幕高度
        int height = BaseTest.driver.manage().window().getSize().height;
        //创建Duration对象
        Duration duration = Duration.ofMillis(ms);
        //创建WaitOption对象
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        //实例化TouchAction对象
        TouchAction touchAction = new TouchAction(BaseTest.driver);
        //创建2个坐标，传化成PointOption类型,起始点和终点
        PointOption startPoint = PointOption.point(width/2,height/4);
        PointOption endPoint = PointOption.point(width/2,height*3/4);
        //滑动操作
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    /**
     * 获取登录toast文本公共方法
     * @param toastText
     * @return 返回toast文本值
     */
    public String getToastText(String toastText){

        return waitElementPresence(MobileBy.xpath("//*[contains(@text,'"+ toastText +"')]")).getText();
    }

    public boolean isElementDisplay(By by){
        boolean isElementDisplay = false;
        try {
           isElementDisplay = waitElementVisible(by).isDisplayed();
        }catch (Exception e){
            logger.error(by + "元素不可见");
        }
        return isElementDisplay;
    }


}

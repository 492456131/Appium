package com.android.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class Uihelper {
    private AppiumDriver appiumDriver;

    public Uihelper(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public AppiumDriver getAppiumDriver(){
        return appiumDriver;
    }

    public WebElement findElementById(String id){
        return appiumDriver.findElementById(id);
    }

    public WebElement findElementByName(String text){
        return  appiumDriver.findElementByName(text);
    }

    public WebElement findElementByClassName(String className){
        return appiumDriver.findElementByClassName(className);
    }

    /*
    判断元素是否找到
     */
    public boolean getElementStatusById(String id){
        try {
            findElementById(id);
        }catch (ElementNotFoundException e){
            System.out.println("======元素未找到=====");
            return false;
        }
        return true;
    }

    /*
    判断页面是否存在某个文本
     */
    public boolean pageShouldBeText(String text){
        String responce = appiumDriver.getPageSource();
        if(responce.contains(text)){
            return true;
        }else {
            return false;
        }
    }

}

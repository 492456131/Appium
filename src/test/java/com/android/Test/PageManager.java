package com.android.Test;

import com.android.Test.Page.PageLogin;
import io.appium.java_client.AppiumDriver;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class PageManager {
    private Uihelper uihelper;
    private AppiumDriver appiumDriver;
    private PageLogin pageLogin;
    private ScreenShot screenShot;

    public PageManager( Uihelper uihelper){
        this.uihelper = uihelper;
    }

    public Uihelper getUihelper(){
        if(uihelper == null){
            uihelper = new Uihelper(appiumDriver);
        }
        return uihelper;
    }

    public PageLogin getPageLogin(){
        if(pageLogin == null){
            pageLogin = new PageLogin(uihelper);
        }
        return pageLogin;
    }

    public ScreenShot getScreenShot(){
        if(screenShot == null){
            screenShot = new ScreenShot(uihelper.getAppiumDriver());
        }
        return screenShot;
    }
}

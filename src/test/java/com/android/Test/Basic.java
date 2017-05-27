package com.android.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ReporterType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogManager;

/**
 * Created by Aaron on 2016/2/28.
 */
public class Basic {
    public PageManager pageManager;
    private Uihelper uihelper;
    private AppiumDriver appiumDriver;
    private String deviceName = "192.168.200.101:5555";
    private String platformVersion = "4.4.4";
    private String apkName = "app-dev-debug.apk";
    private String appActivity = "com.jjshome.oa.activity.StartActivity";
    private String appPackage = "com.jjshome.oa";



    @BeforeMethod
    public void setUp() throws Exception {
        try {
            File apk = new File(System.getProperty("user.dir") + File.separator + "apk" + File.separator + apkName);
            //System.out.println(apk);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("appActivity", appActivity);
            appiumDriver = new AndroidDriver(new URL("http://172.16.7.8:4723/wd/hub"), capabilities);
            uihelper = new Uihelper(appiumDriver);
            pageManager = new PageManager(uihelper);
            TestNGListener.setDriver(appiumDriver);
        } catch (Exception E) {
           LogMessage.info("***************   Appium初始化失败，请检查相关设置   *****************");
        }
    }

    /*@Test
    public void test1() {
        Utils.waitForElementById(pageManager.getUihelper().getAppiumDriver(), "com.jjshome.oa:id/username");


    }*/

    @AfterMethod
    public void tearDown() throws Exception {
        appiumDriver.quit();
        //LogMessage.info("*************    退出appiumDriver   ************");
    }

   /* public String screen(AppiumDriver driver){
        String path=System.getProperty("user.dir")+ "//snapshot//"+ this.getClass().getSimpleName()+"_"+getCurrentTime() + ".png";
        LogMessage.info(path);
        return path;
    }

    public void getScreenShot() {
        ;
        File screen = appiumDriver.getScreenshotAs(OutputType.FILE);
        File screenFile = new File(screen(appiumDriver));
        try {
            FileUtils.copyFile(screen, screenFile);
            LogMessage.info("截图保存的路径:" + screen(appiumDriver));
        } catch (Exception e) {
            LogMessage.error("截图失败");
            e.printStackTrace();
        }
    }

    public String getCurrentTime(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String currentTime=sdf.format(date);
        return currentTime;
    }*/

}
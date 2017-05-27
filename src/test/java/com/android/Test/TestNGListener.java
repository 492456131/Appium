package com.android.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.appium.java_client.AppiumDriver;

import java.io.File;


/**
 * Created by Administrator on 2017/5/14.
 */
public class TestNGListener extends TestListenerAdapter {
    private static AppiumDriver driver;
    //private String path;

    public static void setDriver(AppiumDriver driver) {
        TestNGListener.driver = driver;
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        LogMessage.info("【" + tr.getName() + " Success】");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        LogMessage.info("【" + tr.getName() + " Failure】");
        super.onTestFailure(tr);
        //截图方法
        takeScreenShot(tr);
       /* path=System.getProperty("user.dir")+"\\snapshot\\"+this.getClass().getSimpleName()+"_"+Utils.getNowDate() + ".png";
        LogMessage.info(path);
        File screen = driver.getScreenshotAs(OutputType.FILE);
        File screenFile = new File(path);
        try {
            FileUtils.copyFile(screen, screenFile);
            LogMessage.info("截图保存的路径:" + path);
        } catch (Exception e) {
            LogMessage.error("截图失败");
            e.printStackTrace();
        }*/
        /*ScreenShot screenShot = new ScreenShot(driver);
        screenShot.getScreenShot();*/

    }

    public void takescreen(String filename){
        //调用ScreenShot的静态方法
        ScreenShot.getScreenShot(driver,filename);
    }

    public void takeScreenShot(ITestResult tr){
        takescreen(tr.getName());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        LogMessage.info("【" + tr.getName() + " Skipped】");
        super.onTestSkipped(tr);
    }

    @Override
    public void onStart(ITestContext testContext) {
        LogMessage.info("【" + testContext.getName() + " Start】");
        super.onStart(testContext);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        LogMessage.info("**************   Test Finish   ****************");
        super.onFinish(testContext);
    }
}

package com.android.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import org.testng.Reporter;

/**
 * Created by Administrator on 2017/5/14.
 */
public class ScreenShot {
    private AppiumDriver driver;
    // 测试失败截屏保存的路径
    private String path;

    public ScreenShot(AppiumDriver driver){
        this.driver = driver;
    }
    public static void getScreenShot(AppiumDriver driver, String filename) {
        String cyrPatn=System.getProperty("user.dir");
        File scrfile=driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrfile, new File(cyrPatn+"\\img\\"+filename+".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("GetScreenshot Fail");
        }finally{
            System.out.println("GetScreenshot Successful"+cyrPatn+"\\img\\"+filename+".png");
        }

    }
}


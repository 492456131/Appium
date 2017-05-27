package com.android.Test;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Administrator on 2016/6/6 0006.
 */
public class Utils {

    /*
    通过ID的方式，等待某个element出现
     */
    public static void waitForElementById(AppiumDriver appiumDriver,String id){
        WebDriverWait wait = new WebDriverWait(appiumDriver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    /*
    通过text的方式，等待某个element出现
     */
    public static void waitForElementByName(AppiumDriver appiumDriver,String text){
        WebDriverWait wait = new WebDriverWait(appiumDriver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text)));
    }

    /*
    通过ClassName的方式，等待某个element出现
     */
    public static void waitForElementByClassName(AppiumDriver appiumDriver,String className){
        WebDriverWait wait = new WebDriverWait(appiumDriver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }

    /*
    获取当前时间的年份
     */
    public static int getYear(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /*
    返回月份
     */
    public static int getMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }

    /*
    返回在月份中的第几天
     */
    public static int getDay(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /*
    返回分钟
     */
    public static int getMnuter(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /*
    返回秒
     */
    public static int getSecond(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    public static String getNowDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm-dd HH:MM:SS");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    /*public static void main(String arg[]){
        System.out.println(getNowDate());
    }*/
}

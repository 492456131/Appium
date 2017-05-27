package com.android.Test.Page;

import com.android.Test.Uihelper;
import org.apache.commons.io.FileUtils;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/11.
 */
public class PageBasic {
    private Uihelper uihelper;

    public PageBasic(Uihelper uihelper){
        this.uihelper = uihelper;
    }

    public void switchContextToWebView(){
        Set<String> contextNames =uihelper.getAppiumDriver().getContextHandles();
        for (String contextName : contextNames){
            System.out.println(contextName);
        }
        String lasterContextView=contextNames.toArray()[contextNames.size()-1].toString();
        if(lasterContextView.contains("WEBVIEW")){
            uihelper.getAppiumDriver().context("WEBVIEW");
        }
    }

    public void switchContextToNative(){
        uihelper.getAppiumDriver().context("NATIVE");
    }

    /*
    获取当前屏幕的高宽
     */
    public String[] getScreenSize(){
        WebElement element=uihelper.findElementByClassName("android.widget.LinearLayout");
        String size = (element.getSize().toString()).replace("(","");
        String screenSize = size.replace(")","");
        String screenSize1 = screenSize.replace(" ","");
        System.out.println(screenSize1.toString());
        String[] num = screenSize1.split(",");
        return num;
    }

    /*
    滑动屏幕方向
     */
    public void swipScreen(String swipDirection){
        String[] num = getScreenSize();
        int wide = Integer.parseInt(num[0]);
        int high = Integer.parseInt(num[1]);
        if(swipDirection.toUpperCase().contains("U")){
            uihelper.getAppiumDriver().swipe(wide/4,high/4,wide*3/4,high*3/4,3);
        }else if(swipDirection.toUpperCase().contains("D")){
            uihelper.getAppiumDriver().swipe(wide/4,high*3/4,wide/4,high/4,3);
        }else if(swipDirection.toUpperCase().contains("L")){
            uihelper.getAppiumDriver().swipe(wide*3/4,high/2,wide/4,high/2,3);
        }else if(swipDirection.toUpperCase().contains("R")){
            uihelper.getAppiumDriver().swipe(wide/4,high/2,wide*3/4,high/2,3);
        }
    }

    /*
    对比两张图片的信息
     */
    public void contrastImage(String fileInputPath) throws InterruptedException, IOException {
        File screenshot = uihelper.getAppiumDriver().getScreenshotAs(OutputType.FILE);//对当前页面进行截图
        Thread.sleep(30000);
        FileUtils.copyFile(screenshot,new File("d:\\APPHomePage_actual.jpg"));//复制图片到指定的位置并重命名
        File fileInput = new File(fileInputPath);//期望图片地址
        File fileOutPut = new File("d:\\APPHomePage_actual.jpg");//实际图片地址
        //对比图片的信息
        //获取期望图片的信息
        BufferedImage buffeFileInput = ImageIO.read(fileInput);
        DataBuffer daFileInput=buffeFileInput.getData().getDataBuffer();
        int sizeFileInput=daFileInput.getSize();
        //获取实际图片的信息
        BufferedImage bufferFileOut = ImageIO.read(fileOutPut);
        DataBuffer daFileOutput=bufferFileOut.getData().getDataBuffer();
        int sizeFileOutPut=daFileOutput.getSize();
        Boolean matchFlag = true;
        if (sizeFileInput==sizeFileOutPut){
            for (int i = 0; i<sizeFileInput;i++){
                if (daFileInput.getElem(i)!= daFileOutput.getElem(i)){
                    matchFlag = false;
                    break;
                }
            }
        }else {
            matchFlag = false;
        }
        Assert.assertTrue(matchFlag,"测试过程中的截图额期望的截图不一致");
    }

}

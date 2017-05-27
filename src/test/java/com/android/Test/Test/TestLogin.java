package com.android.Test.Test;

import com.android.Test.Basic;
import com.android.Test.LogMessage;
import com.android.Test.Utils;
import org.eclipse.jetty.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class TestLogin extends Basic {

    @Test(priority = 1)
    public void testLogin1() {
        LogMessage.startTestCase("testLogin1");
        Utils.waitForElementById(pageManager.getUihelper().getAppiumDriver(),pageManager.getPageLogin().loginId);
        //LogMessage.startTestCase(LogMessage.getClassInMethod(this.getClass().getName(),1));
        //pageManager.getPageLogin().login();
        //pageManager.getScreenShot().getScreenShot();
        //pageManager.getUihelper().pageShouldBeText("1111");
        //Utils.waitForElementByName(pageManager.getUihelper().getAppiumDriver(),"登录");
        Assert.assertTrue(pageManager.getUihelper().pageShouldBeText("登录"));
        LogMessage.endTestCase("testLogin1");
    }

    @Test(priority = 2)
    public void testLogin2() {
        Utils.waitForElementById(pageManager.getUihelper().getAppiumDriver(),pageManager.getPageLogin().loginId);
        pageManager.getPageLogin().passwordIsLogin();
        Utils.waitForElementById(pageManager.getUihelper().getAppiumDriver(),pageManager.getPageLogin().loginId);
        Assert.assertTrue(pageManager.getUihelper().pageShouldBeText("登录"));
    }

    @Test(priority = 3)
    public void testLoogin3(){
        Utils.waitForElementById(pageManager.getUihelper().getAppiumDriver(),pageManager.getPageLogin().loginId);
    }
}

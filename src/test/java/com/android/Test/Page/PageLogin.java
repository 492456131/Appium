package com.android.Test.Page;
import com.android.Test.Uihelper;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class PageLogin extends PageBasic{
    private Uihelper uihelper;
    private String usernameId="com.jjshome.oa:id/username";
    private String passWordId="com.jjshome.oa:id/password";
    public String loginId="com.jjshome.oa:id/loginBtn";

    public PageLogin(Uihelper uihelper){
        super(uihelper);
        this.uihelper = uihelper;
    }

    private WebElement getUserName(){
       return uihelper.findElementById(usernameId);
    }

    private WebElement getPassWordId(){
        return uihelper.findElementById(passWordId);
    }

    private  WebElement getLoginButton(){
        return  uihelper.findElementById(loginId);
    }

    private void enterUserName(){
        getUserName().sendKeys("111111");
    }

    private void enterPassWrod(){
        getPassWordId().sendKeys("111111");
    }

    private void clickLoginButton(){
        getLoginButton().click();
    }

    public void login(){
        enterUserName();
        enterPassWrod();
        clickLoginButton();
    }

    public void passwordIsLogin(){
        enterUserName();
        clickLoginButton();
    }

}

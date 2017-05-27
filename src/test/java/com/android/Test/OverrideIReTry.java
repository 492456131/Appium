package com.android.Test;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by Administrator on 2017/5/16.
 */
public class OverrideIReTry implements IRetryAnalyzer {
    /*
    对于TestNG，首先重写接口IRetryAnalyzer，重写该接口中的retry方法，
    自定义需要重试的次数maxReTryNum，如果一个用例失败，自动进入retry方法，
    在此方法中判断已经重试的次数是否小于等于maxReTryNum，如果是，则返回true，
    则自动再次执行失败的用例，如果是失败的用例再次执行还是失败，那么还是自动调用retry方法，
    直到到重试次数大于设定的maxReTryNum了，则返回false，那么系统就是判定该方法失败了
     */
    public static Logger logger=Logger.getLogger(OverrideIReTry.class);
    public int initReTryNum=1;
    public int maxReTryNum=3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(initReTryNum<=maxReTryNum){
            String message="方法<"+iTestResult.getName()+">执行失败，重试第"+initReTryNum+"次";
            logger.info(message);
            Reporter.setCurrentTestResult(iTestResult);
            Reporter.log(message);
            initReTryNum++;
            return true;
        }
        return false;
    }
}

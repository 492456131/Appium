package com.android.Test;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/13.
 * Log日志类
 */
public class LogMessage {

    //初始化一个Logger对象
    static Logger logger = Logger.getLogger(Logger.class.getName());

    public static void startTestCase(String sTestName){
        logger.info("-------------------测试用例执行开始----------------------------");
        logger.info("-------------------"+ sTestName +"----------------");
    }

    public static void endTestCase(String sTestName){
        logger.info("---------------------测试用例执行结束--------------------------");
        logger.info("-------------------"+ sTestName +"----------------");
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void warn(String message){
        logger.info(message);
    }

    public static void fatal(String message){
        logger.info(message);
    }

    public static void debug(String message){
        logger.info(message);
    }

    public static void error(String message){
        logger.info(message);
    }

    public static void main(String arg[]){

    }
}

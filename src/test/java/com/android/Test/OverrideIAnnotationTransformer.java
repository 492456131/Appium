package com.android.Test;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/16.
 */
public class OverrideIAnnotationTransformer implements IAnnotationTransformer {
//当我们重写了TestNG的IRetryAnalyzer 接口，那么就需要让系统调用我们重写的接口，需要让TestNG调用，
// 还需要对TestNG.xml中的注解接口进行重写。先判断TestNG.xml中是否有重试分析器，如果没有，则调用我们自己重写类
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer iRetryAnalyzer= iTestAnnotation.getRetryAnalyzer();
        if(iRetryAnalyzer==null){
            iTestAnnotation.setRetryAnalyzer(OverrideIReTry.class);
        }
    }
}

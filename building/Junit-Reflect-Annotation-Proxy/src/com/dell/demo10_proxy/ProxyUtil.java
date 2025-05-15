package com.dell.demo10_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工具類：中介公司，專門負責創建代理對象，並返回給別人使用
 */
public class ProxyUtil {

    public static StarService createProxy(Star star){
        /**
         * 參數 一： 執行哪個類做加載器
         * 參數 二： 指定代理類需要實現的有那些接口；type：new Class[]
         * 參數 三： 用於指定代理類要如何代理
         */
        StarService proxy = (StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader()
                , star.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * 參數一：proxy接受到代理對象本身
                     * 參數二：method正在被代理的方法
                     * 參數三：args正在被代理的方法的參數
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 用來聲明代理對象要做的工作

                        // 取得方法名
                        String methodName = method.getName();
                        if("sing".equals(methodName)){
                            System.out.println("準備場地，收款20w");
                        }else if("dance".equals(methodName)){
                            System.out.println("準備場地，收款100w");
                        }

                        //找真正明星來幹活
                        Object result = method.invoke(star, args);
                        return result;
                    }
                });
        // 返回代理對象
        return proxy;
    }
}

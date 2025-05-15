package com.dell.demo11_prroxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    // 使用泛型<T>就能夠通用所有對象進來做代理
    public static <T> T createProxy(T t){
        T proxy = (T) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                t.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start =  System.currentTimeMillis();
                        Object result = method.invoke(t, args);
                        long end =  System.currentTimeMillis();
                        System.out.println(method.getName() + "方法耗時：" + (end - start) / 1000.0 + "秒");
                        return result;
                    }
                });
        return proxy;
    }
}

package com.brianway.learning.java.base.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * 获取jdk的原始对象
 */
public class ProxyTest {
    public static Object getOriginObject(Object proxy) throws Exception {
        //不是代理对象
        if (!isProxy(proxy)) {
            return proxy;
        } else {
            return getProxyTargetObject(proxy);
        }
    }

    private static boolean isProxy(Object object) {
        return Proxy.isProxyClass(object.getClass());
    }


    private static Object getProxyTargetObject(Object proxy) throws Exception {
        //在代理模式中看到过，原始类的信息就被存放在类型为InvocationHandler的变量中，名字就叫h
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        ServiceProxy aopProxy = (ServiceProxy) h.get(proxy);
        Field target = aopProxy.getClass().getDeclaredField("target");
        target.setAccessible(true);
        return target.get(aopProxy);
    }


    public static void main(String[] args) throws Exception {
       /* UserService o = (UserService) getOriginObject(new ServiceProxy().newInstance(new UserServiceImpl()));
        System.out.println(o.getUser());*/
        UserService userService = (UserService) new ServiceProxy().newInstance(new UserServiceImpl());
        System.out.println(userService.getUser());

    }


}

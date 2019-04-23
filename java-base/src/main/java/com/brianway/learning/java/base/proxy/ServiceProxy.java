package com.brianway.learning.java.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy implements InvocationHandler {

    private Object target;

    /**
     * 对接口的实现类进行动态代理
     *
     * @param clz
     * @param
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object newInstance(Object clz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.target = clz;
        return Proxy.newProxyInstance(clz.getClass().getClassLoader(), clz.getClass().getInterfaces(), this);
    }

    /**
     * 对单个接口进行动态代理
     *
     * @param clz
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public <T> T newInstance(Class<T> clz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.target = clz;
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //  return method.invoke(target, args);
        System.out.println(method.getName() + "......" + method.getDeclaringClass());
        if (Object.class.equals(method.getDeclaringClass())) {
            method.invoke(this, args);
            return null;
        }
        //  return "caoqiwen1";
        return method.invoke(target, args);
    }


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UserService userService = new ServiceProxy().newInstance(UserService.class);
        userService.toString();
        System.out.println(userService.getUser());
    }
}

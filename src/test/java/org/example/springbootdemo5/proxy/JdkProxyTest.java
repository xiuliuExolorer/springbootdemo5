package org.example.springbootdemo5.proxy;

import java.lang.reflect.Proxy;

public class JdkProxyTest implements JdkProxInterface{
    @Override
    public void method() {
        System.out.println("我是jdk动态代理 母方法 等待被增强");
    }

    @Override
    public void method2() {
        System.out.println("method2 母方法 等待被增强");
    }

    public static void main1(String[] args) {
        JdkProxyTest jdkProxyTest = new JdkProxyTest();
        JdkProxInterface jdkProxInterface =  (JdkProxInterface)Proxy.newProxyInstance(
                jdkProxyTest.getClass().getClassLoader(),
                jdkProxyTest.getClass().getInterfaces(),
                new JdkDynamicProxy(jdkProxyTest));
        jdkProxInterface.method();
        System.out.println("------------------");
        jdkProxInterface.method2();
    }

    public static void main(String[] args) {
        JdkProxyTest jdkProxyTest = new JdkProxyTest();
        JdkProxInterface jdkProxInterface = (JdkProxInterface)Proxy.newProxyInstance(jdkProxyTest.getClass().getClassLoader()
                , jdkProxyTest.getClass().getInterfaces(), new JdkDynamicProxy(jdkProxyTest));
        jdkProxInterface.method();
    }
}

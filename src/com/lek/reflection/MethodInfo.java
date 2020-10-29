package com.lek.reflection;

import java.lang.reflect.Method;

public class MethodInfo {
    public static void main(String[] args) {
        Entity e = new Entity(10, "id");
        Class clss = e.getClass();
        Method[] methods = clss.getMethods();
        for(Method method : methods) {
             System.out.println(method.getName());
        }
        System.out.println("=================================");
        Method[] methods2 = clss.getDeclaredMethods();
        for(Method method : methods2) {
            System.out.println(method.getName());
        }
    }
}

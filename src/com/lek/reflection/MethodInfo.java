package com.lek.reflection;

import java.lang.reflect.Method;

public class MethodInfo {
    public static void main(String[] args) throws Exception {
        Entity e = new Entity(10, "id");
        Class<? extends Entity> clss = e.getClass();
        Method[] methods = clss.getMethods();
        for(Method method : methods) {
             System.out.println(method);
        }
        System.out.println("=================================");
        Method[] methods2 = clss.getDeclaredMethods();
        for(Method method : methods2) {
            System.out.println(method);
        }

        System.out.println("=================================");
        Method med = clss.getMethod("setVal", int.class);
        med.invoke(e, 15);

        Method med2 = clss.getMethod("getVal");
        System.out.println(med2.invoke(e));
    }
}

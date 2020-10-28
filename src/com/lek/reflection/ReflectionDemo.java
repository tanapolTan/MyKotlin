package com.lek.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clss = Class.forName("com.lek.reflection.MyClass");
        Constructor<?> con = clss.getDeclaredConstructor();
        con.setAccessible(true);
        Object obj = con.newInstance();
        System.out.println(obj);
    }
}

class MyClass {
    private MyClass() {
        System.out.println("My Class is created");
    }
}
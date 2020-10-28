package com.lek.reflection;

public class ReflectionClass {
    public static void main(String[] args) throws Exception {
        // create for name
        Class<?> clss = Class.forName("java.lang.String");

        // create from ClassName.Class
        Class<?> clss2 = Integer.class;

        // create Class from obj
        String myObj = new String();
        Class<?> clss3 = myObj.getClass();

        // can get super class
        Class<?> clss4 = clss3.getSuperclass();

        // can get interface --> return array of interface
        Class<?>[] interFace = clss3.getInterfaces();
    }
}

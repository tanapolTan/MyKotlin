package com.lek.annotation;

class Parent {
    public void m1() {
        System.out.println("Parent - M1");
    }

    public void m2() {
        System.out.println("Parent - M2");
    }
}

public class GeneralAnnotation extends Parent {

    @Override
    public void m1() {
        System.out.println("Child - M1");
    }

    public static void main(String[] args) {
        @SuppressWarnings("all")
        int a = 1;

        FuncInterface fi = (String test) -> {
          System.out.println("method invoke : " + test);
        };

        fi.method("xxx");
    }
}

@FunctionalInterface
interface FuncInterface {
    public void method(String test);
}
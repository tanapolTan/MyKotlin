package com.lek.reflection;

import java.lang.reflect.Constructor;

public class ConstructorInfo {
    public static void main(String[] args) throws Exception {
        Class clss = Class.forName("com.lek.reflection.Entity");
        Constructor[] cons = clss.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }

        Constructor pubCon = clss.getConstructor(int.class, String.class);
        Entity obj = (Entity) pubCon.newInstance(10, "id");
        System.out.println(obj.getVal());

        Constructor priCon = clss.getDeclaredConstructor();
        priCon.setAccessible(true);
        Entity obj2 = (Entity) priCon.newInstance();
        System.out.println(obj2.getType());
    }
}

package com.lek.reflection;

import java.lang.reflect.Field;

public class FieldInfo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Entity e = new Entity(10, "id");
        Class clss = e.getClass();

        Field[] fleids = clss.getFields();
        for (Field field : fleids) {
            System.out.println(field.getName());
        }

        Field[] fleids2 = clss.getDeclaredFields();
        for (Field field : fleids2) {
            System.out.println(field.getName());
        }

        Field field = clss.getField("type");
        System.out.println(field.get(e));
        field.set(e, "rollNo");

        System.out.println("==========================");
        System.out.println(e.getType());

        System.out.println("setAccessible ==========================");
        Field field2 = clss.getDeclaredField("val");
        field2.setAccessible(true);
        field2.set(e, 12);
        System.out.println(e.getVal());

    }
}

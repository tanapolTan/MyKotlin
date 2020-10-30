package com.lek.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifierInfo {
    public static void main(String[] args) throws Exception{
        Class clss = Class.forName("com.lek.reflection.Entity");
        int modifier = clss.getModifiers();
        int isPub = modifier & Modifier.PUBLIC;
        System.out.println("isPub > " + isPub);
        System.out.println(Modifier.toString(modifier));

        Method med = clss.getMethod("getType");
        int medMod = med.getModifiers();
        int isModPub = medMod & Modifier.PUBLIC;
        System.out.println("isModPub > " + isModPub);

        Field[] fields = clss.getDeclaredFields();
        for(Field field : fields) { ;
            boolean fMod = Modifier.isPublic(field.getModifiers());
            System.out.println("fMod > " + fMod);
        }
    }
}

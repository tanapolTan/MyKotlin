package com.lek.readannotation;

import com.lek.annotation.MostUse;
import com.lek.annotation.Utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReadingAnnotation {
    public static void main(String[] args) throws Exception {
        Class clss = Class.forName("com.lek.annotation.Utility");
        Constructor con = clss.getConstructor();
        Utility util = (Utility) con.newInstance();
        Method[] mets = clss.getDeclaredMethods();

        for (Method met : mets) {
            if (met.isAnnotationPresent(MostUse.class)) {
                met.setAccessible(true);
                met.invoke(util, "xxx");

                MostUse annotation = met.getAnnotation(MostUse.class);
                System.out.println(">>>>>" + annotation.value());
            }
        }
    }
}

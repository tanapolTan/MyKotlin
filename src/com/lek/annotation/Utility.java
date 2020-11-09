package com.lek.annotation;

@MostUse
public class Utility {
    void doStuff() {
        System.out.println("Doing Something");
    }

    @MostUse("Python")
    void doStuff(String arg) {
        System.out.println("Doing Something : " + arg );
    }

    void doStuff(int i) {
        System.out.println("Doing Something : " + i);
    }
}

class SubUtility extends Utility {

}

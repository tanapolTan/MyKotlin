package com.lek.annotation2;

public class Enhancement {
    public static void main(String[] args) {
        Box<String> box = new @NonEmpty @ReadOnly Box(10, "Container");
        box.new @ReadOnly NestedBox(11, "Cyder");
    }
}

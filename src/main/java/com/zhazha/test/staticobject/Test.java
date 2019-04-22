package com.zhazha.test.staticobject;

public class Test {
    static int i = 10;
    static {
        i /= 3;
    }

    public static void main(String[] args) {
        System.out.println(i);
    }

    static {
        i += 5;
    }
}

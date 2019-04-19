package com.zhazha.java.string;

public class StringTest {
    public static void main(String[] args) {
        String str = "ABC";
        byte[] bt = str.getBytes();
        System.out.println(new String(bt));

    }
}

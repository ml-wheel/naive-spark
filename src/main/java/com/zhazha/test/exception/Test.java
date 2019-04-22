package com.zhazha.test.exception;

public class Test {
    public static void main(String[] args) {
        System.out.println(getVal());
    }
    public  static int getVal(){
        try {
            return 0;
        }
        finally {
            return 1;
        }
    }
}

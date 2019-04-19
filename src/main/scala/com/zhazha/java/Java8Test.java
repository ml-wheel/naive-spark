package com.zhazha.java;

public class Java8Test {
    public static void main(String[] args) {
        MathOperation addition = (int a, int b) -> a + b;
    }


}


interface MathOperation {
    int operation(int a, int b);
}
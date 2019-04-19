package com.zhazha.java;

public interface TestInterface {
    default void print() {
        System.out.println("我是一辆车!");
    }
}

package com.zhazha.test.java8;

public interface TestInterface {
    default void print() {
        System.out.println("我是一辆车!");
    }
}

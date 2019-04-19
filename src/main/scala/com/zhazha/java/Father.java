package com.zhazha.java;

class Father {
    static {
        System.out.println("static Father");
    }

    {
        System.out.println("Father");
    }

    public Father() {
        System.out.println("con Father");
    }
}


class Son extends Father {
    static {
        System.out.println("static Son");
    }

    {
        System.out.println("Son");
    }

    public Son() {
        System.out.println("con Son");
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
package com.zhazha.java;

class TestThread extends Thread {
//    public TestThread(){
//        this.setName("MyThread");
//    }

    @Override
    public void run() {
        System.out.println(TestThread.currentThread().getName());
    }
}

class Test {
    public static void main(String[] args) {
        Thread t = new TestThread();
        t.run();
        t.start();
    }
}

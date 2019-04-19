package com.zhazha.java;

import org.spark_project.jetty.util.ArrayQueue;

import java.util.Queue;

public class BLockQueue<T> {
    private Queue<T> queue;
    private int lenght;
    private int currentSize;

    public BLockQueue(int n) {
        this.lenght = n;
        queue = new ArrayQueue<T>(this.lenght);
    }

    public void put(T t) throws Exception {
        synchronized (this) {
            //full of queue
            while (this.currentSize == this.lenght) {
                wait();
            }
            this.queue.add(t);
            currentSize++;
            notifyAll();
        }
    }

    public T take() throws Exception {
        synchronized (this) {
            //empty of queue
            while (this.currentSize == 0) {
                wait();
            }
            T t = this.queue.poll();
            currentSize--;
            notifyAll();
            return t;
        }
    }


}


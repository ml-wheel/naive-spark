package com.zhazha.test.java8;


import java.util.Arrays;

public class MyHashMap<K, V> {
    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;
    }

    private Node<K, V>[] table;

    // 扩容阈值
    final float SPLIT_LEN_PER = 0.75f;

    private int size;

    public V put(V v) {
        return v;
    }

    public V get() {
        return table[0].value;
    }

    private Node<K, V>[] resize() {
        Node<K, V>[] nt = table;
        if (table == null || table.length == 0) {
            nt = (Node<K, V>[]) new Node<?, ?>[8];
        } else if (table.length * SPLIT_LEN_PER <= size) {
            nt = Arrays.copyOfRange(table, 0, table.length * 2);
        }
        return nt;
    }

    public static void main(String[] args) {
        Node<?, ?>[] table = new Node<?, ?>[8];
        Node<?, ?>[] newTable = Arrays.copyOfRange(table, 0, 16);
        System.out.println(newTable.length);

    }
}

package com.zhazha.java;

public class QuickSort {
    public static void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (key < src[j] && i < j) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (key > src[i] && i < j) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
                src[i] = key;
                quickSort(src, begin, i - 1);
                quickSort(src, i + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] src = {3, 9, 6, 4, 8, 6};
        quickSort(src, 0, 5);
        for (int i : src) {
            System.out.println(i);
        }
    }
}

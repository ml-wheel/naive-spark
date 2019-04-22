package com.zhazha.test.sort;

import java.util.Arrays;
import java.util.Collections;

public class TopKSort {
    public int[] sortTopK(int[] src, int k) throws Exception {
        int[] karr = Arrays.copyOfRange(src, 0, k - 1);
        Arrays.sort(karr);
        int kMin = karr[0];
        int kMax = karr[1];
        return null;
    }


    public static void InsertSort(int[] arr) {
        int i, j;
        int n = arr.length;
        int target;

        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }
    }


    public static int topK(int[] src, int k) {
        int[] kArr = Arrays.copyOfRange(src, 0, k);
        for (int i = k; i <= src.length - 1; i++) {
        }
        return kArr[0];
    }


    public static void main(String[] args) {
        int[] src = {1, 7, 9, 12, 13, 17, 21, 98};
        System.out.println(topK(src, 3));
    }
}

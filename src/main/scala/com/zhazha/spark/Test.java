package com.zhazha.spark;

import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] src = {6, 1, 3, 5, 4};
        quickSort(src, 0, src.length - 1);
        System.out.println(binarySearch(src, 0, 4, 6));
    }


    static void stringIntern() {
        String str1 = new StringBuilder("ja").append("va").toString();
        String str2 = new StringBuilder("kaige").toString();
        String str3 = new StringBuilder("kaige").toString();
        String str4 = new StringBuilder("tan").append("yk").toString();
        String str5 = new StringBuilder("tan").append("yk").toString();
        System.out.println(str1.intern() == str1);
        System.out.println(str2.intern() == str2);
        System.out.println(str3.intern() == str3);
        System.out.println(str4.intern() == str4);
        System.out.println(str5.intern() == str5);
//        false 内存中已有
//        false
//        false
//        true
//        false

    }


    /**
     * 求两个数据中和为M的组合
     *
     * @param src1
     * @param src2
     * @param m
     * @return 两个数组的和为M的组合的索引值
     */
    static Map<Integer, Integer> findCombin(int[] src1, int[] src2, int m) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < src1.length; i++) {
            int tmpIndex = src2.length;
            for (int j = 0; j <= tmpIndex; j++) {
                if (src1[i] + src2[j] == m) {
                    tmpIndex = j - 1;
                    map.put(i, j);
                }
            }
        }
        return map;
    }

    /**
     * 判断一个数是否是2的N次幂
     *
     * @param x
     * @return
     */
    static boolean is2power(int x) {
        return (x & (x - 1)) == 0;
    }

    /**
     * 快速排序
     * 复杂度O(n2)
     *
     * @param src
     * @param start
     * @param end
     */
    static void quickSort(int[] src, int start, int end) {
        if (start < end) {
            int key = src[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src, start, i - 1);
            quickSort(src, i + 1, end);
        }

    }

    /**
     * 二分查找 时间复杂度O(log2n)
     *
     * @param src
     * @param start
     * @param end
     * @param key
     * @return
     */
    //1,3,4,5,6
    //0,1,2,3,4
    static int binarySearch(int[] src, int start, int end, int key) {
        if (start <= end) {
            int halfIndex = (start + end) / 2;
            int halfVal = src[halfIndex];
            if (key > halfVal) {
                return binarySearch(src, halfIndex + 1, end, key);
            } else if (key < halfVal) {
                return binarySearch(src, start, halfIndex - 1, key);
            } else if (key == halfVal) {
                return halfIndex;
            }
        }
        return -1;
    }


}

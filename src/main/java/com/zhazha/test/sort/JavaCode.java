package com.zhazha.test.sort;

import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JavaCode {

    static int MAXIMUM_CAPACITY = 1 << 30;

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(16 << 1);
    }


    /**
     * 这傻狗~
     */
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


    /**
     * 斐波那契数列求值
     * An  + An+1 = An+2
     * 161已经是极限了,162会出现负数
     * 160 : 8259707399215967867
     * 161 : 9217463444206948445
     * 162 : -969573230286635304
     * 循环求值
     */
//    static long getFibonacciN(long n) {
//        long a = 1;
//        long b = 1;
//        long c = 0;
//        if (n <= 2) {
//            return 1;
//        } else {
//            for (long x = 2; x < n; x++) {
//                c = a + b;
//                a = b;
//                b = c;
//            }
//            return c;
//        }
//    }

    /**
     * 斐波那契数列求值
     *
     * @param n
     * @return 递归求解
     */
    static long getFibonacciN(int n) {
        if (n > 2) {
            return getFibonacciN(n - 1) + getFibonacciN(n - 2);
        } else if (n <= 2 && n >= 1) {
            return 1l;
        } else {
            return -1l;
        }

    }

    class Node {
        int index;
        Node next;

        public Node(int index, Node next) {
            this.index = index;
            this.next = next;
        }
    }

    /**
     * 单链表倒置
     *
     * @param node
     * @return 递归
     */
    static Node reverse(Node node) {
        if (node.next == null) return node;
        Node next = node.next;
        node.next = null;
        Node re = reverse(next);
        next.next = node;
        return re;

    }

    /**
     * 单链表倒置
     *
     * @param node return
     *             迭代
     */

    static Node reverse1(Node node) {
        Node prev = null;
        Node now = node;
        while (now != null) {
            Node next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }

        return prev;
    }

}

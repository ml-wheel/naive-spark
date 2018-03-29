package com.zhazha.spark;

import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        String str1 = new String("java");
//
//        System.out.println(str1==str1.intern());
//
//        String str2 = new StringBuilder("58").append("ganji").toString();
//        System.out.println(str2.intern()==str2);
//        String str3 = new StringBuilder("58").append("ganji").toString();
//        System.out.println(str3.intern()==str3);
//        String str4 = new StringBuilder("58").append("ganji").toString();
//        System.out.println(str4.intern()=="58ganji");
        System.out.println(is2power(8));
    }

    //两个数组中求
    static Map<Integer, Integer> findCombin(int[] src1, int[] src2, int m) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < src1.length; i++) {
            int tmpIndex = src2.length;
            for (int j = 0; j <= tmpIndex; j++) {
                if (src1[i]+src2[j] == m) {
                    tmpIndex = j - 1;
                    map.put(i,j);
                }
            }
        }
        return map;
    }


    static boolean is2power(int x){
        return (x & (x-1))==0;
    }

}

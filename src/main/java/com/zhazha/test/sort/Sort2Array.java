package com.zhazha.test.sort;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class Sort2Array {
    public static List<Integer> sortList(List<Integer> list1, List<Integer> list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        int len1 = list1.size();
        int len2 = list2.size();
        if (len1 == 0) {
            return list2;
        }
        if (len2 == 0) {
            return list1;
        }
        List<Integer> list = new ArrayList<>();
        int flat1 = 0;
        int flat2 = 0;
        while (flat1 < len1 && flat2 < len2) {
            int tmp1 = list1.get(flat1);
            int tmp2 = list2.get(flat2);
            if (tmp1 < tmp2) {
                list.add(tmp1);
                flat1++;
            } else {
                list.add(tmp2);
                flat2++;
            }
        }

        if (flat1 == len1) {
            list.addAll(list2.subList(flat2, len2));
        } else {
            list.addAll(list1.subList(flat1, len1));
        }

        return list;

    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(9);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(7);
        list2.add(8);
        list2.add(9);

        List<Integer> list = sortList(list1, list2);
        for (int i : list) {
            System.out.println(i);
        }
    }
}

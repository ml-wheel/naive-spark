package com.zhazha.test.array;

import java.util.ArrayList;
import java.util.List;

public class FindDoubleArray {


    /**
     * 递增二维数组查找
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        int m = 0;
        int n = 0;
        return findVal(target, array, m, n);
    }

    private static boolean findVal(int target, int[][] array, int m, int n) {
        boolean flag = false;
        int mid = array[m][n];
        if (mid == target) {
            flag = true;
        }
        while (mid < target) {
            m++;
            n++;
            mid = array[m][n];
//            findVal(target, array, m, n);
        }

        if (mid > target) {
            // 查找行m,列小于n的所有结
            for (int i = 0; i <= n; i++) {
                if (array[m][i] == target) {
                    flag = true;
                }
            }
            // 查找列n,行小于m的所有结果
            for (int i = 0; i <= n; i++) {
                if (array[i][n] == target) {
                    flag = true;
                }
            }
        }
        return flag;
    }


    /**
     * 顺时针打印二维数组
     *
     * @param matrix
     * @return
     */
    public List<Integer> printMatrix(int[][] matrix) {
        int top = 0;
        int buttom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<Integer>();
        while (top < buttom && left < right) {
            //top
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
                top++;
            }
            //right
            for (int i = top; i <= buttom; i++) {
                list.add(matrix[right][i]);
                right--;
            }
            //buttom
            for (int i = right; i >= left; i--) {
                list.add(matrix[buttom][i]);
                buttom--;
            }
            //left
            for (int i = buttom; i >= top; i--) {
                list.add(matrix[i][left]);
                left++;
            }


        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {11, 12, 13, 14, 15, 16, 17};
        int[][] arr = {arr1, arr2};
        System.out.println(Find(12, arr));


    }
}
package com.zhazha.test.tree;

public class findPath {
    static class TreeData {
        Integer leftdata;
        Integer rightdata;
    }

    static class Tree {
        Tree left;
        Tree right;
        TreeData data;
    }

    public static void findPath(Tree tree, int maxM, int maxN) {
        TreeData data = tree.data;
        Integer left = data.leftdata;
        Integer right = data.rightdata;
        if (left < maxM) {
            TreeData leftTreeData = new TreeData();
            leftTreeData.leftdata = left + 1;
            leftTreeData.rightdata = right;
            Tree leftTree = new Tree();
            leftTree.data = leftTreeData;
            tree.left = leftTree;
            findPath(tree.left, maxM, maxN);
        }
        if (right < maxN) {
            TreeData rightTreeData = new TreeData();
            rightTreeData.leftdata = left;
            rightTreeData.rightdata = right + 1;
            Tree rightTree = new Tree();
            rightTree.data = rightTreeData;
            tree.right = rightTree;
            findPath(tree.right, maxM, maxN);
        }
    }

    public static int getSteps(Tree tree) {
        Tree left = tree.left;
        Tree right = tree.right;
        if (left == null && right == null) {
            return 1;
        } else if (left == null && right != null) {
            return getSteps(right);
        } else if (left != null && right == null) {
            return getSteps(left);
        } else {
            return getSteps(left) + getSteps(right);
        }
    }


    public static void main(String[] args) {
        TreeData data = new TreeData();
        data.leftdata = 0;
        data.rightdata = 0;
        Tree tree = new Tree();
        tree.data = data;
        findPath(tree, 4, 4);
        System.out.println(getSteps(tree));
    }

}

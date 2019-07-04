package com.aspire.caoqiwen.tree;


/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 采用递归调用的方式来计算，运算速度最快。
 */

public class HasPathSum {
    public static class TreeNode {
        int data;
        HasPathSum.TreeNode left;
        HasPathSum.TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public HasPathSum.TreeNode getLeft() {
            return left;
        }

        public void setLeft(HasPathSum.TreeNode left) {
            this.left = left;
        }

        public HasPathSum.TreeNode getRight() {
            return right;
        }

        public void setRight(HasPathSum.TreeNode right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int t = sum - root.data;
        if (root.left == null && root.right == null) {
            return t == 0 ? true : false;
        }
        return hasPathSum(root.left, t) || hasPathSum(root.right, t);
    }
}

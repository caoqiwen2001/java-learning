package com.aspire.caoqiwen.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树。
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */

public class InorderTraversal {

    public static class TreeNode {
        int data;
        InorderTraversal.TreeNode left;
        InorderTraversal.TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public InorderTraversal.TreeNode getLeft() {
            return left;
        }

        public void setLeft(InorderTraversal.TreeNode left) {
            this.left = left;
        }

        public InorderTraversal.TreeNode getRight() {
            return right;
        }

        public void setRight(InorderTraversal.TreeNode right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> nodeList = new LinkedList<>();
        while (true) {
            while (root != null) {
                ((LinkedList<TreeNode>) nodeList).push(root);
                root = root.left;
            }
            if (nodeList.isEmpty()) {
                return list;
            }
            root = ((LinkedList<TreeNode>) nodeList).pop();
            list.add(root.data);
            root = root.right;
        }
    }
}

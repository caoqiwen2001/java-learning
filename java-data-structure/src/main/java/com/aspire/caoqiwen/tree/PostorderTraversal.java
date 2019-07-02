package com.aspire.caoqiwen.tree;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> nodeList = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        //左子树入栈。
        while (cur != null || !nodeList.isEmpty()) {
            while (cur != null) {
                ((LinkedList<TreeNode>) nodeList).push(cur);
                cur = cur.left;
            }
            cur = ((LinkedList<TreeNode>) nodeList).peek();
            //防止右子树访问过了 又继续访问。
            if (cur.right == null || cur.right == pre) {
                ((LinkedList<TreeNode>) nodeList).pop();
                list.add(cur.data);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return list;
    }

}

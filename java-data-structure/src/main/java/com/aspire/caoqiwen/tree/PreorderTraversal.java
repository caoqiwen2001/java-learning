package com.aspire.caoqiwen.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 */
public class PreorderTraversal {

    public static class TreeNode {
        int data;
        PreorderTraversal.TreeNode left;
        PreorderTraversal.TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public PreorderTraversal.TreeNode getLeft() {
            return left;
        }

        public void setLeft(PreorderTraversal.TreeNode left) {
            this.left = left;
        }

        public PreorderTraversal.TreeNode getRight() {
            return right;
        }

        public void setRight(PreorderTraversal.TreeNode right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {

//        preorderTraversal();
    }

    public static List<Integer> preorderTraversal(PreorderTraversal.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) {
            return list;
        }
        List<PreorderTraversal.TreeNode> nodelist = new LinkedList<>();
        nodelist.add(root);
        PreorderTraversal.TreeNode treeNode = null;
        while (nodelist.size() > 0) {
            treeNode = ((LinkedList<TreeNode>) nodelist).pop();
            list.add(treeNode.data);
            if (treeNode.right != null) {
                ((LinkedList<TreeNode>) nodelist).push(treeNode.right);
            }

            if (treeNode.left != null) {
                ((LinkedList<TreeNode>) nodelist).push(treeNode.left);
            }
        }
        return list;
    }

}

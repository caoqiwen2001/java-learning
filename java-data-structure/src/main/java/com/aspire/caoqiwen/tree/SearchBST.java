package com.aspire.caoqiwen.tree;


import java.util.LinkedList;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和值: 2
 * <p>
 * <p>
 * 2
 * / \
 * 1   3
 */


public class SearchBST {

    private static LinkedList<TreeNode> list = new LinkedList<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        System.out.println("hello wolrd");
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            pushLinkList(root.right);
            return getTreeNode(val);
        } else if (root.val > val) {
            pushLinkList(root.left);
            return getTreeNode(val);
        } else {
            return root;
        }

    }

    private static void pushLinkList(TreeNode node) {
        TreeNode curNode = node;
        while (curNode != null) {
            list.push(curNode);
            curNode = curNode.left;
        }
    }

    private static TreeNode getTreeNode(int val) {
        while (list.isEmpty() == false) {
            TreeNode node = list.pop();
            if (node.val == val) {
                return node;
            }
            TreeNode curNode = node;
            if (curNode.right != null) {
                curNode = curNode.right;
                pushLinkList(curNode);
            }
        }
        return null;
    }


    /**
     * 采用递归来做更快
     */

    public static TreeNode searchBSTRecurve(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode real_root = null;
        if (root.val > val) {
            real_root = searchBSTRecurve(root.left, val);
        } else {
            real_root = searchBSTRecurve(root.right, val);
        }
        return real_root;
    }


}

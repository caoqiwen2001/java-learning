package com.aspire.caoqiwen.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode01 = new TreeNode(1);
        TreeNode treeNode02 = new TreeNode(1);
        treeNode01.left = treeNode02;
        System.out.println(isValidBST(treeNode01));

    }


    /**
     * 利用中序遍历 可以得到一个顺序的二叉搜索树
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

    private static void midOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        midOrder(root.left, list);
        list.add(root.val);
        midOrder(root.right, list);
    }


}

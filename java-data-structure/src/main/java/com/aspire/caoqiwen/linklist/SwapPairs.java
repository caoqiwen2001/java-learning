package com.aspire.caoqiwen.linklist;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        System.out.println("hello world!");
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
}

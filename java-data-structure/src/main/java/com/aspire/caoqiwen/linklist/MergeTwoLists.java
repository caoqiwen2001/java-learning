package com.aspire.caoqiwen.linklist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }


    public ListNode mergetTwoList2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curHead = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curHead.next = l1;
                curHead = curHead.next;
                l1 = l1.next;
            } else {
                curHead.next = l2;
                curHead = curHead.next;
                l2 = l2.next;
            }
            if (l1 == null) {
                curHead.next = l2;
            } else {
                curHead.next = l1;
            }
        }
        return dummyHead.next;
    }
}

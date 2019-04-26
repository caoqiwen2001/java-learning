package com.aspire.caoqiwen.linklist;


/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 找两个链表的公共节点
 * listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
 */
public class IntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        listNode1.next = node1;
        ListNode node8 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node8;
        node8.next = node4;
        node4.next = node5;


        ListNode listNode2 = new ListNode(5);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode11 = new ListNode(1);
        listNode2.next = listNode0;
        listNode0.next = listNode11;
        listNode11.next = node8;
        node8.next = node4;
        node4.next = node5;
        System.out.println(getIntersectionNode(listNode1, listNode2).val);


    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p = headA;
        ListNode q = headB;
        while (p != null && q != null) {
            p = p.next;
            q = q.next;
        }
        while (p != null) {
            p = p.next;
            headA = headA.next;
        }
        while (q != null) {
            q = q.next;
            headB = headB.next;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

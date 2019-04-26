package com.aspire.caoqiwen.linklist;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        System.out.println("hello world");
        IntersectionNode.ListNode nd1 = new IntersectionNode.ListNode(1);
        IntersectionNode.ListNode nd2 = new IntersectionNode.ListNode(2);
        IntersectionNode.ListNode nd3 = new IntersectionNode.ListNode(3);
        IntersectionNode.ListNode nd4 = new IntersectionNode.ListNode(4);
        IntersectionNode.ListNode nd5 = new IntersectionNode.ListNode(5);
        nd1.next = nd2;
        nd2.next = nd3;
        nd3.next = nd4;
        nd4.next = nd5;
        IntersectionNode.ListNode result = removeNthFromEnd(nd1, 2);
        System.out.println(removeNthFromEnd(nd1, 2));
    }

    public static IntersectionNode.ListNode removeNthFromEnd(IntersectionNode.ListNode head, int n) {
        IntersectionNode.ListNode p = head;
        IntersectionNode.ListNode q = head;

        while (n != 0) {
            p = p.next;
            --n;
        }
        if (p == null) {
            return head.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}

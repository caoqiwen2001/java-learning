package com.aspire.caoqiwen.linklist;


/**
 * 翻转链表
 */
public class ReverseList {

    private static IntersectionNode.ListNode listNode;


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
        IntersectionNode.ListNode result = reverseList(nd1);
        System.out.println("result has success");
    }


    public static IntersectionNode.ListNode reverseList(IntersectionNode.ListNode node) {
        IntersectionNode.ListNode prev = null;
        while (node != null) {
            IntersectionNode.ListNode tmp = node.next;  //下一个节点
            node.next = prev;   //   第一个节点的下个节点为空
            prev = node;             //把当期节点给prev
            node = tmp;
        }
        return prev;
    }
}

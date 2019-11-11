package com.aspire.caoqiwen.linklist;


/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenList {

    public static void main(String[] args) {
        System.out.println("hello word");
        IntersectionNode.ListNode nd1 = new IntersectionNode.ListNode(3);
        IntersectionNode.ListNode nd2 = new IntersectionNode.ListNode(2);
        IntersectionNode.ListNode nd3 = new IntersectionNode.ListNode(3);
        IntersectionNode.ListNode nd4 = new IntersectionNode.ListNode(3);
        IntersectionNode.ListNode nd5 = new IntersectionNode.ListNode(5);
        nd1.next = nd2;
        nd2.next = nd3;
        nd3.next = nd4;
        nd4.next = nd5;
        IntersectionNode.ListNode result = oddEvenList(nd1);
        System.out.println(result);

    }

    public static IntersectionNode.ListNode oddEvenList(IntersectionNode.ListNode head) {
        IntersectionNode.ListNode fiHead = new IntersectionNode.ListNode(-1);
        IntersectionNode.ListNode scHead = new IntersectionNode.ListNode(-1);
        IntersectionNode.ListNode listNode = fiHead;
        IntersectionNode.ListNode scNode = scHead;
        int i = 0;
        while (head != null) {
            IntersectionNode.ListNode tmp = head.next;
            if (i % 2 == 0) {
                head.next = null;
                fiHead.next = head;
                fiHead = fiHead.next;

            } else {
                head.next = null;
                scHead.next = head;
                scHead = scHead.next;

            }
            i++;
            head = tmp;
        }
        IntersectionNode.ListNode tailNode = listNode;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = scNode.next;
        return tailNode.next;
    }
}

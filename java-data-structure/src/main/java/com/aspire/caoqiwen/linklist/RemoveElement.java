package com.aspire.caoqiwen.linklist;


/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 1->2->6->3->4->5->6,
 * val = 6
 */
public class RemoveElement {


    public static void main(String[] args) {
        System.out.println("hello world");
        IntersectionNode.ListNode nd1 = new IntersectionNode.ListNode(3);
        IntersectionNode.ListNode nd2 = new IntersectionNode.ListNode(2);
        IntersectionNode.ListNode nd3 = new IntersectionNode.ListNode(3);
        IntersectionNode.ListNode nd4 = new IntersectionNode.ListNode(3);
        IntersectionNode.ListNode nd5 = new IntersectionNode.ListNode(5);
        nd1.next = nd2;
        nd2.next = nd3;
        nd3.next = nd4;
        nd4.next = nd5;
        IntersectionNode.ListNode result = removeElements(nd1, 3);
        System.out.println("result has success");
    }

    /**
     * 递归删除
     *
     * @param head
     * @param val
     * @return
     */
    public static IntersectionNode.ListNode removeElements(IntersectionNode.ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //递归调用
        IntersectionNode.ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    /**
     * 非递归形式
     *
     * @param val
     * @return
     */
    public static IntersectionNode.ListNode removeElemets1(IntersectionNode.ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }
        IntersectionNode.ListNode listNode = head;
        if (head == null) {
            return null;
        }
        while (listNode.next != null) {
            if (listNode.next.val == val) {
                listNode.next = listNode.next.next;
            } else {
                listNode = listNode.next;
            }
        }
        return head;
    }
}

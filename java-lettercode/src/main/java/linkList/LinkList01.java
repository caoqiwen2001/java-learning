package linkList;


/**
 * 如果没有环，快指针将停在链表的末尾。
 * 如果有环，快指针最终将与慢指针相遇。
 */


public class LinkList01 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 判断是否有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取环的第一个节点
     *
     * @param head
     * @return
     */
    public static ListNode getFirstNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;
        System.out.println(getFirstNode(node1));


    }


}

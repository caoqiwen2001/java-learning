package com.aspire.caoqiwen.linklist;

import java.util.LinkedList;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println("hello world");
        LinkedList<String> test = new LinkedList<>();
        test.add("1");
        test.add("2");
        test.add("3");

        LinkedList<String> test1 = new LinkedList<>(test);
        test1.remove("1");
        System.out.println("test size has " + test.size());
        System.out.println("test1 size hase " + test1.size());
    }


    /**
     * 请判断一个链表是否为回文链表。
     * 输入: 1->2
     * 输出: false
     * 输入: 1->2->2->1
     * 输出: true
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(IntersectionNode.ListNode head) {

        //思路用递归


        return false;
    }
}

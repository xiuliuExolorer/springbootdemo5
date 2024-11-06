package org.example.springbootdemo5.demos.service.算法;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // 保存下一个节点
            curr.next = prev;          // 当前节点指向前一个节点
            prev = curr;               // 前一个节点移动到当前节点
            curr = next;               // 当前节点移动到下一个节点
        }
        return prev; // 新的头节点
    }
}
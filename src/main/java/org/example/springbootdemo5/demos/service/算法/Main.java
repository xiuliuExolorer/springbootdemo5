package org.example.springbootdemo5.demos.service.算法;

public class Main {

    public static ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        // 创建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 打印原始链表nm
        System.out.println("Original list:");
        printList(head);

        // 反转链表
        ListNode reversedHead = reverseList(head);

        // 打印反转后的链表
        System.out.println("Reversed list:");
        printList(reversedHead);
    }

    // 打印链表的方法
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
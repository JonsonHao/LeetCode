package jvav;

/**
 * @author created by linjunhao
 * @date 2020/6/18
 * @description: 61. 旋转链表
 * @tag: Linked List
 * @difficuty: medium
 */
public class Solution61 {

    /**
     * 解法1
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 首先计算链表节点个数
        ListNode curr = head;
        int len = 0;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        len++;

        k %= len;
        // 如果节点数和旋转个数相同，则直接返回当前链表的头节点
        if (k == 0) return head;
        // 把链表变成一个环
        curr.next = head;
        // 移动到新的尾节点
        for (int i = 0; i < len - k; i++) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}
}

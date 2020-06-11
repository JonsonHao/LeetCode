package kotlincode

import jvav.ListNode
import jvav.Solution234

/**
 * @author created by linjunhao
 * @date 2020/6/9
 * @description LeetCode 算法题第 876 题：链表的中间节点
 * tag：链表
 * difficulty：easy
 */
class Solution876 {

    /**
     * 解法1
     * 快慢指针
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    fun middleNode1(head: ListNode?): ListNode? {
        var slow = head;
        var fast = head;
        while (slow?.next != null && fast?.next?.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast?.next != null) {
            slow = slow?.next;
        }
        return slow;
    }

    /**
     * 解法2
     * 单指针
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    fun middleNode2(head: ListNode?): ListNode? {
        var curr = head;
        var count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        curr = head;
        for (i in 1..count / 2) {
            curr = curr?.next;
        }
        return curr;
    }
}
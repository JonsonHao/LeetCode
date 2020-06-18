package kotlincode

import jvav.ListNode

/**
 * @author created by linjunhao
 * @date 2020/6/11
 * @description LeetCode 算法题第 2 题：Add To Numbers
 * tag：Linked List
 * difficulty：medium
 */
class Solution2 {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val sentinel = ListNode(0)
        var node = sentinel;
        var c1 = l1
        var c2 = l2
        var sum = 0
        while (c1 != null || c2 != null) {
            sum /= 10
            if (c1 != null) {
                sum += c1.`val`
                c1 = c1.next
            }
            if (c2 != null) {
                sum += c2.`val`
                c2 = c2.next
            }
            node.next = ListNode(sum % 10)
            node = node.next
        }
        if (sum > 9) {
            node.next = ListNode(sum / 10)
        }
        return sentinel.next
    }
}
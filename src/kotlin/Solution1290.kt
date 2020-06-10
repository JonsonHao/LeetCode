package kotlin

import jvav.ListNode




/**
 * @author created by linjunhao
 * @date 2020/6/9
 * @description LeetCode 算法题第 1290 题：二进制链表转整数
 * tag：链表
 * difficulty：easy
 */
class Solution1290 {

    /**
     * 解法1
     * 访问下一节点时顺便左移一位
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    fun getDecimalValue1(head: ListNode?): Int {
        var curr = head
        var count = 0;
        while (curr != null) {
            count *= 2
            count += curr.`val`
            curr = curr.next
        }
        return count
    }

}
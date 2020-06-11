package kotlin

import jvav.ListNode

class Solution1290 {

    fun getDecimalValue(head: ListNode?): Int {
        var curr = head
        var prev: ListNode? = null
        while (curr != null) {
            val nextNode = curr.next
            curr.next = prev
            prev = curr
            curr = nextNode
        }
        var len = 0
        var result = 0
        while (prev != null) {
            if (prev.`val` == 1) {
                result += Math.pow(2.toDouble(), len.toDouble()).toInt()
            }
            len++
            prev = prev.next;
        }
        return result
    }
}
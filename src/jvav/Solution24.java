package jvav;

/**
 * @author created by linjunhao
 * @date 2020/6/17
 * @description: 24. 两两节点交换
 */
public class Solution24 {

    /**
     * 解法1：遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

    /**
     * 解法2：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }
}

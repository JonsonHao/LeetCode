package jvav;

/**
 * @author created by linjunhao
 * @date 2020/6/17
 * @description: 19. Remove Nth Node From End of List
 * tag: LinkList
 * difficulty: medium
 */
public class Solution19 {

    /**
     * 解法1：遍历两遍
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        ListNode sentinel = new ListNode(0);
        curr = sentinel;
        sentinel.next = head;
        for (int i = -1; i < count; i++) {
            if (i == count - n - 1) {
                curr.next = curr.next.next;
                break;
            } else {
                curr = curr.next;
            }
        }
        return sentinel.next;
    }

    /**
     * 解法2：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        sentinel.next = head;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sentinel.next;
    }
}


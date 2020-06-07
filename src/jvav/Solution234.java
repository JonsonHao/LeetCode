package jvav;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by linjunhao
 * @date 2020/6/4
 * @description: LeetCode 算法题第 234 题: 回文链表
 * tag： 链表
 * difficulty: easy
 */
public class Solution234 {

    public Solution234() {
    }

    /**
     * 解法1
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        List<Integer> elements = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            elements.add(currentNode.val);
            currentNode = currentNode.next;
        }
        for (int i = 0, j = elements.size() - 1; i < j; i++, j--) {
            if (!elements.get(i).equals(elements.get(j))) {
                return false;
            }
        }
        return true;
    }

    private ListNode frontPoint;

    /**
     * 解法2
     * 递归
     * 时间复杂度和空间复杂度都为 O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        frontPoint = head;
        return recursivelyCheck(head);
    }

    public boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (frontPoint.val != currentNode.val) return false;
            frontPoint = frontPoint.next;
        }
        return true;
    }

    /**
     * 解法3
     * 翻转链表法
     * 时间复杂度: O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        ListNode firstHalfNode = findFirstHalf(head);
        ListNode secondHalfHead = reverseSecondHalf(firstHalfNode.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverseSecondHalf(secondHalfHead);
        return result;
    }

    private ListNode reverseSecondHalf(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private ListNode findFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        ListNode head = new ListNode(10);
        System.out.println(solution234.isPalindrome2(head));
    }
}

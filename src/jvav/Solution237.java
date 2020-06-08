package jvav;

/**
 * @author created by linjunhao
 * @date 2020/6/8
 * @description LeetCode 算法题第 237 题：删除链表中的节点
 * tag：链表
 * difficulty：easy
 */
public class Solution237 {

    /**
     * 解法1
     * 移动节点后面的数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param node
     */
    public void deleteNode1(ListNode node) {
        ListNode currNode = node;
        while (currNode.next != null) {
            currNode.val = currNode.next.val;
            if (currNode.next.next == null) {
                currNode.next = null;
                break;
            }
            currNode = currNode.next;
        }
    }

    /**
     * 解法2
     * 把下一节点的值赋值给要删除的节点然后改变要删除节点的指向
     * 时间复杂度和空间复杂度都为：O(1)
     * @param node
     */
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

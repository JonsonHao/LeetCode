package jvav;

/**
 * @author created by linjunhao
 * @date 2020/9/21
 * @description LeetCode 算法题第 538 题：把二叉树转换成累加树
 * @tag：链表
 * @difficulty：easy
 */
public class Solution538 {

    int sum = 0;

    /**
     * 解法一：反序中序遍历
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     * @param root
     * @return
     */
    public TreeNode convertBST1(TreeNode root) {
        if (root != null) {
            convertBST1(root.right);
            sum += root.val;
            root.val = sum;
            convertBST1(root.left);
        }
        return root;
    }
}

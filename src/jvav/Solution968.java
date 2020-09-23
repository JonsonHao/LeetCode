package jvav;

/**
 * @author created by linjunhao
 * @date 2020/9/22
 * @description LeetCode 算法题第 968 题
 * @tag：链表
 * @difficulty：easy
 */
public class Solution968 {

    public int minCameraCover(TreeNode root) {
        if (lrd(root) == 0) {
            res ++;
        }
        return res;
    }

    int res = 0;

    int lrd(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int left = lrd(node.left);
        int right = lrd(node.right);
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        if (left == 1 && right == 1) {
            return 0;
        }
        if (left + right >= 3) {
            return 1;
        }
        return -1;
    }

}

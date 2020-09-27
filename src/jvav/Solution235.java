package jvav;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author created by linjunhao
 * @date 2020/9/27
 * @description LeetCode 算法题第 235 题: 二叉搜索树的最近公共祖先
 * tag： 二叉树
 * difficulty: easy
 */
public class Solution235 {
    
    /**
     * 解法一：一次遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while (true) {
            if (result.val > p.val && result.val > q.val) {
                result = result.left;
            } else if (result.val < p.val && result.val < q.val) {
                result = result.right;
            } else {
                break;
            }
        }
        return result;
    }

}

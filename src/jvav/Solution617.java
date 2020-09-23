package jvav;

/**
 * @author created by linjunhao
 * @date 2020/9/23
 * @description LeetCode 算法题第 617 题：合并二叉树
 * @tag：二叉树
 * @difficulty：easy
 */
public class Solution617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        } else if (t1 != null) {
            return t1;
        } else {
            return t2;
        }
        /*if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;*/
    }

}

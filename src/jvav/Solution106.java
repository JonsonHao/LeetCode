package jvav;

import java.util.HashMap;
import java.util.Map;

/**
 * @author created by linjunhao
 * @date 2020/9/25
 * @description LeetCode 算法题第 106 题：从中序与后序遍历序列构造二叉树
 * tag：二叉树
 * difficulty：medium
 */
public class Solution106 {

    /**
     * 解法一：递归
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    int postIdx;
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode helper(int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }
        int rootValue = postorder[postIdx];
        TreeNode root = new TreeNode(rootValue);
        // 获取根节点在中序遍历中的下标
        int rootIdx = idxMap.get(rootValue);
        postIdx--;
        // 根据中序和后序的特性，必须先遍历右子树
        root.right = helper(rootIdx + 1, endIdx);
        root.left = helper(startIdx, rootIdx - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return helper(0, postIdx);
    }

}

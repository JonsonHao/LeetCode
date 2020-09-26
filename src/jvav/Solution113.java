package jvav;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author created by linjunhao
 * @date 2020/9/26
 * @description LeetCode 算法题第 113 题：路径总和 II
 * tag：二叉树
 * difficulty：中等
 */
public class Solution113 {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> paths = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathTree(root, sum);
        return result;
    }

    public void pathTree(TreeNode node, int sum) {
        if (node == null) return;
        sum -= node.val;
        paths.add(node.val);
        if (node.left == null && node.right == null && sum == 0) result.add(new ArrayList<>(paths));
        pathTree(node.left, sum);
        pathTree(node.right, sum);
        paths.pollLast();
    }
}

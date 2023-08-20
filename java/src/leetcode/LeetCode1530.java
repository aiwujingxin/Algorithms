package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/11 18:05
 */
public class LeetCode1530 {
    int total = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return total;
    }


    //求node子树下所有叶子节点到node的距离。
    // 后序遍历，方便返回距离
    public List<Integer> dfs(TreeNode node, int distance) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        if (node.left == null && node.right == null) {
            //当前子树下找到一个，距离自己为1的叶子节点
            result.add(0);
            return result;
        }

        List<Integer> leftLeaf = dfs(node.left, distance);
        List<Integer> rightLeaf = dfs(node.right, distance);

        for (int i : leftLeaf) {
            if (i + 1 >= distance) {
                continue;
            }
            //更新result子树下，所有叶子节点到Node的距离
            result.add(i + 1);
        }

        for (int i : rightLeaf) {
            if (i + 1 >= distance) {
                continue;
            }
            //更新result子树下，所有叶子节点到Node的距离
            result.add(i + 1);
        }

        for (int i : leftLeaf) {
            for (int j : rightLeaf) {
                if (i + j + 2 <= distance) {
                    total++;
                }
            }
        }
        return result;
    }
}

package leetcode;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 21:57
 */
public class LeetCode2196 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        // 存储所有的子节点
        Set<Integer> children = new HashSet<>();

        Map<Integer, TreeNode> map = new HashMap<>();
        // 构造树
        for (int[] d : descriptions) {
            int pVal = d[0], cVal = d[1];
            TreeNode pNode = map.get(pVal);
            if (pNode == null) {
                pNode = new TreeNode(pVal);
                map.put(pVal, pNode);
            }

            TreeNode cNode = map.get(cVal);
            if (cNode == null) {
                cNode = new TreeNode(cVal);
                map.put(cVal, cNode);
            }

            children.add(cVal);

            if (d[2] == 1) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }
        }

        for (int v : map.keySet()) {
            if (!children.contains(v)) {
                return map.get(v);
            }
        }
        return null;
    }
}

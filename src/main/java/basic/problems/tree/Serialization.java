package basic.problems.tree;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:42
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">...</a>
 */
public interface Serialization {

    TreeNode deserialize(String data);

    String serialize(TreeNode root);
}

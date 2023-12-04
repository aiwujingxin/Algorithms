package basic.datastructure.tree;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:42
 * @see leetcode.problems.LeetCode297
 * @see leetcode.problems.LeetCode449
 */
public interface Serialization {

    TreeNode deserialize(String data);

    String serialize(TreeNode root);
}

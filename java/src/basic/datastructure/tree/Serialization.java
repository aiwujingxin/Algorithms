package basic.datastructure.tree;

import common.*;
import leetcode.problems.LeetCode297;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:42
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">...</a>
 * @see LeetCode297
 */
public interface Serialization {

    String NULL = "null";
    String COMMA = ",";

    TreeNode deserialize(String data);

    String serialize(TreeNode root);
}

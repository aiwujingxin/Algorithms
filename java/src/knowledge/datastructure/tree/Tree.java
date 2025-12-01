package knowledge.datastructure.tree;

import common.TreeNode;
import leetcode.lists.lcr.LCR143;
import leetcode.problems.*;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:22
 * @description 树
 * <遍历>
 * @see LeetCode144     前序遍历
 * @see LeetCode94      中序遍历
 * @see LeetCode145     后序遍历
 * @see LeetCode102     层序遍历
 * @see LeetCode107     层序遍历II
 * @see LeetCode538     把二叉搜索树转换为累加树
 * <基本>
 * @see LeetCode104     二叉树的深度
 * @see LeetCode222     完全二叉树的节点个数
 * @see LeetCode543     二叉树的直径
 * @see LeetCode563     二叉树的坡度
 * @see LeetCode662     二叉树最大宽度
 * <构造>
 * @see LeetCode105     从前序与中序遍历序列构造二叉树
 * @see LeetCode106     从中序与后序遍历序列构造二叉树
 * @see LeetCode889     根据前序和后序遍历构造二叉树
 * @see LeetCode109     有序链表转换二叉搜索树
 * <序列化>
 * @see LeetCode297     二叉树的序列化与反序列化
 * @see LeetCode449     序列化和反序列化二叉搜索树
 * <验证>
 * @see LeetCode98      验证二叉搜索树
 * @see LeetCode101     对称二叉树
 * @see LeetCode110     平衡二叉树
 * @see LeetCode1609    奇偶树
 * @see LeetCode331     验证二叉树的前序序列化
 * <LCA>
 * @see LeetCode235     二叉搜索树的最近公共祖先
 * @see LeetCode236     二叉树的最近公共祖先
 * @see LeetCode1123    最深叶节点的最近公共祖先
 * <子树>
 * @see LeetCode572     另一棵树的子树
 * @see LCR143          子结构判断
 * @see LeetCode652     寻找重复的子树
 */
public interface Tree {

    interface DFS {
        List<Integer> dfs(TreeNode root);
    }

    interface Iteration {
        List<Integer> iteration(TreeNode root);
    }

    interface Serialize {
        TreeNode deserialize(String data);

        String serialize(TreeNode root);
    }
}

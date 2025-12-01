package knowledge.algorithms.search.backtrack;

import knowledge.algorithms.search.backtrack.problems.Loading;
import knowledge.algorithms.search.backtrack.problems.Scheduling;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/21 22:08
 * @description 回溯算法
 * <本质>
 * 回溯是一个「系统性地遍历所有可能解」的搜索过程，本质是「在决策树上进行深度优先遍历（DFS），并在路径非法或不再有希望时及时回退」.
 * <核心>
 * 决策树:        回溯的所有选择过程可以抽象成一棵决策树。每个节点代表一个状态，每条边代表一个选择，整棵树覆盖了所有可能的路径（解）。
 * 路径+选择列表:  回溯时，我们构建当前路径（已做出的选择）并面临当前的选择列表（可做的选择），然后从中递归地探索下去。
 * 终止条件:      每次递归都判断是否达到终点（路径构造完成、满足约束等），这是回溯的“叶子判断”。
 * 剪枝优化:      如果当前路径不满足条件、或者往后也不可能满足（如当前和已超目标），可以提前终止该路径探索，称为剪枝。
 * 回退机制:      每次尝试后，都要「撤销选择」返回上一层。这就是“回溯”两个字的由来——探索 → 失败 → 回退 → 尝试其他路径。
 * @link <a href="https://cloud.tencent.com/developer/article/1968964?policyId=1004">排列组合</a>
 * @link <a href="https://cloud.tencent.com/developer/article/2407142?policyId=1004">球盒模型</a>
 * <例题>
 * @see Loading
 * @see Scheduling
 * <排列>
 * @see LeetCode46      元素无重不可复选
 * @see LeetCode47      元素重复不可复选
 * @see LeetCode526     优美的排列
 * <子集>
 * @see LeetCode78      元素无重不可复选
 * @see LeetCode90      元素重复不可复选
 * @see LeetCode473     火柴拼正方形
 * * <子集组合>
 * @see LeetCode77      元素无重不可复选
 * @see LeetCode40      元素重复不可复选
 * @see LeetCode39      元素无重可复选
 * <球盒模型>
 * @see LeetCode698_bk  划分为k个相等的子集
 * @see LeetCode1723    完成所有工作的最短时间
 * @see LeetCode473     火柴拼正方形
 * <所有解>
 * @see LeetCode17      电话号码的字母组合
 * @see LeetCode22      括号生成
 * @see LeetCode93      ip地址
 * @see LeetCode51      N皇后
 * @see LeetCode52      N皇后II
 * @see LeetCode126     单词接龙II
 * @see LeetCode131     分割回文串
 * @see LeetCode140     单词拆分II
 * @see LeetCode212     单词搜索II
 * @see LeetCode254     因子的组合
 * @see LeetCode491     非递减子序列
 * @see LeetCode282     给表达式添加运算符
 * @see LeetCode113     路径总和II
 * @see LeetCode401     二进制手表
 * @see LeetCode1219    黄金矿工
 * @see LeetCode638     大礼包
 * @see LeetCode980     不同路径 III
 * <唯一解> 在回溯函数中返回布尔值，一旦找到有效序列即提前终止搜索
 * @see LeetCode37      数独
 * @see LeetCode79      单词搜索
 * @see LeetCode306     累加数
 * @see LeetCode473     火柴拼正方形
 * @see LeetCode2375    根据模式串构造最小数字
 * <回溯求最优解>
 * @see LeetCode1239
 * <剪枝>
 * @see LeetCode996_bk  平方数组的数目
 * @see LeetCode2048    下一个更大的数值平衡数
 */
public interface Backtrack {
    /*
    所有解：维护「路径」和「选择列表」，遇合法解即加入结果集
    default void backtrack(选择列表, 路径, 结果集) {
        if (满足合法解条件) {
            res.add(new ArrayList<>(path)); // ← 合法解诞生！
            return;
        }

        for (选择 : 选择列表) {
            做选择
            backtrack(选择列表, 路径, 结果集);
            撤销选择
        }
    }

    唯一解：找到第一个合法解即可返回
    public boolean backtrack(状态参数...) {
        if (到达终点条件) {
            return 满足合法条件;
        }
        for (选择 : 可选列表) {
            做选择
            if (backtrack(...)) return true; // ← 找到合法解直接返回
            撤销选择
        }
        return false; // 所有分支都失败
    }

    终止条件:
    1. 所有元素选完（排列 / 组合 / 子集）  if (path.size() == n) { ... }
    2. 达到目标和（如 LeetCode39/40/216）if (sum == target) { ... }
    3. 字符串构造完成（如 LeetCode93/306）if (index == word.length()) { ... }
    4. 走到二维数组终点（如迷宫、路径类问题）if (i == m && j == n) { ... }
    5. 到达树的叶子节点（如路径总和等）     if (node.left == null && node.right == null) { ... }
    6. 可选元素用尽（如组合/子集问题）      if (start == nums.length) { ... }
    7. 找到合法解就返回（用于唯一解）       if (满足条件) return true;
    8. 所有任务完成（如分组/划分问题）      if (任务分配完毕) { ... }
    */
}

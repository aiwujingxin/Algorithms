package knowledge.algorithms.backtrack;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/21 22:08
 * @description 回溯算法
 * @link <a href="https://labuladong.github.io/algo/di-san-zha-24031/bao-li-sou-96f79/hui-su-sua-56e11/">labuladong</a>
 * <排列>
 * @see LeetCode46 元素无重不可复选
 * @see LeetCode47 元素重复不可复选
 * <组合>
 * @see LeetCode77 元素无重不可复选
 * @see LeetCode40 元素重复不可复选
 * @see LeetCode39 元素无重可复选
 * <子集>
 * @see LeetCode78 元素无重不可复选
 * @see LeetCode90 元素重复不可复选
 * <N皇后>
 * @see LeetCode51
 * @see LeetCode52
 * <数独>
 * @see LeetCode37
 * <剪枝>
 * @see LeetCode254
 * @see LeetCode491
 * @see LeetCode1723
 * <回溯构建结果>
 * @see LeetCode126 单词接龙II
 * @see LeetCode131 分割回文串
 * @see LeetCode140 单词拆分II
 */
public interface Backtrack {
    /*
    需要维护走过的「路径」和当前可以做的「选择列表」，当触发结束条件时，将路径记入结果集
    * def backtrack(...):
        for 选择 in 选择列表:
            做选择
            backtrack(...)
            撤销选择
    * */
}

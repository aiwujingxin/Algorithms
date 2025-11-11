package knowledge.mathematics;

import leetcode.problems.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:16
 * @description 组合数学
 * <排列序列>
 * @see LeetCode46      全排列
 * @see LeetCode47      全排列 II（含重复元素）
 * @see LeetCode60      第k个排列
 * @see LeetCode77      组合
 * @see LeetCode78      子集
 * @see LeetCode90      子集 II（含重复元素）
 * @see LeetCode357     计数数字序列（无重复）
 * @see LeetCode1359    有效的快递序列数目
 * <多重集组合 / 重复选择>
 * @see LeetCode39      组合总和
 * @see LeetCode40      组合总和 II
 * <分组划分>
 * @see LeetCode526     美丽排列
 * @see LeetCode894     所有可能的满二叉树
 * <排列计数中的约束>
 * @see LeetCode996     方形数组数量
 * @see LeetCode1155    骰子点数总和的数量
 * <概率相关 / 随机>
 * @see LeetCode470     Rand10() 使用 Rand7()
 * <卡塔兰数>
 * @see LeetCode96      不同的二叉搜索树
 * <贡献计数法>
 * // 出现在多少个子串里？ (i + 1) * (n - i)
 * @see LeetCode2063    所有子字符串中的元音
 * @see LeetCode1180    统计只含单一字母的子串
 * @see LeetCode828     统计子串中的唯一字符
 * @see LeetCode1915    最美子字符串的数目
 * @see LeetCode2348    全 0 子数组的数目
 */

public interface Combinatorics {

    /*
     * 普通贡献：直接 (i+1)*(n-i)
     * 唯一元素/字符：前后最近相同元素 → (i-prev[i])*(next[i]-i)
     * 状态压缩/前缀组合：count[mask] 累加 → 子串满足条件数
     * 连续段：长度 k → k*(k+1)/2
     * 最终累加：long 类型防溢出
     * */
    default long contributionTemplate(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Map<Integer, Integer> lastIndex = new HashMap<>();

        // 计算 prev
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            prev[i] = lastIndex.getOrDefault(x, -1);
            lastIndex.put(x, i);
        }

        lastIndex.clear();
        // 计算 next
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            next[i] = lastIndex.getOrDefault(x, n);
            lastIndex.put(x, i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (i - prev[i]) * (next[i] - i);
        }
        return ans;
    }
}

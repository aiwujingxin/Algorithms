package knowledge.dp.intervaldp;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 23:00
 * @description 区间DP
 * @see LeetCode5 最长回文子串
 * @see LeetCode516 最长回文子序列
 * @see LeetCode1312 让字符串成为回文串的最少插入次数
 * <p>
 * @see LeetCode1039 多边形三角剖分的最低得分
 * <p>
 * @see AcWing282 石子合并 相邻2堆
 * @see LeetCode1000 石子合并 相邻k堆
 * <p>
 * @see LeetCode312 戳气球
 * @see LeetCode546 移除盒子
 * @see LeetCode87 扰乱字符
 * @see LeetCode486
 * @see LeetCode647 回文子串
 * @see LeetCode678 有效的括号字符串
 * @see LeetCode1216
 * LeetCode1547
 * LeetCode1690
 * LeetCode2312
 * LeetCode1130
 * LeetCode730 统计不同回文子序列
 * LeetCode664
 * LeetCode1147 段式回文
 * LeetCode471
 * POJ3280
 */
public interface Problems {

    // 迭代式
    private void interval(int n) {
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
            }
        }
    }
}

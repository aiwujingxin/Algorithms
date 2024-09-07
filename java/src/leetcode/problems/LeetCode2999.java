package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/9/7 01:05
 * <a href="https://www.bilibili.com/video/BV1Fg4y1Q7wv/?spm_id_from=333.337.search-card.all.click&vd_source=88e5a3e60377510439e11f13b5878c25">...</a>
 */
public class LeetCode2999 {

    long[] memo;
    char[] chars;
    char[] low;
    char[] high;
    int limit;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = "0".repeat(n - low.length()) + low; // 补前导零，和 high 对齐
        this.memo = new long[n];
        this.chars = s.toCharArray();
        this.low = low.toCharArray();
        this.high = high.toCharArray();
        this.limit = limit;
        Arrays.fill(memo, -1);
        return dfs(0, true, true);
    }

    private long dfs(int i, boolean limitLow, boolean limitHigh) {
        if (i == high.length) {
            return 1;
        }
        if (!limitLow && !limitHigh && memo[i] != -1) {
            return memo[i];
        }

        // 第 i 个数位可以从 lo 枚举到 hi
        int lo = limitLow ? low[i] - '0' : 0;
        int hi = limitHigh ? high[i] - '0' : 9;
//        hi = Math.min(hi, limit);错误: 如果对数位还有其它约束 ，应当只在下面的 for 循环做限制，不应修改 lo 或 hi

        long res = 0;
        if (i < high.length - chars.length) { // 枚举这个数位填什么 随便写
            for (int d = lo; d <= Math.min(hi, limit); d++) {
                res += dfs(i + 1, limitLow && d == lo, limitHigh && d == hi);
            }
        } else { // 这个数位只能填后缀 s[i-diff]
            int x = chars[i - (high.length - chars.length)] - '0';
            if (lo <= x && x <= Math.min(hi, limit)) {
                res = dfs(i + 1, limitLow && x == lo, limitHigh && x == hi);
            }
        }
        if (!limitLow && !limitHigh) {
            memo[i] = res; // 记忆化 (i,false,false)
        }
        return res;
    }
}

package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:06
 */
public class LeetCode2086 {

    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        char[] s = hamsters.toCharArray();
        int buckets = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'H') {
                if (i < n - 1 && s[i + 1] == '.') {     // 优先在右边放桶（可以覆盖下一个仓鼠）
                    buckets++;
                    i += 2;                             // 跳过下一个位置
                } else if (i > 0 && s[i - 1] == '.') {  // 右边不能放，就在左边放
                    buckets++;
                } else {                                // 两边都不能放桶
                    return -1;
                }
            }
        }

        return buckets;
    }
}

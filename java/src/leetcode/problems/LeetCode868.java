package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 17:19
 */
public class LeetCode868 {
    public int binaryGap(int n) {
        int max = 0;
        // 找到第一个1
        n >>>= Integer.numberOfTrailingZeros(n);
        while (n > 1) { // n > 1 确保至少还有一对1
            // 计算当前1到下一个1的距离
            int gap = Integer.numberOfTrailingZeros(n >>> 1) + 1;
            max = Math.max(max, gap);
            // 移动到下一个1
            n >>>= gap;
        }
        return max;
    }
}

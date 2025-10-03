package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 00:38
 */
public class LeetCode1024 {

    public int videoStitching(int[][] clips, int T) {
        // 按区间起点排序
        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;       // 用了多少个区间
        int end = 0;         // 当前覆盖到的位置
        int farthest = 0;    // 在遍历区间中能覆盖的最远位置
        int i = 0;
        int n = clips.length;
        // 只要当前覆盖不到目标，就继续选区间扩展
        while (end < T) {
            // 寻找所有起点 <= end 的区间，选能覆盖最远右端的
            while (i < n && clips[i][0] <= end) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }
            // 如果覆盖范围没扩大，说明断档，无法覆盖完整目标区间
            if (farthest == end) {
                return -1;
            }
            // 选择这个区间，增加计数，更新当前覆盖到的位置
            count++;
            end = farthest;
        }
        return count;
    }
}

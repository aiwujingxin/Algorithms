package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/3 16:18
 */
public class LeetCode435_dp {

    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - activityPack(intervals);
    }

    public int activityPack(int[][] activities) {
        // 先按照结束时间对活动进行排序
        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));
        int n = activities.length;
        int[] dp = new int[n]; // 存储每个活动的最大兼容活动数
        // 第一个活动的最大兼容活动数为1
        dp[0] = 1;
        // 从第二个活动开始计算
        for (int i = 1; i < n; i++) {
            // 找到第i个活动之前的最后一个兼容活动
            int lastCompatible = rightBound(activities, i);
            // 计算dp[i]
            dp[i] = Math.max(dp[i - 1], 1 + (lastCompatible == -1 ? 0 : dp[lastCompatible]));
        }
        // 返回最后一个活动的最大兼容活动数
        return dp[n - 1];
    }

    // 在已排序的活动数组中找到最后一个与第i个活动兼容的活动
    private int rightBound(int[][] activities, int i) {
        int left = 0;
        int right = i;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (activities[mid][1] > activities[i][0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (activities[left][1] > activities[i][0]) {
            return -1;
        }
        return left;
    }
}

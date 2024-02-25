package knowledge.dp.linerdp.impl;


import knowledge.dp.linerdp.ActivityPack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 11:31
 */
public class ActivityPack_dp implements ActivityPack {

    @Override
    public int activityPack(int[][] intervals) {
        // 先按照结束时间对活动进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int n = intervals.length;
        int[] dp = new int[n]; // 存储每个活动的最大兼容活动数
        // 第一个活动的最大兼容活动数为1
        dp[0] = 1;
        // 从第二个活动开始计算
        for (int i = 1; i < n; i++) {
            // 找到第i个活动之前的最后一个兼容活动
            int lastCompatible = rightBound(intervals, i);
            // 计算dp[i]
            dp[i] = Math.max(dp[i - 1], 1 + (lastCompatible == -1 ? 0 : dp[lastCompatible]));
        }
        // 返回最后一个活动的最大兼容活动数
        return dp[n - 1];
    }

    // 在已排序的活动数组中找到最后一个与第i个活动兼容的活动
    private static int rightBound(int[][] activities, int i) {
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

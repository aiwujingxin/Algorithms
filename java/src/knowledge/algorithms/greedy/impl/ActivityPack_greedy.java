package knowledge.algorithms.greedy.impl;


import knowledge.dp.linerdp.ActivityPack;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 11:21
 */
public class ActivityPack_greedy implements ActivityPack {

    public int activityPack(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int cnt = 1;
        int[] end = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] >= end[1]) {
                end = interval;
                cnt++;
            }
        }
        return cnt;
    }
}

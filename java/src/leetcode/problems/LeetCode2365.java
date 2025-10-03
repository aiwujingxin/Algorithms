package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:06
 */
public class LeetCode2365 {
    public long taskSchedulerII(int[] tasks, int space) {
        long curDay = 0;
        int index = 0;
        int n = tasks.length;
        HashMap<Integer, Long> map = new HashMap<>();
        while (index < n) {
            int taskType = tasks[index];
            if (!map.containsKey(taskType) || curDay - map.get(taskType) > space) {
                map.put(taskType, curDay);
                index++;
                curDay++;
            } else {
                curDay = map.get(taskType) + space + 1;
            }
        }
        return curDay;
    }
}

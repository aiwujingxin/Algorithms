package leetcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/14 14:58
 */
public class LeetCode539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >= 1440) {
            return 0;
        }
        int[] array = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            array[i] = minute(timePoints.get(i));
        }
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i] - array[i - 1]);
            if (min == 0) {
                return 0;
            }
        }
        return Math.min(min, 1440 + array[0] - array[array.length - 1]);
    }

    public int minute(String s) {
        return s.charAt(0) * 600 + s.charAt(1) * 60 + s.charAt(3) * 10 + s.charAt(4);
    }
}

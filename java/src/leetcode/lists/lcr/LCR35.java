package leetcode.lists.lcr;

import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 21:15
 */
public class LCR35 {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >= 1440) {
            return 0;
        }
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            arr[i] = minute(timePoints.get(i));
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            res = Math.min(arr[i] - arr[i - 1], res);
        }
        return Math.min(res, 1440 - Math.abs(arr[arr.length - 1] - arr[0]));
    }

    private int minute(String s) {
        String[] str = s.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}

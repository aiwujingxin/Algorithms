package leetcode.plan.binarysearch.level2;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/11/1 02:20
 */
public class LeetCode658_win {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int idx = 0;
        while (right < n) {
            sum += Math.abs(arr[right] - x);
            if (right - left + 1 == k) {
                if (sum < res) {
                    res = sum;
                    idx = left;
                }
                sum -= Math.abs(arr[left] - x);
                left++;
            }
            right++;
        }

        for (int i = idx; i < idx + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}

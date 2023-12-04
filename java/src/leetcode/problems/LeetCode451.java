package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 15:25
 */
public class LeetCode451 {

    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - '0']++;
        }
        int[][] nums = new int[256][];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = new int[]{arr[i], i};
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(nums));
        StringBuilder sb = new StringBuilder();
        for (int[] num : nums) {
            for (int j = 0; j < num[0]; j++) {
                sb.append((char) ('0' + num[1]));
            }
        }
        return sb.toString();
    }
}

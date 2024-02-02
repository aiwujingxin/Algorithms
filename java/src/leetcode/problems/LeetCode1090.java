package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/2 11:05
 */
public class LeetCode1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{values[i], labels[i]};
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : arr) {
            if (map.getOrDefault(ints[1], 0) >= useLimit) {
                continue;
            }
            if (count >= numWanted) {
                break;
            }
            map.put(ints[1], map.getOrDefault(ints[1], 0) + 1);
            sum += ints[0];
            count++;
        }
        return sum;
    }
}

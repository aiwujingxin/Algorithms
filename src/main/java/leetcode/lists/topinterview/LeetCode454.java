package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 22:47
 */
public class LeetCode454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length, result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int k : A) {
            for (int j = 0; j < n; j++) {
                int sum = k + B[j];
                if (map.containsKey(-sum)) {
                    result += map.get(-sum);
                }
            }
        }
        return result;
    }
}

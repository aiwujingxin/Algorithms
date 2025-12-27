package leetcode.problems;

import knowledge.datastructure.adv.UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 12/22/25 15:07
 */
public class LeetCode3551 {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Map<Integer, Integer> valueToTargetIdx = new HashMap<>();
        for (int i = 0; i < n; i++)
            valueToTargetIdx.put(arr[i][1], i);

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int targetIdx = valueToTargetIdx.get(nums[i]);
            uf.union(i, targetIdx);
        }
        // 连通块数
        int blocks = uf.getCount();
        return n - blocks;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int cal(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

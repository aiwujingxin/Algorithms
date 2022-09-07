package leetcode.problems;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/18 22:54
 */
public class LeetCode327_BinaryIndexedTree_v2 {

    int bitLen;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long sum = 0;
        int ans = 0;
        long[] pre = new long[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        Arrays.sort(pre);
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(pre[i], i + 1);
        }
        bitLen = n + 1;
        int[] bit = new int[bitLen];
        for (int num : nums) {
            sum += num;
            if (sum >= lower && sum <= upper) {
                ans++;
            }
            int left = 0, right = 0;
            if (map.floorKey(sum - lower) != null) {
                int key = map.floorEntry(sum - lower).getValue();
                right = query(bit, key);
            }
            if (map.floorKey(sum - upper - 1) != null) {
                int key = map.floorEntry(sum - upper - 1).getValue();
                left = query(bit, key);
            }
            ans += (right - left);
            insert(bit, map.get(sum));
        }
        return ans;
    }

    private void insert(int[] bit, int index) {
        while (index < bitLen) {
            bit[index]++;
            index = index + (index & -index);
        }
    }

    private int query(int[] bit, int index) {
        int ans = 0;
        while (index > 0) {
            ans += bit[index];
            index = index - (index & -index);
        }
        return ans;
    }
}

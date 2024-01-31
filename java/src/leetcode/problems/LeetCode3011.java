package leetcode.problems;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 13:49
 */
public class LeetCode3011 {

    public boolean canSortArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], cal(nums[i]));
        }

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1] && Objects.equals(map.get(nums[j]), map.get(nums[j + 1]))) {
                    swap(nums, j, j + 1);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private Integer cal(int num) {
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num -= num & -num;
        }
        return cnt;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

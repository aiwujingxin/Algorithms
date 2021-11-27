package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-14 1:20 下午
 */
public class LeetCode15 {

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(leetCode15.threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int cur = nums[i];
            while (left < right) {
                if (cur + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[i]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (cur + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }

            }

        }
        return res;
    }
}

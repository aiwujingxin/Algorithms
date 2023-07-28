package leetcode.lists.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 20:24
 */
public class LeetCode15 {

    //[-1,-1,0,1]
    //[0,1,1]
    //[0,0,0]

    public static void main(String[] args) {
        System.out.println(new LeetCode15().threeSum(new int[]{-1, -1, 0, 1}));
        System.out.println(new LeetCode15().threeSum(new int[]{0, 1, 1}));
        System.out.println(new LeetCode15().threeSum(new int[]{0, 0, 0}));
        System.out.println(new LeetCode15().threeSum(new int[]{0, 0, 0, 0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i >= 1 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                List<Integer> temp = new ArrayList<>();
                if (nums[left] + nums[right] + nums[i] == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    list.add(temp);
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}

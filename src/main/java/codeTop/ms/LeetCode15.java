package codeTop.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-17 12:35 PM
 */
public class LeetCode15 {

    public static void main(String[] args) {
        System.out.println(new LeetCode15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //fix
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);

                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    //fix
                    left++;
                    right--;

                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;

    }
}

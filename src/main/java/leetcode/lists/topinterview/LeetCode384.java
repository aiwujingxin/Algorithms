package leetcode.lists.topinterview;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/30 02:37
 */
public class LeetCode384 {

    class Solution {

        int[] origin;
        int[] arr;

        Random r = new Random();

        public Solution(int[] nums) {
            //fix
            origin = Arrays.copyOf(nums, nums.length);
            arr = nums;
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            for (int i = 0; i < arr.length; i++) {
                //copy
                int index = r.nextInt(arr.length - i);
                int select = arr[index];
                int t = arr[i];
                arr[i] = select;
                arr[index] = t;
            }
            return arr;
        }
    }
}

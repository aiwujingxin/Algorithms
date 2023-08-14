package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/30 18:04
 */
public class LeetCode379 {
    class PhoneDirectory {

        int[] nums;
        boolean[] used;
        int k;
        int max;

        public PhoneDirectory(int maxNumbers) {
            nums = new int[maxNumbers];
            for (int i = 0; i < maxNumbers; i++) {
                nums[i] = i;
            }
            used = new boolean[maxNumbers];
            Arrays.fill(used, true);
            max = maxNumbers;
        }

        public int get() {
            if (k == max) {
                return -1;
            }
            int res = nums[k++];
            used[res] = false;
            return res;
        }

        public boolean check(int number) {
            return used[number];
        }

        public void release(int number) {
            if (!used[number]) {
                k--;
                used[number] = true;
                nums[k] = number;
            }
        }
    }

}

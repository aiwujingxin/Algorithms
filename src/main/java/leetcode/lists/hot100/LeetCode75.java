package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 20:55
 */
public class LeetCode75 {
    //0,0 ,1,1,2,2

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
            if (num == 1) {
                one++;
            }
            if (num == 2) {
                two++;
            }
        }
        int b = zero;
        int c = zero + one;
        for (int i = 0; i < zero; i++) {
            nums[zero++] = 0;
        }
        for (int i = 0; i < one; i++) {
            nums[b++] = 1;
        }
        for (int i = 0; i < two; i++) {
            nums[c++] = 2;
        }
    }
}

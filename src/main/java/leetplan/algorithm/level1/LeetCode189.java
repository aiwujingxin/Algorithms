package leetplan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 18:25
 */
public class LeetCode189 {


    //1,2,3,4,5,6,7,8,9,10     2
    //9,10,1,2,3,4,5,6,7,8    2
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}

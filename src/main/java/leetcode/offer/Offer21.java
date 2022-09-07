package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 6:05 下午
 */
public class Offer21 {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            //x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性。
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

}

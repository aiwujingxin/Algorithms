package leetplan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 19:30
 */
public class LeetCode1608 {

    //0,0,3,4,4

    //https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/discuss/2678324/Java-Binary-Search!-EASY-100-faster!
    public int specialArray(int[] nums) {
        int high = nums.length;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }
            if (count == mid) {
                return mid;
            }
            if (count > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

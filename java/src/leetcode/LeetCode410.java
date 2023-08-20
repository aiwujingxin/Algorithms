package leetcode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/21 23:01
 */
public class LeetCode410 {

    //https://leetcode.com/problems/split-array-largest-sum/discuss/1899033/Java-oror-simple-and-easy-solution-oror-beats-100

    //https://www.youtube.com/watch?v=Ksmmhee4lYE&t=272s


    int[] nums;

    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        int low = 0, high = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (required_no_of_chunks(mid, m)) {
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }

    private boolean required_no_of_chunks(int mid, int m) {
        int chunks = 0, i = 0;
        while (i < nums.length) {
            int val = 0;
            while (i < nums.length && nums[i] + val <= mid) {
                val += nums[i++];
            }
            chunks++;
        }
        return chunks <= m;
    }
}

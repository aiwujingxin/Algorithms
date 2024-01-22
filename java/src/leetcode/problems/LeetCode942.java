package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 15:13
 */
public class LeetCode942 {

    public int[] diStringMatch(String s) {
        if (s == null || s.isEmpty()) {
            return new int[]{};
        }
        int n = s.length();
        int[] nums = new int[n + 1];
        int index = 0;
        int left = 0;
        int right = n;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                nums[index] = left;
                left++;
            } else {
                nums[index] = right;
                right--;
            }
            index++;
        }
        nums[n] = left;
        return nums;
    }
}

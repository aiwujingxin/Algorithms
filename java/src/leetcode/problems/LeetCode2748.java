package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/4/25 14:08
 */
public class LeetCode2748 {

    public int countBeautifulPairs(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(arr[i].charAt(0)- '0', arr[j].charAt(arr[j].length()- 1)- '0') == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }
}

package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 15:41
 */
public class LeetCode2447 {

    public static void main(String[] args) {
        System.out.println(new LeetCode2447().subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3));
    }

    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int d = nums[i];
            for (int j = i; j < n && d >= k; j++) {
                d = gcd(d, nums[j]);
                if (d == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a < b) {
            return gcd(b, a);
        }
        return gcd(b, a % b);
    }
}

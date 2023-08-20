package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/18 11:44
 */
public class LeetCode1052 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1052().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println(new LeetCode1052().maxSatisfied(new int[]{1}, new int[]{0}, 1));
        System.out.println(new LeetCode1052().maxSatisfied(new int[]{8, 8}, new int[]{1, 0}, 2));
        System.out.println(new LeetCode1052().maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2));
        System.out.println(new LeetCode1052().maxSatisfied(new int[]{5, 8}, new int[]{0, 1}, 1));
        System.out.println(new LeetCode1052().maxSatisfied(new int[]{2, 6, 6, 9}, new int[]{0, 0, 1, 1}, 1));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int ans = 0;

        // 窗口长度为minutes且当grumpy[i] = 1 的最大值 并记录窗口的位置
        // 加上其他时间 则为答案

        int right = 0;
        int left = 0;

        int winEnd = 0;
        int maxSum = 0;

        int sum = 0;
        while (right < n) {
            if (grumpy[right] == 1) {
                sum += customers[right];
            }

            while (right - left + 1 > minutes) {
                if (grumpy[left] == 1) {
                    sum -= customers[left];
                }
                left++;
            }
            if (sum > maxSum) {
                maxSum = sum;
                winEnd = right;
            }
            right++;
        }
//        System.out.println("winEnd : " + winEnd);
        for (int i = 0; i < n; i++) {
            int winStart = Math.max(winEnd - minutes + 1, 0);
            if (i <= winEnd && i >= winStart) {
                ans += customers[i];
            } else {
                if (grumpy[i] == 0) {
                    ans += customers[i];
                }
            }
        }
        return ans;
    }
}

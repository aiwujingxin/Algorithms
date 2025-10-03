package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/30 13:49
 */
public class LeetCode2241 {

    class ATM {
        int[] banknotesCount;
        int[] nums;
        int n = 5;

        public ATM() {
            this.banknotesCount = new int[5];
            this.nums = new int[]{20, 50, 100, 200, 500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < n; i++) {
                this.banknotesCount[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int index = n - 1;
            int[] ans = new int[n];
            while (amount > 0 && index >= 0) {
                while (amount >= nums[index] && banknotesCount[index] - ans[index] > 0) {
                    int d = nums[index];
                    int c = 1;
                    while (amount - d >= d && (banknotesCount[index] - 2 * c >= ans[index])) {
                        d = d * 2;
                        c = c * 2;
                    }
                    amount -= nums[index] * c;
                    ans[index] += c;
                }
                index--;
            }
            if (amount == 0) {
                for (int i = 0; i < ans.length; i++) {
                    banknotesCount[i] -= ans[i];
                }
                return ans;
            }
            return new int[]{-1};
        }
    }
}

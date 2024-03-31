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
            int[] cnt = new int[n];
            while (amount > 0 && index >= 0) {
                while (amount >= nums[index] && banknotesCount[index] - cnt[index] >= 1) {
                    int temp = nums[index];
                    int t = 1;
                    while (amount - temp >= temp && (banknotesCount[index] - t >= t + cnt[index])) {
                        temp = temp * 2;
                        t = t * 2;
                    }
                    amount -= nums[index] * t;
                    cnt[index] += t;
                }
                index--;
            }
            if (amount == 0) {
                for (int i = 0; i < cnt.length; i++) {
                    banknotesCount[i] -= cnt[i];
                }
                return cnt;
            }
            return new int[]{-1};
        }
    }
}

package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 21:18
 */
public class LeetCode2310 {

    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int i = 1; i <= 10; i++) {
            int sum = i * k;
            if (sum % 10 == num % 10 && sum <= num) {
                return i;
            }
        }
        return -1;
    }
}

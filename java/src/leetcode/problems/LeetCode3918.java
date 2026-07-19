package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/13/26 21:09
 */
public class LeetCode3918 {

    public int sumOfPrimesInRange(int n) {
        int sum = 0;
        int r = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
        for (int i = Math.min(r, sum); i <= Math.max(r, sum); i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

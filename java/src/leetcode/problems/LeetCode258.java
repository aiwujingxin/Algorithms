package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 16:16
 */
public class LeetCode258 {

    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits_math(int num) {
        return (num - 1) % 9 + 1;
    }
}

package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 18:14
 */
public class LeetCode507 {

    public boolean checkPerfectNumber(int num) {
        int res = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                res += i;
            }
            if (res > num) {
                return false;
            }
        }
        return res == num;
    }
}

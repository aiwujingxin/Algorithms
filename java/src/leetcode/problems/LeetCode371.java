package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/12/24 22:18
 */
public class LeetCode371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1; //进位
        }
        return a;
    }
}

package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 00:04
 */
public class LeetCode190 {

    //https://www.youtube.com/watch?v=OJE5k71dH1U
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; //左移
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1; //右移
        }
        return result;
    }
}

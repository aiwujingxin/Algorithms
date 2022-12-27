package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 13:58
 */
public class LeetCode190 {
    //https://www.youtube.com/watch?v=OJE5k71dH1U
    // n&1也可以判断n是否为偶数，如果是偶数，返回0；否则返回1。
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1; //左移
            // 当前位是1
            if ((n & 1) == 1) {
                res += 1;
            }
            n >>= 1; // 右移
        }
        return res;
    }
}

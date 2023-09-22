package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/14 02:15
 */
public class Offer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

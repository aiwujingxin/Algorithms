package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 16:58
 */
public class LeetCode371 {

    //study
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        //直到进位为0
        while (b != 0) {
            int ca = a & b; // 求进位
            a = a ^ b;
            b = ca << 1;  // 进位还需要左移
        }
        return a;
    }
}

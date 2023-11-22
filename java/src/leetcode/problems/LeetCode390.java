package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-01-02 12:51 AM
 */
public class LeetCode390 {

    public int lastRemaining(int n) {
        int head = 1;
        int remain = n;
        int step = 1;
        boolean isLeft = true;
        while (remain != 1) {
            // 从left || 从right, 但有奇数个元素
            if (isLeft || remain % 2 == 1) {
                head += step;
            }
            remain /= 2;
            step *= 2;
            isLeft = !isLeft;
        }
        return head;
    }
}

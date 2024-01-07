package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2024/1/7 21:30
 * <a href="https://leetcode.cn/problems/elimination-game/solutions/177976/mei-ri-suan-fa-day-85-tu-jie-suan-fa-yi-xing-dai-m/">...</a>
 */
public class LeetCode390 {

    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    public int lastRemaining_v2(int n) {
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

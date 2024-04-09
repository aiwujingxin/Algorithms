package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/26 17:43
 */
public class LeetCode2591 {

    public int distMoney(int money, int children) {
        int l = 0, r = children;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, money, children)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (!check(l, money, children)) {
            return -1;
        }
        return l;
    }

    public boolean check(int x, int money, int children) {
        money -= x * 8;
        int left = children - x;
        if (money < 0 || money < left || (left == 1 && money == 4) || (left == 0 && money > 0)) {
            return false;
        }
        return true;
    }
}

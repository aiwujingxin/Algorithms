package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 10:42
 */
public class LeetCode2483 {

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] p1 = new int[n + 1]; // 关门后剩下的需要服务的顾客数量
        int[] p2 = new int[n + 1]; // 开门时尚未来得及服务的顾客数量
        for (int i = n - 1; i >= 0; i--) {
            p1[i] = p1[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        for (int i = 0; i < n; i++) {
            p2[i + 1] = p2[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        }
        int idx = 0, ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {  // 尝试在第i小时关门
            int cost = p1[i] + p2[i];  // 计算总成本
            if (cost < ans) {
                ans = cost;
                idx = i;
            }
        }
        return idx;
    }
}

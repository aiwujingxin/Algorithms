package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 17:51
 */

public class LeetCode2445 {

    public int numberOfNodes(int n, int[] queries) {
        int m = n % 2 == 1 ? n : n + 1, ans = 0;
        int[] nodes = new int[m + 1];
        for (int i : queries) {
            nodes[i]++;
        }

        for (int i = 1; i <= m / 2; i++) { // for处理结束后，nodes[query]: 标号为 query 的结点的反转次数
            if (nodes[i] % 2 == 1) {
                ans++;
            } // 边推送边累计，如果反转次数是奇数，累计“1”
            nodes[i * 2] += nodes[i];
            nodes[i * 2 + 1] += nodes[i];
        }
        for (int i = m / 2 + 1; i <= n; i++) { // 继续累积 m/2+1 之后的结点
            if (nodes[i] % 2 == 1)
                ans++; // 如果反转次数是奇数，累计“1”
        }
        return ans;
    }
}

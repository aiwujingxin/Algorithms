package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2/12/26 14:20
 */
public class LeetCode3714 {

    int[][] presum;
    int n;

    public int longestBalanced(String s) {
        n = s.length();
        presum = new int[n + 1][26];
        presum[0][s.charAt(0) - 'a']++;
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1].clone();
            presum[i][s.charAt(i - 1) - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int r = findR(i);
            max = Math.max(max, r - i + 1);
        }
        return max;
    }

    int findR(int l) {
        int r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(l, r)) r = mid - 1;
            else l = mid;
        }
        return l;
    }

    public boolean check(int i, int r) {
        boolean can = true;
        for (int j = i; j < r; j++) {
            int pre = -1;
            for (int k = 0; k < 26; k++) {
                int c = presum[j + 1][k] - presum[i][k];
                if (c == 0) continue;
                if (pre != -1 && c != pre) {
                    can = false;
                    break;
                }
                pre = c;
            }

        }
        return can;
    }
}

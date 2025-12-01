package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 11/20/25 17:15
 */
public class LeetCode3694 {

    public int distinctPoints(String s, int k) {
        int n = s.length();
        int[] U = new int[n + 1];
        int[] D = new int[n + 1];
        int[] L = new int[n + 1];
        int[] R = new int[n + 1];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            U[i + 1] = U[i];
            D[i + 1] = D[i];
            L[i + 1] = L[i];
            R[i + 1] = R[i];
            if (s.charAt(i) == 'U') {
                U[i + 1]++;
                y++;
            }
            if (s.charAt(i) == 'D') {
                D[i + 1]++;
                y--;
            }
            if (s.charAt(i) == 'L') {
                L[i + 1]++;
                x--;
            }
            if (s.charAt(i) == 'R') {
                R[i + 1]++;
                x--;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = k - 1; i < n; i++) {
            int tx = x;
            int ty = y;
            int diffU = U[i + 1] - U[i + 1 - k];
            int diffD = D[i + 1] - D[i + 1 - k];
            int diffL = L[i + 1] - L[i + 1 - k];
            int diffR = R[i + 1] - R[i + 1 - k];
            ty -= diffU;
            ty += diffD;
            tx += diffL;
            tx -= diffR;
            set.add(tx * 100001 + ty);
        }
        return set.size();
    }
}

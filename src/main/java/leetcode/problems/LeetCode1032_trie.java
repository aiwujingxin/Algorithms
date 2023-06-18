package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:49
 */
public class LeetCode1032_trie {

    class StreamChecker {

        static int N = 2010 * 200, idx = 0;
        static int[][] tr = new int[N][26];
        static boolean[] isEnd = new boolean[N * 26];
        StringBuilder sb = new StringBuilder();

        void add(String s) {
            int p = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int u = s.charAt(i) - 'a';
                if (tr[p][u] == 0) tr[p][u] = ++idx;
                p = tr[p][u];
            }
            isEnd[p] = true;
        }

        public StreamChecker(String[] words) {
            for (int i = 0; i <= idx; i++) {
                Arrays.fill(tr[i], 0);
                isEnd[i] = false;
            }
            idx = 0;
            for (String s : words) add(s);
        }

        public boolean query(char c) {
            sb.append(c);
            int n = sb.length(), min = Math.max(0, n - 200), p = 0;
            for (int i = n - 1; i >= min; i--) {
                if (isEnd[p]) {
                    return true;
                }

                int u = sb.charAt(i) - 'a';
                if (tr[p][u] == 0) {
                    return false;
                }
                p = tr[p][u];
            }
            return isEnd[p];
        }
    }
}

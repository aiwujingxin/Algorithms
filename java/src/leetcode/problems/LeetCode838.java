package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:25
 */
public class LeetCode838 {

    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length;
        char left = 'L';
        for (int i = 0; i < n; i++) {
            if (s[i] != '.') {
                left = s[i];
                continue;
            }
            int j = i;
            while (j < n && s[j] == '.') j++;
            char right = j < n ? s[j] : 'R';
            if (left == right) {
                while (i < j) s[i++] = right;
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j;
        }
        return new String(s);
    }
}

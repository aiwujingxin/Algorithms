package leetcode.problems;

import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/21 20:54'
 */
public class LeetCode521 {

    char[] arra = new char[26];
    char[] arrb = new char[26];
    char[] arrt = new char[26];

    public int findLUSlength(String a, String b) {
        if (Objects.equals(a, b)) {
            return -1;
        }
        for (int i = 0; i < a.length(); i++) {
            arra[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            arrb[b.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j < a.length(); j++) {
                if (check(a.substring(i, j), arrb)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        for (int i = 0; i < b.length(); i++) {
            for (int j = i + 1; j < b.length(); j++) {
                if (check(b.substring(i, j), arra)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean check(String substring, char[] arr) {
        for (int i = 0; i < substring.length(); i++) {
            arrt[substring.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arrt[i] > arr[i]) {
                return true;
            }
        }
        return false;
    }
}

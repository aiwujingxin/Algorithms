package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 16:02
 * @see knowledge.datastructure.string.String.Match
 */
public class LeetCode28 {

    public int strStr(String h, String n) {
        int m = h.length(), l = n.length();
        if (m < l) return -1;
        for (int i = 0; i <= m - l; i++) {
            int j = 0;
            while (j < l && h.charAt(i + j) == n.charAt(j)) j++;
            if (j == l) return i;
        }
        return -1;
    }
}

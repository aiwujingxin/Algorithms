package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 15:05
 */
public class LeetCode165 {

    public int compareVersion(String v1, String v2) {
        String[] a = v1.split("\\."), b = v2.split("\\.");
        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            int n1 = i < a.length ? Integer.parseInt(a[i]) : 0;
            int n2 = i < b.length ? Integer.parseInt(b[i]) : 0;
            if (n1 != n2) return n1 > n2 ? 1 : -1;
        }
        return 0;
    }
}

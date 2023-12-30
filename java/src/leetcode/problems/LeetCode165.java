package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/30 10:33
 */
public class LeetCode165 {

    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        int m = vs1.length;
        int n = vs2.length;
        int i1 = 0;
        int i2 = 0;
        while (i1 < m || i2 < n) {
            int v1 = i1 >= m ? 0 : Integer.parseInt(vs1[i1]);
            int v2 = i2 >= n ? 0 : Integer.parseInt(vs2[i2]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i1++;
            i2++;
        }
        return 0;
    }
}

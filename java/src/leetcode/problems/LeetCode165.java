package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 14:01
 */
public class LeetCode165 {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;

        while (index1 < v1.length || index2 < v2.length) {
            int num1 = getNum(v1, index1);
            int num2 = getNum(v2, index2);
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
            index1++;
            index2++;
        }
        return 0;
    }

    private int getNum(String[] v1, int index1) {
        if (index1 >= v1.length) {
            return 0;
        }
        String s = v1[index1];
        int mi = 0;
        while (mi < s.length() && s.charAt(mi) == '0') {
            mi++;
        }
        if (mi == s.length()) {
            return 0;
        }
        return Integer.parseInt(s.substring(mi));
    }
}

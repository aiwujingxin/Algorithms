package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 17:09
 */
public class LeetCode165 {

    public int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        while (index1 < v1.length || index2 < v2.length) {
            int num1 = index1 >= v1.length ? 0 : Integer.parseInt(v1[index1]);
            int num2 = index2 >= v2.length ? 0 : Integer.parseInt(v2[index2]);
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
            index1++;
            index2++;
        }
        return 0;
    }
}

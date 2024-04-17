package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 15:05
 */
public class LeetCode165 {

    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.length || index2 < list2.length) {
            int v1 = index1 >= list1.length ? 0 : Integer.parseInt(list1[index1]);
            int v2 = index2 >= list2.length ? 0 : Integer.parseInt(list2[index2]);
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
            index1++;
            index2++;
        }
        return 0;
    }
}

package leetplan.datastructure.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 22:26
 */
public class LeetCode387 {

    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

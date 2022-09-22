package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 01:23
 */
public class LeetCode28 {

    //https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
    //"部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度。
    //移动位数 = 已匹配的字符数 - 对应的部分匹配值


    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/discuss/2268683/Java-or-Using-KMP
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int[] prefix = new int[m];
        makePrefix(prefix, needle);
        int i = 0, j = 0;
        while (j < n && i < m) {
            if (haystack.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
            } else {
                if (i - 1 >= 0) {
                    i = prefix[i - 1];
                } else {
                    j++;
                }
            }
        }
        if (i == m) {
            return j - i;
        } else {
            return -1;
        }
    }


    public void makePrefix(int[] prefix, String needle) {
        int i = 0, j = 1;
        while (j < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                prefix[j] = i + 1;
                i++;
                j++;
            } else {
                if (i - 1 >= 0) {
                    i = prefix[i - 1];
                } else {
                    prefix[j] = 0;
                    j++;
                }
            }
        }
    }
}

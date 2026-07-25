package knowledge.algorithms.twopoint.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 双序列双指针模板 (Two Sequence Pointers Template)
 * 适用于合并两个有序数组、判断子序列等问题。
 */
public class TwoSequencePointers {

    /**
     * 判断 s 是否为 t 的子序列
     *
     * @param s 较短字符串（或数组）
     * @param t 较长字符串（或数组）
     * @return 是否为子序列
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0; // 指向 s
        int j = 0; // 指向 t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                // 如果匹配，i 向前移动
                i++;
            }
            // j 无论如何都向前移动
            j++;
        }

        return i == s.length();
    }
}

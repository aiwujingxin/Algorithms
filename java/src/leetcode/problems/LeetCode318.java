package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023.11.09 22:35
 */
public class LeetCode318 {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                //压缩字符至int保存
                //如果可以将判断两个单词是否有公共字母的时间复杂度降低到 O(1)
                masks[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}

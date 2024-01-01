package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 18:27
 */
public class LeetCode424 {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        while (right < len) {
            freq[chars[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[chars[right] - 'A']);

            while (right - left + 1 > maxCount + k) {
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[chars[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}

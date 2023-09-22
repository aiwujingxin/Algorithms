package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-02-26 2:15 PM
 */
public class LeetCode316 {


    //https://www.youtube.com/watch?v=SrlvMmfG8sA&t=347s
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];

        // 去重
        boolean[] used = new boolean[26];

        char[] chs = s.toCharArray();

        for (char c : chs) {
            count[c - 'a']++;
        }

        for (char c : chs) {
            count[c - 'a']--;
            if (used[c - 'a']) {
                continue;
            }

            // 之后还有
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c
                    && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);

            }

            sb.append(c);
            used[c - 'a'] = true;
        }

        return sb.toString();
    }

}

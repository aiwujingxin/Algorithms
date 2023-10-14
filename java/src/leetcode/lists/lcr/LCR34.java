package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 23:50
 */
public class LCR34 {

    public boolean isAlienSorted(String[] words, String order) {

        int[] index = new int[26];
        for (int i = 0; i < 26; i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            String pre = words[i - 1];
            int j = 0;
            boolean valid = false;
            while (j < cur.length() && j < pre.length()) {
                if (index[pre.charAt(j) - 'a'] < index[cur.charAt(j) - 'a']) {
                    valid = true;
                    break;
                } else if (index[pre.charAt(j) - 'a'] > index[cur.charAt(j) - 'a']) {
                    return false;
                }
                j++;
            }
            if (!valid) {
                if (cur.length() < pre.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}

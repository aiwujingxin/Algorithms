package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 16:02
 */
public class LeetCode1763 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1763().longestNiceSubstring("HkhBubUYy"));
    }

    public String longestNiceSubstring(String s) {
        int n = s.length();
        int max = 0;
        int l = 0;

        for (int i = 1; i <= 26; i++) {
            int left = 0;
            int right = 0;
            int[] freq = new int[256];


            int[] charCnt = new int[26];
            int cnt = 0;

            while (right < n) {
                char c = s.charAt(right);
                if (charCnt[Character.toLowerCase(c) - 'a'] == 0) {
                    cnt++;
                }
                charCnt[Character.toLowerCase(c) - 'a']++;
                freq[c - 'A']++;

                while (left < right && cnt > i) {
                    char d = s.charAt(left);
                    if (charCnt[Character.toLowerCase(d) - 'a'] == 1) {
                        cnt--;
                    }
                    charCnt[Character.toLowerCase(d) - 'a']--;
                    freq[d - 'A']--;
                    left++;
                }
                if (cal(freq) >= i && max < right - left + 1) {
                    max = right - left + 1;
                    l = left;
                    System.out.println(" i " + i + " cnt " + i + " l " + l + " max " + max);

                }
                right++;
            }
        }
        return s.substring(l, l + max);
    }

    private int cal(int[] freq) {
        int cnt = 0;
        for (int j = 'A'; j <= 'Z'; j++) {
            if (freq[Character.toLowerCase(j) - 'A'] > 0 && freq[j - 'A'] > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}

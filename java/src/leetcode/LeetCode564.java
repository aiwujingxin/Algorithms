package leetcode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/19 23:16
 */
public class LeetCode564 {


    //https://leetcode.com/problems/find-the-closest-palindrome/discuss/960052/Find-previous-and-next-palindromes-detailed-explanation

    public static void main(String[] args) {
        System.out.println(new LeetCode564().nearestPalindromic("999"));
    }

    public String nearestPalindromic(String n) {
        long N = Long.parseLong(n);
        long S = previous(String.valueOf(N - 1).toCharArray());
        long L = next(String.valueOf(N + 1).toCharArray());
        return String.valueOf(L - N < N - S ? L : S);
    }

    private long previous(char[] s) {
        for (int i = 0, n = s.length; i < (n >> 1); i++) {
            while (s[i] != s[n - 1 - i]) {
                decrement(s, n - 1 - i);
                if (s[0] == '0') {
                    return Long.parseLong(new String(s));
                }
            }
        }
        return Long.parseLong(new String(s));
    }

    private void decrement(char[] s, int i) {
        while (s[i] == '0') {
            s[i--] = '9';
        }
        s[i]--;
    }

    private long next(char[] s) {
        for (int i = 0, n = s.length; i < (n >> 1); i++) {
            while (s[i] != s[n - 1 - i]) {
                increment(s, n - 1 - i);
            }
        }
        return Long.parseLong(new String(s));
    }

    private void increment(char[] s, int i) {
        while (s[i] == '9') {
            s[i--] = '0';
        }
        s[i]++;
    }
}

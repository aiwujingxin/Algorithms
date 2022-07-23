package LeetCode;

import java.util.*;

public class LeetCode131_backtrack_memo {

    public List<List<String>> partition(String s) {
        // For memorizing palindromes based on index
        boolean[][] dp = new boolean[s.length()][s.length()];

        // Store final result
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String str, int pos, List<String> temp,
                           List<List<String>> result, boolean[][] dp) {

        // If the position is equal to string length store all palindrome substring in result
        if (pos == str.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = pos; i < str.length(); ++i) {
            // If only Palindrome then store the temporary result and back tract
            if (dp[pos][i] || isPalindrome(str, pos, i, dp)) {
                temp.add(str.substring(pos, i + 1));
                backtrack(str, i + 1, temp, result, dp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // Check for palindrome if true memorize it for quicker access next time
    private boolean isPalindrome(String str, int start, int end, boolean[][] dp) {
        int low = start;
        int high = end;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        dp[low][high] = true;
        return dp[low][high];
    }
}

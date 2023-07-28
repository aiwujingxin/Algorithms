package leetcode.problems;

import java.util.*;

public class LeetCode131_backtrack {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        findPartitions(0, s, new ArrayList<>(), result);

        return result;
    }

    private void findPartitions(int currIndex, String str, List<String> path, List<List<String>> result) {

        if (currIndex == str.length()) {
            // reaches the end of the String
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = currIndex; i < str.length(); i++) {

            if (valid(currIndex, i, str)) {

                path.add(str.substring(currIndex, i + 1));

                findPartitions(i + 1, str, path, result);

                path.remove(path.size() - 1); // backtrack and remove previously added string in current result
            }
        }
    }

    private boolean valid(int low, int high, String str) {
        while (low <= high) {
            if (str.charAt(low++) != str.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}

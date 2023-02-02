package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 21:40
 */
public class LeetCode744 {

    //a b "c",  "f","j"
    //d

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        int l = 0;
        int r = letters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (letters[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[l];
    }
}

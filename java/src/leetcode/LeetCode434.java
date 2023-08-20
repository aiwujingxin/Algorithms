package leetcode;

/**
 * @author jingxinwu
 * @date 2021-12-26 9:24 PM
 */
public class LeetCode434 {


    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}

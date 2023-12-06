package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 14:45
 */
public class LeetCode492 {

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}

package leetcode.plan.graph.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 22:28
 */
public class LeetCode733 {

    int or;

    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) {
            return image;
        }
        or = image[sr][sc];
        visited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int color) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length &&
                image[sr][sc] == or && !visited[sr][sc]) {
            image[sr][sc] = color;
            visited[sr][sc] = true;
            helper(image, sr - 1, sc, color);
            helper(image, sr + 1, sc, color);
            helper(image, sr, sc - 1, color);
            helper(image, sr, sc + 1, color);
        }
    }
}

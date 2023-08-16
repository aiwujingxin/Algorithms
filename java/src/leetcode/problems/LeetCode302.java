package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/23 17:13
 */
public class LeetCode302 {

    private int top, bottom, left, right;

    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0 || image[0].length == 0) return 0;
        top = bottom = x;
        left = right = y;
        dfs(image, x, y);
        return (right - left) * (bottom - top);
    }

    private void dfs(char[][] image, int x, int y) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        top = Math.min(top, x);
        bottom = Math.max(bottom, x + 1);
        left = Math.min(left, y);
        right = Math.max(right, y + 1);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }


    //===opt==
    public int minArea_opt(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int left = searchCol(image, 0, y, 0, m - 1, false);
        int right = searchCol(image, y + 1, n - 1, 0, m - 1, true);
        int up = searchRow(image, 0, x, 0, n - 1, false);
        int down = searchRow(image, x + 1, m - 1, 0, n - 1, true);

        return (right - left - 1) * (down - up - 1);
    }

    public int searchCol(char[][] image, int i, int j, int top, int bottom, boolean searchRight) {
        while (i <= j) {
            int k = top, mid = (i + j) / 2;
            while (k <= bottom && image[k][mid] == '0') {
                k++;
            }
            if (k <= bottom) {
                if (searchRight) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                if (searchRight) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return searchRight ? i : j;
    }

    public int searchRow(char[][] image, int i, int j, int left, int right, boolean searchDown) {
        while (i <= j) {
            int k = left, mid = (i + j) / 2;
            while (k <= right && image[mid][k] == '0') {
                k++;
            }
            if (k <= right) {
                if (searchDown) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                if (searchDown) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return searchDown ? i : j;
    }
}

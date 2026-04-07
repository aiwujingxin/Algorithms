package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 4/6/26 20:29
 */
public class LeetCode1861 {

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (int i = 0; i < m; i++) {
            for (int end = n - 1; end >= 0; end--) {
                if (boxGrid[i][end] == '#') {
                    continue;
                }
                int cnt = 0;
                int t = end;
                while (t >= 0 && boxGrid[i][t] != '*') {
                    if (boxGrid[i][t] == '#') {
                        cnt++;
                    }
                    t--;
                }
                int place = boxGrid[i][end] == '.' ? end : end - 1;
                boolean has = cnt > 0;
                while (cnt > 0) {
                    boxGrid[i][place] = '#';
                    cnt--;
                    place--;
                }
                while (has && place >= 0 && place > t) {
                    boxGrid[i][place] = '.';
                    place--;
                }
            }
        }

        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = boxGrid[m - 1 - i][j];
            }
        }
        return result;
    }
}

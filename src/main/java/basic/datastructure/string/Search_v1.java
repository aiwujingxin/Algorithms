package basic.datastructure.string;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/4 23:22
 */
public class Search_v1 {

    public static int search(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }
}

package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-25 11:10 下午
 */
public class Offer58_2 {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}

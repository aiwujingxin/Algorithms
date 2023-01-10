package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 12:39 下午
 */
public class Offer11 {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int l = 0;
        int r = numbers.length - 1;
        int pi = 0;
        while (l <= r) {
            pi = (r - l) / 2 + l;
            if (numbers[pi] < numbers[r]) {
                r = pi;
            } else if (numbers[pi] > numbers[r]) {
                l = pi + 1;
            } else {
                r--;
            }
        }
        return numbers[pi];
    }
}

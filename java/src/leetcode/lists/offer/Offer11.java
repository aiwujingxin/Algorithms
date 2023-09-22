package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:52
 */
public class Offer11 {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return numbers[l];
    }
}

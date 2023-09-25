package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 18:21
 */
public class LCR73 {

    public static void main(String[] args) {
        System.out.println(new LCR73().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(new LCR73().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new LCR73().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            int time = getTime(piles, mid);
            if (time <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getTime(int[] piles, int num) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] % num == 0 ? piles[i] / num : piles[i] / num + 1;
        }
        return time;
    }
}

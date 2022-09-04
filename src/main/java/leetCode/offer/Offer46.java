package leetCode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-11-23 6:20 下午
 */
public class Offer46 {

    public static void main(String[] args) {
        Offer46 offer46 = new Offer46();
        System.out.println(offer46.translateNum(500006));
    }

    //506
    //5 0 6
    //500006

    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String str = String.valueOf(num);
        List<Integer> dp = new ArrayList<>();
        dp.add(0, 1);

        if (Integer.parseInt(str.substring(0, 2)) <= 25) {
            dp.add(1, 2);
        } else {
            dp.add(1, 1);
        }

        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i - 1) == '0') {
                dp.add(i, dp.get(i - 1));
            } else {
                int n = Integer.parseInt(str.substring(i - 1, i + 1));
                if (n <= 25) {
                    dp.add(i, dp.get(i - 1) + dp.get(i - 2));
                } else {
                    dp.add(i, dp.get(i - 1));
                }
            }
        }
        return dp.get(dp.size() - 1);
    }
}

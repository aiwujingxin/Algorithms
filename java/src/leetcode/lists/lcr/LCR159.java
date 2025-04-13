package leetcode.lists.lcr;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 01:48
 */
public class LCR159 {

    public int[] inventoryManagement(int[] stock, int cnt) {
        int[] vec = new int[cnt];
        Arrays.sort(stock);
        System.arraycopy(stock, 0, vec, 0, cnt);
        return vec;
    }
}

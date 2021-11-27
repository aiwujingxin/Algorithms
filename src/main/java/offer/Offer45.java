package offer;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-11-23 12:15 上午
 */
public class Offer45 {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    //============
    public String minNumberV2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    public void quickSort(String[] strs, int low, int high) {
        if (low < high) {
            int middle = getMiddle(strs, low, high);
            quickSort(strs, low, middle - 1);
            quickSort(strs, middle + 1, high);
        }
    }

    public int getMiddle(String[] strs, int low, int high) {
        //数组的第一个数为基准元素
        String temp = strs[low];
        while (low < high) {
            //从后向前找比基准小的数
            while (low < high && (strs[high] + temp).compareTo(temp + strs[high]) >= 0) {
                high--;
            }
            //把比基准小的数移到低端
            strs[low] = strs[high];
            //从前向后找比基准大的数
            while (low < high && (strs[low] + temp).compareTo(temp + strs[low]) <= 0) {
                low++;
            }
            //把比基准大的数移到高端
            strs[high] = strs[low];
        }
        strs[low] = temp;
        return low;
    }
}

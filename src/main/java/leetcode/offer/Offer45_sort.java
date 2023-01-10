package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 17:26
 */
public class Offer45_sort {

    public String minNumber(int[] nums) {
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
            int index = getMiddle(strs, low, high);
            quickSort(strs, low, index - 1);
            quickSort(strs, index + 1, high);
        }
    }

    public int getMiddle(String[] strs, int low, int high) {
        //数组的第一个数为基准元素
        String pi = strs[low];
        while (low < high) {
            while (low < high && (strs[high] + pi).compareTo(pi + strs[high]) >= 0) {
                high--;
            }
            strs[low] = strs[high];
            //从前向后找比基准大的数
            while (low < high && (strs[low] + pi).compareTo(pi + strs[low]) <= 0) {
                low++;
            }
            strs[high] = strs[low];
        }
        strs[low] = pi;
        return low;
    }
}

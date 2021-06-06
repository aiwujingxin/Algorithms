package newker;

import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2021-05-24 9:39 下午
 */
public class MaxLength {

    public static void main(String[] args) {
        System.out.println(maxLengthV2(new int[]{1, 2, 3, 1, 2, 3, 2, 2}));
    }

    public static int maxLength(int[] arr) {
        // write code here
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int temp = 1;
            map.put(arr[i], i);
            for (int j = i + 1; j < arr.length; j++) {
                if (!map.containsKey(arr[j])) {
                    map.put(arr[j], j);
                    temp++;
                } else {
                    break;
                }
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    public static int maxLengthV2(int[] arr) {
        // write code here
        int[] re = new int[100000];
        int max = 0;
        int index = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            index = arr[i];
            start = Math.max(start, re[index]);//下次开始的位置
            max = Math.max(max, i - start + 1);
            re[index] = i + 1;
        }

        return max;
    }

    public static int maxLengthV3(int[] arr) {
        int result = 0, start = 0;
        int[] end = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (start < end[num]) {
                start = end[num];
            }
            if (result < i - start + 1) {
                result = i - start + 1;
            }
            end[num] = i + 1;
        }
        return result;
    }

    public static int lengthOfLongestSubstring(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return n;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < n) {
            if (!map.containsKey(arr[j])) {
                map.put(arr[j], j);
            } else {
                i = Math.max(i, map.get(arr[j]) + 1);
                map.put(arr[j], j);
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}

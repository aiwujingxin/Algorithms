package leetcode.plan.datastructure.level2;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/25 21:50
 */
public class LeetCode56 {


    //https://leetcode.com/problems/merge-intervals/discuss/1810276/Simple-JAVA-Solution
    public int[][] merge(int[][] intervals) {
        //declaring an array list to store the pairs
        ArrayList<int[]> list = new ArrayList<>();
        //sorting the given interval array based on starting point
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //defining start and end point
        int start = intervals[0][0];
        int end = intervals[0][1];
        //we will iterate through the 2d array intervals so in each iteration we will get a row[1D array] as i
        for (int[] i : intervals) {
            //check if end point of 1st pair if greater than the starting point of the 2nd pair or not, basically we check it's in overlapping condition or not
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {  //otherwise add it in the list
                list.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}

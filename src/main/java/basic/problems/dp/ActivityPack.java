package basic.problems.dp;

import basic.algorithm.dp.other.ActivityPack_dp;
import basic.algorithm.greedy.ActivityPack_Greedy;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 13:44
 */
public interface ActivityPack {

    static void main(String[] args) {
        System.out.println(new ActivityPack_dp().activityPack(new int[][]{{2, 13}, {8, 12}, {5, 9}, {4, 9}, {1, 4}, {2, 6}, {3, 5}, {5, 7}, {6, 10}, {8, 11}}));
        System.out.println(new ActivityPack_Greedy().activityPack(new int[][]{{2, 13}, {8, 12}, {5, 9}, {4, 9}, {1, 4}, {2, 6}, {3, 5}, {5, 7}, {6, 10}, {8, 11}}));
    }

    int activityPack(int[][] periods);
}

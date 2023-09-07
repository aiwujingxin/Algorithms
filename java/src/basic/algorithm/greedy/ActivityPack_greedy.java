package basic.algorithm.greedy;

import basic.algorithm.dp.liner.ActivityPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 11:21
 */
public class ActivityPack_greedy implements ActivityPack {

    public int activityPack(int[][] periods) {

        Arrays.sort(periods, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });


        List<int[]> res = new ArrayList<>();
        res.add(periods[0]);

        for (int i = 1; i < periods.length; i++) {
            if (periods[i][0] >= res.get(res.size() - 1)[1]) {
                res.add(periods[i]);
            }
        }
        return res.size();
    }
}

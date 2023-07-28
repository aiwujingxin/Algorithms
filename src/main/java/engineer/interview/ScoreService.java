package engineer.interview;

import java.util.*;
import java.util.Map.*;

/**
 * @author jingxinwu
 * @date 2022-02-24 9:07 PM
 */
public class ScoreService {


    /**
     * 排行榜内的数据满足以下条件:
     * 1. UserScore中的Count必须要大于kThreshold
     * 2. 排行榜排序的规则是：
     * 1) scores高的排前面
     * 2) scores相同，count少的排前面
     * 3) scores和count都相同，id小的排前面
     * 注：数组中元素的id不重复。
     * 请实现 UserScoreRank 类中的方法。
     */

    public class UserScore {

        public int id;
        public int scores;
        public int count;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            UserScore userScore = (UserScore) o;
            return id == userScore.id && scores == userScore.scores && count == userScore.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, scores, count);
        }
    }


    public class UserScoreRank {

        public static final int kThreshold = 10;


        public TreeMap<Integer, UserScore> map = new TreeMap<>();
        public List<Entry<Integer, UserScore>> list = new ArrayList<>();

        //根据比赛结果，批量更新玩家信息
        public int updateUserScoreRank(List<UserScore> src) {
            for (UserScore userScore : src) {
                map.put(userScore.id, userScore);
            }
            /**
             *   * 2. 排行榜排序的规则是：
             *      * 1) scores高的排前面
             *      * 2) scores相同，count少的排前面
             *      * 3) scores和count都相同，id小的排前面
             * */
            list = new ArrayList<Entry<Integer, UserScore>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, UserScore>>() {
                //升序排序
                @Override
                public int compare(Entry<Integer, UserScore> o1, Entry<Integer, UserScore> o2) {

                    if (o1.getValue().count != o2.getValue().count && o1.getValue().scores != o2.getValue().scores) {
                        return o1.getValue().scores - o2.getValue().scores;
                    }
                    if (o1.getValue().scores == o2.getValue().scores) {
                        return o1.getValue().count - o2.getValue().count;
                    }
                    return o1.getValue().id - o2.getValue().id;
                }

            });
            return src.size();
        }

        //输入名次的上限和下限，给出玩家排行列表（包含上下界)
        public List<UserScore> getUserScoreRank(int low_bound, int up_bound) {

            ArrayList<UserScore> result = new ArrayList<>();

            UserScore[] userScores = new UserScore[list.size()];

            for (int i = 0; i < list.size(); i++) {
                userScores[i] = list.get(i).getValue();
            }
            for (int i = low_bound; i < up_bound; i++) {
                result.add(userScores[i]);
            }
            return result;
        }

        //从排行榜删除特定的玩家
        public int deleleUserRankByIds(List<Integer> ids) {
            for (int i = 0; i < ids.size(); i++) {
                map.remove(ids.get(i));
            }
            list = new ArrayList<Entry<Integer, UserScore>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, UserScore>>() {
                //升序排序
                public int compare(Entry<Integer, UserScore> o1, Entry<Integer, UserScore> o2) {

                    if (o1.getValue().count != o2.getValue().count && o1.getValue().scores != o2.getValue().scores) {
                        return o1.getValue().scores - o2.getValue().scores;
                    }
                    if (o1.getValue().scores == o2.getValue().scores) {
                        return o1.getValue().count - o2.getValue().count;
                    }
                    return o1.getValue().id - o2.getValue().id;
                }

            });
            return ids.size();
        }

    }


    public class MapValueComparator implements Comparator<Entry<Integer, UserScore>> {

        private Map<String, Integer> map;

        public MapValueComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(Entry<Integer, UserScore> o1, Entry<Integer, UserScore> o2) {

            if (o1.getValue().count != o2.getValue().count && o1.getValue().scores != o2.getValue().scores) {
                return o1.getValue().scores - o2.getValue().scores;
            }
            if (o1.getValue().scores == o2.getValue().scores) {
                return o1.getValue().count - o2.getValue().count;
            }
            return o1.getValue().id - o2.getValue().id;
        }

    }
}
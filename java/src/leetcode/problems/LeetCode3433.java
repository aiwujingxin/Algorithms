package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 12/5/25 15:55
 */
public class LeetCode3433 {
    HashMap<Integer, List<Integer>> offMap;

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = numberOfUsers;
        int[] mentions = new int[n];
        offMap = new HashMap<>();
        for (List<String> event : events) {
            String type = event.get(0);
            if (Objects.equals(type, "MESSAGE")) {
                continue;
            }
            int timestamp = Integer.parseInt(event.get(1));
            int user = Integer.parseInt(event.get(2));
            if (Objects.equals(type, "OFFLINE")) {
                offMap.computeIfAbsent(user, k -> new ArrayList<>()).add(timestamp);
            }
        }
        int all = 0;
        for (List<String> event : events) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            String user = event.get(2);
            if (Objects.equals(type, "MESSAGE")) {
                if (Objects.equals(user, "ALL")) {
                    all++;
                } else if (Objects.equals(user, "HERE")) {
                    for (int j = 0; j < n; j++) {
                        if (canSend(j, timestamp)) {
                            mentions[j]++;
                        }
                    }
                } else {
                    String[] ids = user.split(" ");
                    for (String id : ids) {
                        int uid = Integer.parseInt(id.substring(2));
                        mentions[uid]++;
                    }
                }
            }
        }
        for (int i = 0; i < all; i++) {
            for (int j = 0; j < n; j++) {
                mentions[j]++;
            }
        }
        return mentions;
    }

    public boolean canSend(int user, int time) {
        List<Integer> ofttimes = offMap.get(user);
        if (ofttimes == null) {
            return true;
        }
        for (int s : ofttimes) {
            int e = s + 59;
            if (time >= s && time <= e) {
                return false;
            }
        }
        return true;
    }
}

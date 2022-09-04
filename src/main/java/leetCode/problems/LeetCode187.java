package leetCode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-08-13 1:54 上午
 */
public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet<String> seen = new HashSet<>(), output = new HashSet<>();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            String tmp = s.substring(start, start + L);
            if (seen.contains(tmp)) {
                output.add(tmp);
            }
            seen.add(tmp);
        }
        return new ArrayList<>(output);

    }
}

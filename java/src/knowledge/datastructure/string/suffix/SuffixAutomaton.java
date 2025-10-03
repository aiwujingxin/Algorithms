package knowledge.datastructure.string.suffix;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/9/24 06:47
 * @description Suffix Automaton (SAM) for a single string.
 * - build in O(n) with extend(char)
 * - contains(pattern)
 * - countOccurrences(pattern) after prepareOccurrence()
 * - distinctSubstrings()
 * - longestCommonSubstring(other) using SAM of this.s
 */
public class SuffixAutomaton {
    // State of SAM
    static class State {
        int maxLen;                  // length of the longest string in this state
        int link = -1;               // suffix link
        Map<Character, Integer> next = new HashMap<>(); // transitions
        long occ = 0;                // endpos count (for occurrence queries)
    }

    private final List<State> st = new ArrayList<>();
    private int last;               // last state (active)

    public SuffixAutomaton() {
        st.add(new State()); // state 0 = initial
        last = 0;
    }

    public SuffixAutomaton(String s) {
        this();
        for (int i = 0; i < s.length(); i++) extend(s.charAt(i));
        // 默认不立即做 occ 统计，按需调用 prepareOccurrence()
    }

    // Extend with one character
    public void extend(char c) {
        int cur = newState();
        st.get(cur).maxLen = st.get(last).maxLen + 1;
        st.get(cur).occ = 1; // each new end contributes one endpos initially

        int p = last;
        while (p != -1 && !st.get(p).next.containsKey(c)) {
            st.get(p).next.put(c, cur);
            p = st.get(p).link;
        }
        if (p == -1) {
            st.get(cur).link = 0;
        } else {
            int q = st.get(p).next.get(c);
            if (st.get(p).maxLen + 1 == st.get(q).maxLen) {
                st.get(cur).link = q;
            } else {
                int clone = newState();
                State qc = st.get(clone);
                State qv = st.get(q);
                qc.maxLen = st.get(p).maxLen + 1;
                qc.next = new HashMap<>(qv.next);
                qc.link = qv.link;
                qc.occ = 0; // clone does not represent new endpos
                // redirect transitions
                while (p != -1 && st.get(p).next.get(c) == q) {
                    st.get(p).next.put(c, clone);
                    p = st.get(p).link;
                }
                qv.link = st.get(cur).link = clone;
            }
        }
        last = cur;
    }

    private int newState() {
        st.add(new State());
        return st.size() - 1;
    }

    public int size() {
        return st.size();
    }

    // Check if pattern is a substring
    public boolean contains(String pattern) {
        int v = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            Integer to = st.get(v).next.get(c);
            if (to == null) return false;
            v = to;
        }
        return true;
    }

    // Prepare occurrence counts: propagate occ from longer states to suffix links.
    // This must be called before countOccurrences().
    public void prepareOccurrence() {
        // Counting sort by maxLen
        int maxLen = 0;
        for (State s : st) maxLen = Math.max(maxLen, s.maxLen);
        int[] cnt = new int[maxLen + 1];
        for (State s : st) cnt[s.maxLen]++;
        for (int i = 1; i <= maxLen; i++) cnt[i] += cnt[i - 1];

        int n = st.size();
        int[] order = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            State si = st.get(i);
            order[--cnt[si.maxLen]] = i; // increasing by maxLen
        }
        // traverse in decreasing maxLen
        for (int i = n - 1; i > 0; i--) {
            int v = order[i];
            int link = st.get(v).link;
            if (link >= 0) st.get(link).occ += st.get(v).occ;
        }
    }

    // Number of occurrences of pattern in the original string
    // Needs prepareOccurrence() after building.
    public long countOccurrences(String pattern) {
        int v = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            Integer to = st.get(v).next.get(c);
            if (to == null) return 0;
            v = to;
        }
        return st.get(v).occ;
    }

    // Count of distinct substrings in the built string
    // sum over states: maxLen[v] - maxLen[link[v]]
    public long distinctSubstrings() {
        long res = 0;
        for (int v = 1; v < st.size(); v++) {
            int link = st.get(v).link;
            res += st.get(v).maxLen - (link < 0 ? 0 : st.get(link).maxLen);
        }
        return res;
    }

    // Longest common substring length between this SAM's string and another string
    // Returns the LCS string; if只要长度，可改为返回长度
    public String longestCommonSubstring(String other) {
        int v = 0, l = 0;
        int bestLen = 0, bestPos = -1;

        for (int i = 0; i < other.length(); i++) {
            char c = other.charAt(i);
            while (v != -1 && !st.get(v).next.containsKey(c)) {
                v = st.get(v).link;
                if (v != -1) l = Math.min(l, st.get(v).maxLen);
            }
            if (v == -1) {
                v = 0;
                l = 0;
                continue;
            }
            v = st.get(v).next.get(c);
            l++;
            if (l > bestLen) {
                bestLen = l;
                bestPos = i;
            }
        }
        return bestLen == 0 ? "" : other.substring(bestPos - bestLen + 1, bestPos + 1);
    }

    // Demo
    public static void main(String[] args) {
        String s = "banana";
        SuffixAutomaton sam = new SuffixAutomaton(s);

        System.out.println("banana contains('ana'): " + sam.contains("ana"));
        System.out.println("banana contains('apple'): " + sam.contains("apple"));

        System.out.println("banana distinct substrings: " + sam.distinctSubstrings());

        sam.prepareOccurrence();
        System.out.println("banana countOccurrences('ana'): " + sam.countOccurrences("ana")); // 2

        String t = "cabana!";
        System.out.println("LCS with '" + t + "': " + sam.longestCommonSubstring(t));
    }
}

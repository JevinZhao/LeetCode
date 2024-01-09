import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2707. 字符串中的额外字符
 * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。
 * 你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。
 * s 中可能会有一些 额外的字符 不在任何子字符串中。
 * <p>
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 */
public class _20240109_2707_MinExtraChar {
    /**
     * 思路：
     *
     * @param s
     * @param dictionary
     * @return
     */
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : dictionary) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(s.substring(j, i))) {
                    d[i] = Math.min(d[i], d[j]);
                }
            }
        }
        return d[n];
    }
}

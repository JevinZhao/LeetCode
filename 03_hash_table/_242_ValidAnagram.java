import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _242_ValidAnagram {
    /**
     * 思路：1.将两个字符串快排，判断排序之后的新字符是否相同   时间复杂度：n*log（n）
     * 2.统计两个字符串中字母个数存入Map中，判断两个Map是否相同   时间复杂度：log（n）
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())  return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i <t.length(); i++) {
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)-1);
            if (map.get(c)<0) return false;
        }
        return true;
    }
}

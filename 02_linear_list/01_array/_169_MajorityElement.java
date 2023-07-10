import java.util.*;

/**
 * 169. 多数元素
 * 给定一个大小为n的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class _169_MajorityElement {

    /**
     * 思路：这个问题要解决什么
     * 统计每个元素出现的次数--->使用什么结构，既能存储元素又能存储次数--->Map
     * 找 Map中value最大的key-->将entrySet放入List，自定义排序
     * @param nums 数组
     * @return 多数元素
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Map.Entry<Integer,Integer>> array=new ArrayList<>(map.entrySet());
        Collections.sort(array,((o1, o2) -> o1.getValue()-o2.getValue()));
        return array.get(array.size()-1).getKey();
    }

    public static void main(String[] args) {
        int [] nums=new int []{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}

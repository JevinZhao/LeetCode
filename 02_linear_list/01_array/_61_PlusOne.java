/**
 * 61.加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _61_PlusOne {
    /**
     * 注意两种情况
     * 1.末位是9的，要求进位的情况。
     * 2.末位非9
     * @param digits 目标数组
     * @return 返回的数字
     */
    public int[] plusOne(int[] digits) {
        //倒着遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            //如论如何都要加一
            digits[i]++;
            //判断是否加后为10的倍数
            digits[i]=digits[i]%10;
            if(digits[i]%10!=0)
                return digits;//不是10的倍数，直接返回结果，结束方法
        }
        //若是10的倍数才会走到这一步，数组大小加一
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}

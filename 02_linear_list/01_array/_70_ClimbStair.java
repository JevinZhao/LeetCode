/**
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _70_ClimbStair {
    /**
     * 递归法，f(x)=f(x−1)+f(x−2),该方法结果超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * 递归优化后的解法，主要是将中间结果存储起来，避免重复计算
     * @param n
     * @return
     */
    public int climbStairs_1(int n) {
        int[] temp=new int[n+1];
        return climbStairs1(n,temp);
    }

    private int climbStairs1(int n, int[] temp) {
        //递归到n时，若数组中存在，说明已经计算过，直接返回
        if(temp[n]>0){
            return temp[n];
        }
        if(n==1){
            temp[n]=1;
        }else if (n==2){
            temp[n]=2;
        }else {
            temp[n]=climbStairs1(n-1,temp)+climbStairs1(n-2,temp);
        }
        return temp[n];
    }
}

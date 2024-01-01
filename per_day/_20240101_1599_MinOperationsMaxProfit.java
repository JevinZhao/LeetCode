/**
 * 1599. 经营摩天轮的最大利润
 * 你正在经营一座摩天轮，该摩天轮共有 4 个座舱 ，每个座舱 最多可以容纳 4 位游客 。你可以 逆时针 轮转座舱，但每次轮转都需要支付一定的运行成本 runningCost 。
 * 摩天轮每次轮转都恰好转动 1 / 4 周。
 * 给你一个长度为 n 的数组 customers ， customers[i] 是在第 i 次轮转（下标从 0 开始）之前到达的新游客的数量。这也意味着你必须在新游客到来前轮转 i 次。
 * 每位游客在登上离地面最近的座舱前都会支付登舱成本 boardingCost ，一旦该座舱再次抵达地面，他们就会离开座舱结束游玩。
 * 你可以随时停下摩天轮，即便是 在服务所有游客之前 。如果你决定停止运营摩天轮，为了保证所有游客安全着陆，将免费进行所有后续轮转 。
 * 注意，如果有超过 4 位游客在等摩天轮，那么只有 4 位游客可以登上摩天轮，其余的需要等待 下一次轮转 。
 * 返回最大化利润所需执行的 最小轮转次数 。 如果不存在利润为正的方案，则返回 -1 。
 */
public class _20240101_1599_MinOperationsMaxProfit {
    /**
     * 模拟第i波游客到来，情境
     *
     * 需要维护的变量：
     * 前i-1波的总利润 P ；
     * 前i-1波的等待游客数 W；
     * 最终答案ans；
     * 单次利润的计算方法：上车人数*boardingCost-runningCost
     *
     * 难点： for (int i = 0; i < customers.length||W>0; i++) {
     * 在没人来，但还有剩余乘客怎么计算
     *
     * @param customers
     * @param boardingCost
     * @param runningCost
     * @return
     */
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int P=0;
        int W=0;
        int ans=-1;
        int max=0;
        for (int i = 0; i < customers.length||W>0; i++) {
            if (i<customers.length){
                //第i波总人数
                W=W+customers[i];
            }
            //上车人数
            int t=Math.min(W,4);
            //单次利润
            int p=t*boardingCost-runningCost;
            //更新等待游客数，总利润数，
            W=W-t;
            P=P+p;
            if (P>max){
                max=P;
                ans=i+1;
            }
        }
        return ans;
    }
}

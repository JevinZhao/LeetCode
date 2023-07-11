/**
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class _23_MergeKSortedLists {
    /**
     * 思路：
     * 递归，两两合并
     * 遍历链表数组-->定义一个合并方法
     *
     * @param lists 链表数组
     * @return 合并之后链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNodeTemp = null;
        if (lists != null) {
            for (ListNode list :
                    lists) {
                listNodeTemp = mergeTwoLists(list, listNodeTemp);
            }
            return listNodeTemp;
        }
       return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

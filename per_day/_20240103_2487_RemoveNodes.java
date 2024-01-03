/**
 * 2487. 从链表中移除节点
 * 给你一个链表的头节点 head 。
 * <p>
 * 移除每个右侧有一个更大数值的节点。
 * <p>
 * 返回修改后链表的头节点 head 。
 */
public class _20240103_2487_RemoveNodes {
    /**
     * 思路：递归，最开始采用的是while循环让链表不停比下去，发现不行
     *
     * 该节点为空，那么递归函数返回空指针。
     *
     * 该节点不为空，那么先对它的右侧节点进行移除操作，得到一个新的子链表，如果子链表的表头节点值大于该节点的值，那么移除该节点，
     * 否则将该节点作为子链表的表头节点，最后返回该子链表。
     *
     * @param head
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
/*        while(head.next!=null&&head.val<head.next.val){
            head=head.next;
        }
        return head;*/
        head.next=removeNodes(head.next);
        if (head.next!=null&&head.val<head.next.val){
            return head.next;
        }else {
            return head;
        }
    }
}

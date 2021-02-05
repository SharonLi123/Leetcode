package leetcode.editor.cn;


public class 合并两个有序链表{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 两个链表可能为空
        if(l1==null || l1==null){
            return l1==null?l2 : l1;
        }

        ListNode result=new ListNode();
        ListNode p=result;
        /*
         * l1[0]<=l2[0] -> put l1[0] l1p++
         * l1[0]>l2[0] -> put l2[0] l2p++
         */
        while (l1!=null && l2!=null){
            if(l1.val>l2.val){
                p.next=l2;
                p=l2;
                l2=l2.next;
                continue;
            }

            p.next=l1;
            p=l1;
            l1=l1.next;
        }

        p.next=l1==null?l2:l1;

        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

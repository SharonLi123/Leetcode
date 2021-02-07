import leetcode.editor.cn.ListNode;

public class ListNode {
    int val;
    leetcode.editor.cn.ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, leetcode.editor.cn.ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode reverseGroup(ListNode head,int k){
        if(head==null) return null;

        ListNode a,b;
        a=b=head;
        for(int i=0;i<k;i++){
            if(b==null){
                return head;
            }
            b=b.next;
        }

        ListNode newHead=reverse(a,b);
        a.next=reverseGroup(b,k);
        return newHead;
    }

    public ListNode reverse(ListNode a,ListNode b){
        ListNode curr=a,pre=null;
        while (curr!=b){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }



}
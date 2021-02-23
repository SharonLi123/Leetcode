package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class 组合{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0 || k>n){
            return new LinkedList<>();
        }
        backtrace(1,n,k,new LinkedList<>());
        return res;
    }

    public void backtrace(int start,int n,int k,LinkedList<Integer> curr){
        if(k<=0){
            res.add(new LinkedList<>(curr));
            return;
        }
        for(int i=start;i<=n-k+1;i++){
            curr.add(i);
            backtrace(i+1,n,k-1,curr);
            curr.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

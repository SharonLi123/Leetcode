package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class 子集{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new LinkedList<>());
        backtrace(0,nums);
        return res;
    }

    void backtrace(int n,int[] nums){
        if(n==nums.length){
            return;
        }

        backtrace(n+1,nums);
        List<List<Integer>> record=new LinkedList<>();
        for(List<Integer> single:res){
            LinkedList<Integer> curr= new LinkedList<>(single);
            curr.add(nums[n]);
            record.add(curr);
        }
        res.addAll(record);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

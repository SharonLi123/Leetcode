package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class 全排列{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res=new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace=new LinkedList<>();
        backtrack(nums,trace);
        return res;
    }

    void backtrack(int[] nums,LinkedList<Integer> trace){
        int len=nums.length;

        if(trace.size()==len){
            res.add(new LinkedList<>(trace));
            return;
        }
        //遍历所有nums中的元素
        for(int i=0;i<len;i++){
            if(trace.contains(nums[i])){
                continue;
            }
            trace.add(nums[i]);
            backtrack(nums,trace);
            trace.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

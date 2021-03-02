package leetcode.editor.cn;

import java.util.HashMap;

public class 目标和{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<String,Integer> memo=new HashMap<>();
    public int findTargetSumWays(int[] nums, int S) {
        return traverse(nums,0,S);
    }

    int traverse(int[] nums,int n,int target){
        if(nums.length==n){
            if(target==0){
                return 1;
            }
            return 0;
        }

        if(memo.containsKey(n+","+target)){
            return memo.get(n+","+target);
        }

        //加
        int r1=traverse(nums,n+1,target-nums[n]);
        //减
        int r2=traverse(nums,n+1,target+nums[n]);

        memo.put(n+","+target,r1+r2);
        return memo.get(n+","+target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

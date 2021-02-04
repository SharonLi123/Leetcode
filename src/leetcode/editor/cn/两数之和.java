package leetcode.editor.cn;

import java.util.HashMap;

public class 两数之和{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
         *target-nums[i] in nums[0]...nums[i-1]?
         * nums[0]...nums[i-1] store in hashmap
         */

        int len=nums.length;
        HashMap<Integer,Integer> store=new HashMap<>();
        for(int i=0;i<len;i++){
            int needNumeric=target-nums[i];
            if(store.containsKey(needNumeric)){
                return new int[]{store.get(needNumeric),i};
            }
            store.put(nums[i],i);
        }

        //返回 大小为2的数组
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

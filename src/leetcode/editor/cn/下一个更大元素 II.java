package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class 下一个更大元素 II{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        if(nums.length<=0){
            return new int[]{};
        }

        Deque<Integer> stack=new LinkedList<>();
        int n=nums.length;
        int[] res=new int[n];

        for(int i=2*n-1;i>=0;i--){

            while (!stack.isEmpty()){
                if(stack.peekFirst()>nums[i%n]){
                    res[i%n]=stack.peekFirst();
                    stack.offerFirst(nums[i%n]);
                    break;
                }else{
                    stack.pollFirst();
                }
            }

            if(stack.isEmpty()){
                res[i%n]=-1;
                stack.offerFirst(nums[i%n]);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

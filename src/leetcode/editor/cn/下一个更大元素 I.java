package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class 下一个更大元素 I{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack=new LinkedList<>();


        for(int i=nums2.length-1;i>=0;i--){

            while (!stack.isEmpty()){
                if(nums2[i]>stack.peekFirst()){
                    stack.pollFirst();
                }else {
                    map.put(nums2[i],stack.peekFirst());
                    stack.offerFirst(nums2[i]);
                    break;
                }
            }

            if(stack.isEmpty()){
                map.put(nums2[i],-1);
                stack.offerFirst(nums2[i]);
            }

        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }

        return nums1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

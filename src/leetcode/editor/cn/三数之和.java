package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 三数之和{
    public static void main(String[] args){
        Solution solution=new Solution();
        solution.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums,3,0,0);
    }

    public List<List<Integer>> nSum(int[] nums,int n,int start,int target){
        List<List<Integer>> res=new LinkedList<>();
        int len=nums.length;

        if(n<2 || len<n){
            return res;
        }

        if(n==2){
            int left=start;
            int right=len-1;
            while (left<right){
                int ls=nums[left];
                int rs=nums[right];
                int sum=nums[left]+nums[right];
                if(sum>target){
                    while (left<right && nums[right]==rs){
                        right--;
                    }
                }else if(sum<target){
                    while (left<right && nums[left]==ls){
                        left++;
                    }
                }else {
                    res.add(new LinkedList<Integer>(){{
                        add(ls);
                        add(rs);
                    }});
                    while (left<right && nums[left]==ls){
                        left++;
                    }
                    while (left<right && nums[right]==rs){
                        right--;
                    }
                }
            }
        }else{
            for(int i=start;i<len;i++){
                int newTarget=target-nums[i];
                List<List<Integer>> childRes=nSum(nums,n-1,i+1,newTarget);
                for(List<Integer> child:childRes){
                    child.add(nums[i]);
                    res.add(child);
                }
                while (i<len-1 && nums[i]==nums[i+1]){
                    i++;
                }
            }


        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

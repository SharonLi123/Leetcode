package leetcode.editor.cn;

import java.util.Arrays;

public class 最大二叉树{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return create(nums,0,nums.length-1);
    }

    public TreeNode create(int[] nums,int left,int right){

        if(left>right){
            return null;
        }
        //找出数组中最大的元素
        int pos= getMax(nums,left,right);

        TreeNode root=new TreeNode(nums[pos]);

        //左边排
        TreeNode leftNode=create(nums,left,pos-1);
        //右边排
        TreeNode rightNode=create(nums,pos+1,right);

        root.left=leftNode;
        root.right=rightNode;

        return root;

    }

    public int getMax(int[] nums,int left,int right){
        int max=left;
        for(int i=left;i<=right;i++){
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        return max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

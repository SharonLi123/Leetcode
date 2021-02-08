package leetcode.editor.cn;

import java.util.Arrays;

public class 从前序与中序遍历序列构造二叉树{
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder);
    }

    public TreeNode build(int[] preorder,int[] inorder){

        if(preorder.length==0){
            return null;
        }
        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        //造根
        TreeNode root=new TreeNode(preorder[0]);
        //在中序遍历中找到root的左和root的右
        int index=findEle(inorder,preorder[0]);

        //构造左边
        root.left=build(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        //构造右边
        root.right=build(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

        return root;
    }

    public int findEle(int[] inorder,int ele){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==ele){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

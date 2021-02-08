package leetcode.editor.cn;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 寻找重复的子树{
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

    HashMap<String,Integer> memo=new HashMap<>();
    List<TreeNode> result=new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    public String traverse(TreeNode root){
        if(root==null){
            return "#";
        }

        String leftT=traverse(root.left);
        String rightT=traverse(root.right);

        String curr=leftT + "," + rightT+ "," + root.val;
        int freq=memo.getOrDefault(curr,0);
        if(freq==1){
            result.add(root);
        }
        memo.put(curr,freq+1);

        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

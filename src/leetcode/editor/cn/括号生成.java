package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class 括号生成{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res=new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        char[] route=new char[n*2];
        traverse(route,0,n,n);
        return res;
    }

    void traverse(char[] route,int n,int left,int right){
        if(left==0 && right==0){
            res.add(new String(route));
            return;
        }

        if(left>0){
            route[n]='(';
            traverse(route,n+1,left-1,right);
        }
        if(left<right){
            route[n]=')';
            traverse(route,n+1,left,right-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

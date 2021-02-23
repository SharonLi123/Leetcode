package leetcode.editor.cn;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class N 皇后{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<String>> res=new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        //棋盘共有n行n列，选择放在当前行的哪一列，影响下一行皇后的摆放位置
        char[][] record=new char[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(record[i],'.');
        }
        backtrace(0,n,record);
        return res;
    }

    public void backtrace(int row,int n,char[][] record){

        if(row==n){
            LinkedList<String> curr=new LinkedList<>();
            for(int i=0;i<n;i++){
                 curr.add(new String(record[i]));
            }
            res.add(curr);
            return;
        }

        //选放在当前行的哪一列
        for(int col=0;col<n;col++){
            if(isValid(row,col,n,record)){
                record[row][col]='Q';
                backtrace(row+1,n,record);
                record[row][col]='.';
            }
        }
    }

    public boolean isValid(int row,int col,int n,char[][] record){
        int left=col-1,right=col+1;
        //验证当前列是否有效
        //验证当前左斜线
        //验证右斜线
        for(int x=row-1;x>=0;x--){
            if(record[x][col]=='Q' || (left>=0 && record[x][left--]=='Q') || (right<n && record[x][right++]=='Q')){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

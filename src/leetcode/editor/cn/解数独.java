package leetcode.editor.cn;
public class 解数独{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        traverse(board,0,0);
    }

    public boolean traverse(char[][] board,int r,int c){
        int n=board.length;
        int m=board[0].length;

        if(r==n){
            return true;
        }

        if(c==m){
            return traverse(board,r+1,0);
        }

        if(board[r][c]!='.'){
            return traverse(board,r,c+1);
        }

        for(char i='1';i<='9';i++){
            if(!isValid(board,r,c,i)){
                continue;
            }
            board[r][c]=i;
            if(traverse(board,r,c+1)){
                return true;
            }
            board[r][c]='.';
        }
        return false;
    }

    public boolean isValid(char[][] board,int r,int c,char alp){
        for(int i=0;i<board.length;i++){
            if(board[i][c]==alp){
                return false;
            }
            if(board[r][i]==alp){
                return false;
            }
            if(board[(r/3)*3+i/3][(c/3)*3+i%3]==alp){
                return false;
            }
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

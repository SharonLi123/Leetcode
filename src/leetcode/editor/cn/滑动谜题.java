package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 滑动谜题{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        String toS= intArrayToString(board);
        queue.add(toS);

        int time=0;
        while (!queue.isEmpty()){
            Queue<String> temp=new LinkedList<>();
            while (!queue.isEmpty()){
                String curr=queue.poll();
                if("123450".equals(curr)){
                    return time;
                }
                for(int idx=0;idx<curr.length();idx++){
                    if(curr.charAt(idx)=='0'){
                        String addRow=swap(curr,idx,1,0);
                        if(!visited.contains(addRow)){
                            temp.offer(addRow);
                        }

                        String subRow=swap(curr,idx,-1,0);
                        if(!visited.contains(subRow)){
                            temp.offer(subRow);
                        }

                        String addCol=swap(curr,idx,0,1);
                        if(!visited.contains(addCol)){
                            temp.offer(addCol);
                        }

                        String subCol=swap(curr,idx,0,-1);
                        if(!visited.contains(subCol)){
                            temp.offer(subCol);
                        }

                    }
                }
                visited.add(curr);
            }
            time++;
            queue.addAll(temp);
        }
        return -1;
    }

    String swap(String curr,int idx,int row,int col){
        char[] cs=curr.toCharArray();
        if(row==1 && col==0){
            if(idx<3){
                cs[idx]=cs[idx+3];
                cs[idx+3]='0';
            }
        }else if(row==-1 && col==0){
            if(idx>=3){
                cs[idx]=cs[idx-3];
                cs[idx-3]='0';
            }
        }else if(row==0 && col==1){
            if(idx!=2 && idx!=5){
                cs[idx]=cs[idx+1];
                cs[idx+1]='0';
            }
        }else if(row==0 && col==-1){
            if(idx!=0 && idx!=3){
                cs[idx]=cs[idx-1];
                cs[idx-1]='0';
            }
        }
        return new String(cs);
    }

    public String intArrayToString(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

package leetcode.editor.cn;
public class 零钱兑换 II{
    public static void main(String[] args){
        Solution solution=new Solution();
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];

        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j-coins[i-1]>=0){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

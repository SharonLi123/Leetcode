package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

public class 有效的括号{
    public static void main(String[] args){
        Solution1 solution=new Solution1();
        System.out.println(solution.isValid("([)]"));
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        LinkedList<Character> stack=new LinkedList<>();
        for(Character c:s.toCharArray()){
            if(map.containsKey(c)){
                stack.offerFirst(c);
                continue;
            }

            Character top=stack.pollFirst();
            if(top!=null && c.equals(map.get(top))){
                continue;
            }

            return false;
        }

        return stack.isEmpty()?true:false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

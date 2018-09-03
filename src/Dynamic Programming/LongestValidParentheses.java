import java.util.Stack;

public class LongestValidParentheses {

 public int longestValidParentheses(String s) {
        Stack<Parenthese> stk = new Stack<Parenthese>();
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            //遇到左括号，将其push进栈
            if(s.charAt(i)=='('){
                stk.push(new Parenthese(i, '('));
            } else {
           //遇到右括号，分类讨论
               //如果当前栈顶是左括号，则消去并计算长度
                if(!stk.isEmpty() && stk.peek().symb=='('){
                    int curLen = 0;
                    stk.pop(); // 先出栈,然后计算长度！
                    if(stk.isEmpty()){
                        curLen = i + 1; // 所有括号都已经出栈。
                    } else {
                        curLen = i - stk.peek().indx; //还有部分括号未被匹配到
                    }
                    maxLen = Math.max(maxLen, curLen);
                } else {
               //如果栈顶是右括号或者是空栈，则将右括号也push进栈，它的坐标将方便之后计算长度
                    stk.push(new Parenthese(i, ')'));
                }
            }
        }
        return maxLen;
    }

    public class Parenthese {
        int indx;
        char symb;
        public Parenthese (int i, char s){
            this.indx = i;
            this.symb = s;
        }
    }


}

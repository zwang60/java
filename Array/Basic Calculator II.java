Basic Calculator II
/*
e.g. " 3+5 / 2 " = 5
如果是数字，就继续累加，如果是符号就跟栈顶元素计算后结果保存到栈里。num的符号要记录在sign里面，sign初始值是’+‘
reference:
https://leetcode.com/discuss/41902/share-my-java-solution
*/
public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for(int i : stack){
            res += i;
        }
        return res;
    }
}

Basic Calculator
/*
e.g. "(1+(4+5+2)-3)+(6+8)" = 23
Simple iterative solution by identifying characters one by one. One important thing is that the input is valid, which means the parentheses are always paired and in order. Only 5 possible input we need to pay attention:

digit: it should be one digit from the current number
'+': number is over, we can add the previous number and start a new number
'-': same as above
'(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.
Finally if there is only one number, from the above solution, we haven't add the number to the result, so we do a check see if the number is zero.
reference:
https://leetcode.com/discuss/39553/iterative-java-solution-with-stack
*/
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int number = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number * 10 + s.charAt(i) - '0';
            }else if(c == '+'){
                result += sign * number;
                sign = 1;
                number = 0;
            }else if(c == '-'){
                result += sign * number;
                sign = -1;
                number = 0;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(number != 0){
            result += sign * number;
        }
        return result;
    }
}
/*
a better solution:
reference:
https://leetcode.com/discuss/41868/java-solution-stack
My approach is based on the fact that the final arithmetic operation on each number is not only depend on the sign directly operating on it, but all signs associated with each unmatched '(' before that number.

e.g. 5 - ( 6 + ( 4 - 7 ) ), if we remove all parentheses, the expression becomes 5 - 6 - 4 + 7.

sign:

6: (-1)(1) = -1

4: (-1)(1)(1) = -1

7: (-1)(1)(-1) = 1

The effect of associated signs are cumulative, stack is builded based on this. Any improvement is welcome.
*/
public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int sign = 1;
        int rs = 0;
        stack.push(1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') continue;
            if(s.charAt(i) == '('){
                stack.push(stack.peekFirst() * sign);
                sign = 1;
            }else if(s.charAt(i) == ')') stack.pop();
            else if(s.charAt(i) == '+') sign = 1;
            else if(s.charAt(i) == '-') sign = -1;
            else{
                int temp = s.charAt(i) - '0';
                while((i + 1 < s.length()) && Character.isDigit(s.charAt(i+1)))
                    temp = temp * 10 + s.charAt(++i) - '0';
                rs += temp * stack.peekFirst() * sign;
            }
        }
        return rs;
    }
}
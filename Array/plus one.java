plus one
/*
考虑到可能有进位，所以要重新定义一个结果数组，长度大于原数组一位。
算法是从后往前加，最后一位加1，如果大于10，就设置carry=1，
其余每一位加carry，如果大于10，就设置carry=1，第一位，不必特殊处理
上面这样做不行

reference：
http://codesniper.blogspot.com/2015/03/68plus-one-leetcode.html

Solution:
The integer was stored in an array. A number plus one may have +1 length but only when the number is 9 or 99....
And also the carry will only happen when there are trailing '9'. 
So check from the end of the array to start until the digit is not '9', 
if all digits are '9', initiate a new array with length+1, and initiate it with res[0]=1;
else, initiate a new array with original length, and set the first non '9' with res[ind]=num[i]+1, set res[ind+1] to res[end] to 0 (by default they are already 0) and copy all the numbers from 0 to ind-1 from num to res.
Time complexity: O(n)
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return null;
        }
        int i = digits.length - 1;
        while(i >= 0 && digits[i] == 9){
            i--;
        }
        if(i == -1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        int[] res = new int[digits.length];
        res[i] = digits[i]+1;
        for(int j = i-1; j >= 0; j--){
            res[j] = digits[j];
        }
        return res;
    }
}
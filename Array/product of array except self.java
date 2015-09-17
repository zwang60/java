238 product of array except self
/*
better solution:
for example: [1,2,3,4], 
用两层for循环，第一次第一个位置是1，从第二个位置开始，每个位置保存它左边（不包括它本身）所有元素的乘积，[1,1,2,6]
第二次从上次结果倒数第二个位置开始继续乘积计算，因为最后一个就是结果，每个位置乘以数组中i+1位置的元素[24, 12, 8, 6]
最后得到的结果：[24,12,8,6]
时间复杂度O(n)，空间复杂度：O(1)

The idea is simply. The product basically is calculated using the numbers before
the current number and the numbers after the current number. Thus, we can scan
the array twice. First, we calcuate the running product of the part before the
current number. Second, we calculate the running product of the part after the
current number through scanning from the end of the array. reference:
https://leetcode.com/discuss/53781/my-solution-beats-100%25-java- solutions 
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++)
            res[i] = res[i - 1] * nums[i - 1];
        int post = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            res[i] *= post;
            post *= nums[i];
        }
        return res;
    }
}
/*
store multiple results in array to a variable total
divide by each of the elemen to get the result
*/
//能过OJ，但不是很好(用了除法)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[nums.length];
        int total = nums[0], zero = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
                continue;
            }
            total *= nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(zero > 1){
                result[i] = 0;
                continue;
            }
            if(nums[i] == 0){
                result[i] = total;
            }else if(zero == 1){
                result[i] = 0;
            }else{
                result[i] = total / nums[i];
            }
        }
        return result;
    }
}








remove element
/*
需要维护一个index，保存当前删掉等于target走到的位置，最后返回这个index

reference:
http://codesniper.blogspot.com/2015/01/27-remove-element-leetcode.html
Solution:
This problem is very similar to 26. Remove Duplicates from Sorted Array Leetcode 
 
Instead of maintaining an non-duplicates index, we maintain the index for the elements 
which are not equal to the target value. The code is also very similar.
*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ind = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[ind] = nums[i];
                ind++;
            }
        }
        return ind;
    }
}
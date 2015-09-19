remove duplicates from sorted array II
/*
Follow up for "Remove Duplicates"
跟1一样，只是增加一个count，控制在2以内，直到下一个元素

reference:
http://codesniper.blogspot.com/2015/03/80-remove-duplicates-from-sorted-array.html

Solution:
Follow up for 
26. Remove Duplicates from Sorted Array Leetcode

An additional counter is needed to track the numbers of duplicates, once the counter is greater than 2, 
do not increment the index until a new value occur. 
Time complexity: O(n)
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ind = 0, count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[ind] != nums[i]){
                ind++;
                nums[ind] = nums[i];
                count = 1;
            }else if(nums[ind] == nums[i] && count < 2){
                ind++;
                nums[ind] = nums[i];
                count++;
            }
        }
        return ind+1;
    }
}
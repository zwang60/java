remove duplicates from sorted array
/*
从前往后遍历数组，用index记录当前没有重复元素的位置，碰到重复元素continue，最后返回index长度。时间复杂度O(n)

类似题：27. Remove Element

reference：
http://codesniper.blogspot.com/2015/01/26-remove-duplicates-from-sorted-array.html

The algorithm is to maintain a non duplicates elements index, move non-duplicate elements to the index position. 
After one time iteration all elements from 0 to our index will be non-duplicates.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ind = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[ind] = nums[i];
                ind++;
            }
        }
        return ind;
    }
}

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ind = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[ind] != nums[i]){
                ind++;
                nums[ind] = nums[i];
            }
        }
        return ind+1;
    }
}
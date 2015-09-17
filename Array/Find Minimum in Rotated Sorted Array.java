find minimum in rotated sorted array
/*
还是二分法，时间复杂度O(logn)，空间复杂度O(1)
*/
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = nums.length - 1, mid;
        while(start + 1 < end){
            mid = (start + end)/2;
            if(nums[mid] > nums[end]){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] < nums[end]){
            return nums[start];
        }
        return nums[end];
    }
}
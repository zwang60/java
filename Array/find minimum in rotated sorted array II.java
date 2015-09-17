find minimum in rotated sorted array II
/*
跟1一样，binary search，只是头尾如果跟中间相等则++或者--就可以了
*/
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length - 1, mid;
        while(left + 1 < right){
            mid = (left + right)/2;
            if(nums[left] == nums[mid]){
                left++;
            }else if(nums[right] == nums[mid]){
                right--;
            }else if(nums[mid] > nums[right]){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[left] < nums[right]){
            return nums[left];
        }
        return nums[right];
    }
}
search in rotated sorted array
/*
在数组中查找某个数，最好的方法就是二分法，时间复杂度O(logn)

reference:
http://codesniper.blogspot.com/2015/03/33-search-in-rotated-sorted-array.html
Solution:
All related problems:
33. Search in Rotated Sorted Array
81. Search in Rotated Sorted Array II 
153. Find Minimum in Rotated Sorted Array
154. Find Minimum in Rotated Sorted Array II
Modified binary search
If we compare the middle element with the right element, we can determine which part of the array is sorted. 
Eg. the example in the question 4,5,6,7,0,1,2. Middle element is 7 and is greater than the right element so the left part of the array is sorted, then we can check if the target is in the left part, if yes, update the right pointer, if no, update the left pointer. Vice versa. 
Time complexity: O(logn) each time we will cut the array half
*/
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1, mid;
        while(l + 1 < r){
            mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[r]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid;
                }else{
                    l = mid;
                }
            }else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid;
                }else{
                    r = mid;
                }
            }
        }
        if(nums[l] == target){
            return l;
        }
        if(nums[r] == target){
            return r;
        }
        return -1;
    }
}
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1, mid;
        while(l <= r){
            mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[r]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
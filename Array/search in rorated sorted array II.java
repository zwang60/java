search in rorated sorted array II
/*
依然是二分法，只不过遇到重复元素，如果跟mid相等就++或者--
时间复杂度O(logn),但是当所有元素都是相同元素的时候（除target），最坏时间复杂度是O(n)

reference:
http://codesniper.blogspot.com/2015/03/81-search-in-rotated-sorted-array-ii.html

Follow up for 33. Search in Rotated Sorted Array

All related problems:
33. Search in Rotated Sorted Array
81. Search in Rotated Sorted Array II 
153. Find Minimum in Rotated Sorted Array
154. Find Minimum in Rotated Sorted Array II

For those two cases: num[mid]<num[right](right part is sorted) or num[mid]>mid[right](left part is sorted), we can still cut the search range half as problem 33 suggested. 
However, when num[mid]==num[right], we can't cut either half of the array, because, both of them can contain the target. 
Eg. target is 1. Array A: {2,2,1,2,2,2,2} and Array B: {2,2,2,2,1,2,2}, both the arrays have the property of num[mid]==num[right], 
but right part of A is sorted and target is in left half, while right part of B is not sorted and target is in the right half. 
so when this case happens, we can only guarantee that, mid number and right number is not the target, and we can't cut the range half, 
so the worst time complexity will increase to O(n) which we have all same elements in the array but are not the target value.
Time complexity : O(n)
*/
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int l = 0, r = nums.length - 1, mid;
        while(l <= r){
            mid = (l+r)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[l] == nums[mid]){
                l++;
            }else if(nums[r] == nums[mid]){
                r--;
            }else if(nums[mid] > nums[r]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else if(nums[mid] < nums[r]){
                if(target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return false;
    }
}
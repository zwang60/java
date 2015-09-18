find peak element
/*
二分法，时间复杂度O(logn)

Solution:
The difficulty is to find the peak element in O(logn).
Since num[i]!=num[i+1], for a given middle element, num[m], there will be 4 cases:
1. num[m-1]<num[m]>num[m+1]: num[m] will be the peak element.
2. num[m-1]<num[m]<num[m+1]: there must exist a peak element in the right half. Let's think at that way, in order to make num[m+1] is not the peak element, the following must be true: num[m+1]<num[m+2]; similarly num[m+2] must < num[m+3]...so in order to make num[end-1] is not the peak element, num[end-1]< num[end], thus num[end] is the peak element, because we consider num[n]=-∞. there must exist a peak element in the right half and we can cut the left half.
3. num[m-1]>num[m]>num[m+1], similarly there must exist a peak element in the left half.
4. num[m-1]>num[m]<num[m+1], either half is OK.
When there is only 2 elements in the array, return the bigger one.
reference:
http://codesniper.blogspot.com/2015/04/161-find-peak-element-leetcode-java.html
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1, m;
        while(l + 1 < r){
            m = (l + r)/2;
            if(nums[m] > nums[m-1] && nums[m] > nums[m+1]){
                return m;
            }else if(nums[m] < nums[m+1]){
                l = m;
            }else{
                r = m;
            }
        }
        return nums[l] >= nums[r] ? l : r;
    }
}
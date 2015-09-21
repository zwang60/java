search for a range
/*
用两次二分法，分别向左右两边夹逼，
找左边界的时候，当target小于等于mid的时候r=mid，否则，l=mid+1
找右边界的时候，当target大于等于mid的时候l=mid，否则，r=mid-1
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0){
            return res;
        }
        int ll = 0, lr = nums.length - 1, mid;
        while(ll <= lr){
            mid = (ll+lr)/2;
            if(target <= nums[mid]){
                lr = mid-1;
            }else{
                ll = mid+1;
            }
        }
        int rl = 0, rr = nums.length - 1; 
        mid = 0;
        while(rl <= rr){
            mid = (rl+rr)/2;
            if(target >= nums[mid]){
                rl = mid+1;
            }else{
                rr = mid-1;
            }
        }
        if(ll <= rr){
            res[0] = ll;
            res[1] = rr;    
        }
        
        return res;
    }
}
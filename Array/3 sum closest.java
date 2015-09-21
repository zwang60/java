3 sum closest
/*
two pointer, S = {-1 2 1 -4}, sum[i] = nums[i] + nums[l] + nums[r]
sum == target
sum < target l++
sum > target r--
*/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE/2;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int l = i+1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    l++;
                }else{
                    r--;
                }
                ans = Math.abs(sum - target) < Math.abs(ans - target) ? sum : ans;
            }
        }
        return ans;
    }
}
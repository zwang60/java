jump game
/*
从第一个位置开始，maxreach记录当前能跳到的最大距离，i不仅要小于数组长度，还要在这个最大值之内
*/
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int maxreach = 0;
        for(int i = 0; i < nums.length && i <= maxreach; i++){
            maxreach = Math.max(maxreach, i + nums[i]);
        }
        return maxreach >= (nums.length - 1);
    }
}
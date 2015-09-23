jump game II
/*
step用来记录当前步数，reach用来记录当前能跳到的最大距离，maxreach每次更新的时候，step++，maxreach = i
参考：
http://codesniper.blogspot.com/2015/03/45-jump-game-ii-leetcode.html
Solution:
Dynamic programming
Using a variable to track the maximum index that current step can reach, and during the current step, 
calculate the maximum index that next step can reach. When it hits the maximum index of current step, 
update the current maximum to calculated next maximum index. When the maximum index >= A.length, return the steps.
Time complexity: O(n)
*/
public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int step = 0;
        int reach = 0, maxreach = 0;
        for(int i = 0; i < nums.length && i <= reach; i++){
            if(i > maxreach){
                step++;
                maxreach = reach;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        if(reach < nums.length - 1){
            return 0;
        }
        return step;
    }
}
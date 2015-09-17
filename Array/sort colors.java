sort colors *
/*
用partition的方法，先0和（1 2）分成两堆进行partition，然后1 和2分成两堆再进行partition
时间复杂度O(n), 空间复杂度O(1)
不太熟练
*/
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int pl = 0, pr = nums.length - 1, i = 0;
        while(i <= pr){
            if(nums[i] == 0){
                swap(nums, i, pl);
                i++;
                pl++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, pr);
                pr--;
            }
        }
    }
    public void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
wiggle sort
/*
first sort:
1 2 3 4 5 6
exchange one by one, from end to index
*/
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        int index = 1, temp = 0;
        while(index < nums.length){
            temp = nums[nums.length - 1];
            for(int i = nums.length - 2; i >= index; i--){
                nums[i+1] = nums[i];
            }
            nums[index++] = temp;
            index++;
        }
    }
}
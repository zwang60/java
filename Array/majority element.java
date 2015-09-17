majority element
/*
Set the first element of the array as the majority  and count=1, and go to the next element,

if the next element is same with the majority, set the count +1 and if the count>n/2, return majority;
if different, set the count-1, if the count=0, set next element as the majority and count be 1.
return the majority.
reference:
https://yusun2015.wordpress.com/2015/01/05/majority-element/
*/
public class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count > 0 && nums[i] != majority){
                count--;
            }else if(nums[i] == majority){
                count++;
            }else if(count <= 0){
                count = 1;
                majority = nums[i];
            }
        }
        return majority;
    }
}
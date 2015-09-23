next permutation
/*
如果找到所有permutation之后再找这个排序的后面的排序，一定可以做出来，但是这样做时间复杂度是O(n^2)
有没有可以优化的地方
参考：
http://codesniper.blogspot.com/search?q=next+permutation
Solution:
This problem is kind of find the relation between the given permutation with the next permutation.
Eg. 2,4,7,6,5,3,1
The pattern is 
1. Find the first num from right to left that is not in ascending order, which is 4 in my example record the position start=1
2. Then find the next number which is bigger than 4, which is 5
3. swap those two numbers-> 2,5,7,6,4,3,1
4 reverse the part of the array from(start(1) to end) -> 2,5,1,3,4,6,7
The start is initiated with 0, so if in the first step, we can't find the right number, it will reverse the whole array just like the problem required 3,2,1-> 1,2,3
Time Complexity(O(n))
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int start = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i > 0 && nums[i] >nums[i-1]){
                start = i;
                int j = i;
                while(j < nums.length && nums[j] > nums[i-1]) j++;
                int temp = nums[j-1];
                nums[j-1] = nums[i-1];
                nums[i-1] = temp;
                break;
            }
        }
        reverse(nums, start);
    }
    public void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
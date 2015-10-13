two sum II
/*
分析：
已经排好序的数组，找到sum=target的两个数的index，可以用对撞型指针来做，时间复杂度O(n)
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return null;
        }
        int[] index = new int[2];
        int i = 0, j = numbers.length - 1, sum = 0;
        while(i < j){
            sum = numbers[i] + numbers[j];
            if(sum < target){
                i++;
            }else if(sum > target){
                j--;
            }else if(sum == target){
                index[0] = i+1;
                index[1] = j+1;
                return index;
            }
        }
        return null;
    }
}
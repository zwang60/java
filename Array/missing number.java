missing number
/*
先sort，如果第一个元素大于0，返回这个数减一
找到最大元素，求得从0到这个元素的sum，用这个sum减去所有元素的和，
如果差不等于0，就是missing number，如果等于0，就返回最大元素+1

参考：
http://bookshadow.com/weblog/2015/08/24/leetcode-missing-number/
https://leetcode.com/discuss/56174/3-different-ideas-xor-sum-binary-search-java-code
Summary:
If the array is in order, I prefer Binary Search method. Otherwise, the XOR method is better.
*/
1.XOR
解法II：位运算（异或运算）
public int missingNumber(int[] nums) { //xor
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
    }
    return res;
}
2.SUM
解法I：等差数列前n项和 - 数组之和
public int missingNumber(int[] nums) { //sum
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
        sum-=nums[i];
    return sum;
}
3.Binary Search
public int missingNumber(int[] nums) { //binary search
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}
另一种写法：
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid;
        while(left + 1 < right){
            mid = (left + right)/2;
            if(nums[mid] <= mid){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[left] == left){
            return left+1;
        }
        return left;
    }
}

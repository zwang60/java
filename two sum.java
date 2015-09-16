two sum
/*
最简单的解法就是brute force，两层for循环，时间复杂度O(n^2)
优化方法：
从数据结构上优化，可以用hashmap提高查找效率，时间复杂度O(n)，空间复杂度O(n)：
*/
//pseudocode
if map.contains(target - nums[i])
index[0] = map.get(target - nums[i]);
index[1] = i;
return index;
else map.put(nums[i], i);

//code
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        if(nums == null || nums.length == 0){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                index[0] = map.get(target - nums[i]) + 1;
                index[1] = i + 1;
                return index;
            }else{
                map.put(nums[i], i);
            }
        }
        return index;
    }
}
/*
从算法上优化，可以用two pointer的方法：
先sort，然后两指针一头一尾，直到sum等于target
but，这题返回的是index，不能sort，所以这种方法不能用
参考：
http://codeganker.blogspot.com/2014/02/two-sum-leetcode.html
*/
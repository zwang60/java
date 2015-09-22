Contains Duplicate II
/*
在一堆数里面查找元素，如果用hashmap，map里面没有相等的就保存，map里找到相等的，比一下坐标是不是小于k
这种方法一定能过，但是有没有更好的解法，看来似乎没有了
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int dis = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                int index = map.get(nums[i]);
                if(i - index <= k){
                    return true;
                }else if(i - index > k){
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
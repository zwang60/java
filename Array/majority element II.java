majority element II
/*
出现频率多于1/3的元素，可能有两个，所以要定义两个candidate。用两个count分别统计他们出现的次数，如果等于就加，不等于同时减，一个为0就给他赋值。
最后重新数一遍两个candidate保存的数，是否都多于1/3
时间复杂度O(n)
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && nums[i] != candidate2){
                candidate1 = nums[i];
            }
            if(count2 == 0 && nums[i] != candidate1){
                candidate2 = nums[i];
            }
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }
            if(nums[i] == candidate2){
                count2++;
            }
        }
        if(count1 > nums.length/3){
            res.add(candidate1);
        }
        if(count2 > nums.length/3 && candidate1 != candidate2){
            res.add(candidate2);
        }
        return res;
    }
}
combination sum III
/*
感觉是subset一类的问题，画子树来判断，当深度为k的时候如果不是就继续其他分支，如果是就加到结果里
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //数字少直接枚举，数字多就循环赋值
        dfsHelper(nums, k, n, 0, new ArrayList<>(), res);
        return res;
    }
    public void dfsHelper(int[] nums, int k, int target, int pos, List<Integer> list, List<List<Integer>> res){
        if(target == 0 && list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos; i < nums.length; i++){
            if(nums[i] > target || list.size() >= k){
                break;
            }
            list.add(nums[i]);
            dfsHelper(nums, k, target - nums[i], i+1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
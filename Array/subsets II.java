subsets II *
/*
跟subsets 1一样要用DFS找到所有集合，但是现在又增加了又重复元素的情况，所以当遇到重复的时候，
只对第一个重复元素进行DFS，把子集加到结果集中，之后的直接跳过。时间复杂度是指数量级的。

这道题跟Subsets一样是经典的NP问题--求子集。重复元素集合的问题类似的还有Permutations II也是这样的，
当有重复元素出现的时候，只对第一个重复元素进行DFS，把子集加到结果集中，之后的直接跳过
reference：
http://blog.csdn.net/linhuanmars/article/details/24613193
*/
recursion
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        dfsHelper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    public void dfsHelper(int[] nums, int pos, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            dfsHelper(nums, i+1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
non-recursion *
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            int size = res.size();
            for(int j = start; j < size; j++){
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
            if(i < nums.length - 1 && nums[i] == nums[i+1]){
                start = size;
            }else{
                start = 0;
            }
        }
        return res;
    }
}
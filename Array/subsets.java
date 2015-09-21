subsets
/*
要求所有集合，所以可以用DFS，对每个元素有两种情况，要么选择，要么不选择，每个节点都是一个答案，时间复杂度O(2^n)
reference:
http://codeganker.blogspot.com/2014/04/subsets-leetcode.html
求子集问题是经典的NP问题，复杂度上我们就无法强求了哈，肯定是非多项式量级的。一般来说这个问题有两种解法：递归和非递归。

我们先来说说递归解法，主要递推关系就是假设函数返回递归集合，现在加入一个新的数字，我们如何得到包含新数字的所有子集。
其实就是在原有的集合中对每集合中的每个元素都加入新元素得到子集，然后放入原有集合中（原来的集合中的元素不用删除，因为他们也是合法子集）。
而结束条件就是如果没有元素就返回空集（注意空集不是null，而是没有元素的数组）就可以了。时间和空间都是取决于结果的数量，也就是O(2^n)
其实非递归解法的思路和递归是一样的，只是没有回溯过程，也就是自无到有的一个个元素加进来，然后构造新的子集加入结果集中

这种NP问题算法上都没有什么大的提高，基本上就是考察对于递归和非递归解法的理解，都是和N-Queens一个套路，掌握之后就没什么难度哈。
*/
recursion
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        Helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    public void Helper(int[] nums, int pos, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            Helper(nums, i+1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
non-recursion
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
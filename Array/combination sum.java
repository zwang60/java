combination sum
/*
求所有集合，所以可以用DFS，时间复杂度是指数量级的

参考：
http://codeganker.blogspot.com/2014/03/combination-sum-leetcode.html
原题链接: http://oj.leetcode.com/problems/combination-sum/ 
这个题是一个NP问题，方法仍然是N-Queens中介绍的套路。基本思路是先排好序，然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，
然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。算法复杂度因为是NP问题，所以自然是指数量级的。

注意在实现中for循环中第一步有一个判断，那个是为了去除重复元素产生重复结果的影响，因为在这里每个数可以重复使用，所以重复的元素也就没有作用了，
所以应该跳过那层递归。这道题有一个非常类似的题目Combination Sum II，有兴趣的朋友可以看看，一次搞定两个题哈。
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        dfsHelper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    public void dfsHelper(int[] candidates, int pos, int target, List<Integer> list, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos; i < candidates.length; i++){
            if(target < candidates[i]){
                break;
            }
            list.add(candidates[i]);
            dfsHelper(candidates, i, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
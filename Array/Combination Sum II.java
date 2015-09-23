Combination Sum II
/*
先排序，subsets的模板
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if(target < 0){
            return;
        }
        for(int i = pos; i < candidates.length; i++){
            if(i != pos && candidates[i] == candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            dfsHelper(candidates, i+1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
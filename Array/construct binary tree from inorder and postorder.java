construct binary tree from inorder and postorder traversal
/*
inorder只要知道root的位置，就能找到左右子树，所以要把inorder作为要查找的树，所以把它保存到hashmap里面
postorder可以知道root的位置
这样根节点就是：postorder[postr], index: map.get(root.val)
左子树: inorder: inl, index-1, postorder: postl, postl + index - inl - 1
右子树: inorder: index+1, inr, postorder: postl + index - inl, postr-1
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    public TreeNode build(int[] inord, int inl, int inr, int[] postord, int postl, int postr, HashMap<Integer, Integer> map){
        if(inl > inr || postl > postr){
            return null;
        }
        TreeNode root = new TreeNode(postord[postr]);
        int index = map.get(root.val);
        root.left = build(inord, inl, index - 1, postord, postl, postl + index - inl - 1, map);
        root.right = build(inord, index+1, inr, postord, postl + index - inl, postr-1, map);
        return root;
    }
}
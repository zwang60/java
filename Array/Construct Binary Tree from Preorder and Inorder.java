Construct Binary Tree from Preorder and Inorder Traversal
/*
只要知道root，就可以从inorder可以得到左右子树，inorder就可以用来查找，保存到hashmap里面
preorder第一个元素一定是根节点，所以preorder可以用来提取根节点
依次递归
root = new node(preorder[prel])
index = map.get(root.val);
left tree: inorder: inl, index - 1, preorder: prel+1, prel + index - inl
right tree: inorder: index + 1, inr, preorder: prel + index - inl+1, prer
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
    }
    public TreeNode build(int[] inord, int inl, int inr, int[] preord, int prel, int prer, HashMap<Integer, Integer> map){
        if(inl > inr || prel > prer){
            return null;
        }
        TreeNode root = new TreeNode(preord[prel]);
        int index = map.get(root.val);
        root.left = build(inord, inl, index - 1, preord, prel+1, prel+index-inl, map);
        root.right = build(inord, index + 1, inr, preord, prel+index-inl+1, prer, map);
        return root;
    }
}
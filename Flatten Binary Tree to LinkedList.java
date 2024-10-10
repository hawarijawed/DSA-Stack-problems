/*
Given the root of a binary tree, flatten the tree into a "linked list":
The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
*/
class Solution {
    public void traverse(TreeNode root, Queue<TreeNode> queue){
        if(root == null){
            return;
        }
        queue.add(root);
        traverse(root.left, queue);
        traverse(root.right, queue);
    }
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        traverse(root, queue);
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            temp.right = queue.peek();
            temp.left = null;
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        TreeNode temp1=null;
        TreeNode temp2=null;
        q1.add(p);
        q2.add(q);
        while(!q1.isEmpty() && !q2.isEmpty())
        {
            temp1=q1.peek();
            q1.remove();
            temp2=q2.peek();
            q2.remove();
            if(temp1!=null && temp2!=null)
            {
                if(temp1.val==temp2.val)
                {
                    q1.add(temp1.left);
                    q1.add(temp1.right);
                    q2.add(temp2.left);
                    q2.add(temp2.right);   
                }
                else
                    return false;
            }
           else if(temp1==null && temp2==null)
                continue;
            else if(temp1==null && temp2!=null)
                return false;
            else if(temp1!=null && temp2==null)
                return false;   
        }
        return true;
        
    }
}

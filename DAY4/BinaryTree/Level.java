package DAY4.BinaryTree;
import java.util.*;

public class Level {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> outer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i<n; i++){
                TreeNode node = q.poll();
                inner.add(node.val);

                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            outer.add(inner);
        }
        return outer;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        List<List<Integer>> ans = levelorder(root);
        for(List<Integer> inner : ans){
            System.out.println(inner);
        }
    }
}

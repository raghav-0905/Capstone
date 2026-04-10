package DAY4.BinaryTree;
import com.sun.source.tree.Tree;

import java.util.*;
public class InvertTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null)return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                sb.append("null ");
                continue;
            }

            sb.append(node.val + " ");

            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null)return null;
        int idx = 1;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!values[idx].equals("null")){
                TreeNode leftc = new TreeNode(Integer.parseInt(values[idx]));
                node.left = leftc;
                q.offer(leftc);
            }
            idx++;

            if(!values[idx].equals("null")){
                TreeNode rightc = new TreeNode(Integer.parseInt(values[idx]));
                node.right = rightc;
                q.offer(rightc);
            }
            idx++;
        }
        return root;
    }
    static TreeNode invert(TreeNode root){
        if(root==null)return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);

        return root;
    }
    static boolean isInvert(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null ){
            return false;
        }

        return root1==root2 && isInvert(root1.left,root2.right) && isInvert(root1.right,root2.left);

    }

    public static void main(String[] args) {
        TreeNode root = deserialize("10 20 30 40 null null 50 null null null null");
        TreeNode temp = deserialize("10 20 30 40 null null 50 null null null null");
        invert(root);


        System.out.println(serialize(root));
        System.out.println(serialize(temp));
        System.out.println(isInvert(root,temp));
    }
}

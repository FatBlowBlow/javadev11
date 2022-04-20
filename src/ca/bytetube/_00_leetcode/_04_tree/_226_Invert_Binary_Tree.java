package ca.bytetube._00_leetcode._04_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class _226_Invert_Binary_Tree {

    //Preorder
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    //Postorder
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;

        invertTree2(root.left);
        invertTree2(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    //!!!!Inorder
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return root;
        invertTree3(root.left);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree3(root.left);//因为先invert左树，所以现在的root right = 之前的root left
        return root;
    }

    //LevelOrder
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node  = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }


}


package main;

public class treeProblems {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     */

    /**
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * 输出: 4
     */
    int k, res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k-- == 1) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}

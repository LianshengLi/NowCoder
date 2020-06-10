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
    //BST中序遍历的输出是节点从小到大递增 所以如果求第K大节点要反过来遍历后，中，左
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
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     */
    TreeNode result = null;
    int k1;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null) return null;
        k1 = k;
        dfsHelper(pRoot);
        return result;
    }
    void dfsHelper(TreeNode root){
        if(root == null) return;
        dfsHelper(root.left);
        if(k1-- == 1){
            result = new TreeNode(root.val);
        }
        dfsHelper(root.right);
    }

    /**
     * 较难 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
     *
     * 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
     *
     * 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。
     *
     * 必须的递增步长为1的路径
     */
    /**
     * 示例 1：
     *
     * 输入:
     *
     *    1
     *     \
     *      3
     *     / \
     *    2   4
     *         \
     *          5
     *
     * 输出: 3
     *
     * 解析: 当中，最长连续序列是 3-4-5，所以返回结果为 3
     * 示例 2：
     *
     * 输入:
     *
     *    2
     *     \
     *      3
     *     /
     *    2
     *   /
     *  1
     *
     * 输出: 2
     *
     * 解析: 当中，最长连续序列是 2-3。注意，不是 3-2-1，所以返回 2。
     */
    private int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLength;
    }

    private void dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) return;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        maxLength = Math.max(maxLength, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }

    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     *
     * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
     * 从而使得内存中建立起来的二叉树可以持久保存。
     * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
     * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
     */
    String Serialize(TreeNode root) {

    }
    TreeNode Deserialize(String str) {

    }
}

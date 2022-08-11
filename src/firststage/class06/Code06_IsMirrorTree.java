package firststage.class06;

public class Code06_IsMirrorTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null ^ q == null) {
            return false;
        }
        if(q == null && p == null) {
            return true;
        }
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    public static void main(String[] args) {

    }
}

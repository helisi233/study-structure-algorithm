package firststage.class06;

public class Code05_IsSameTree {

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null ^ q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}

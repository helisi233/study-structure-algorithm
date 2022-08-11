package firststage.class06;

public class Code07_MaximumDepthOfBinaryTree {

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

    public static TreeNode generateTree() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        return head;
    }

    public static int maximumDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depth = 1;
        return Math.max(maximumDepth(root.left), maximumDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}

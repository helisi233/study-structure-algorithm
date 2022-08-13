package firststage.class07;

public class Code03_PathSum {

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

    public static boolean isSum = false;

    public static void process(TreeNode node, int preSum, int sum) {
        if(node.left == null && node.right == null) {
            if(preSum + node.val == sum) {
                isSum = true;
            }
            return;
        }
        preSum += node.val;
        if(node.left != null) {
            process(node.left, preSum, sum);
        }
        if(node.right != null) {
            process(node.right, preSum, sum);
        }
    }

    public static boolean hasPathSum(TreeNode head, int sum) {
        if(head == null) {
            return false;
        }
        isSum = false;
        process(head, 0, sum);
        return isSum;
    }

    public static void main(String[] args) {

    }
}

package firststage.class06;

public class Code04_BinaryTree {

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

    public static TreeNode generateBinaryTree() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        return head;
    }

    // 递归序 每一个节点都被访问了3次
    // 先中后序都是从递归序加工来的
    public static void f(TreeNode head) {
        if(head == null) {
            return;
        }
        // 1.
        f(head.left);
        // 2.
        f(head.right);
        // 3.
    }

    public static void pre(TreeNode head) {
        if(head == null) {
            return;
        }
        System.out.print(head.val + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(TreeNode head) {
        if(head == null) {
            return;
        }
        pre(head.left);
        System.out.print(head.val + " ");
        pre(head.right);
    }

    public static void next(TreeNode head) {
        if(head == null) {
            return;
        }
        pre(head.left);
        pre(head.right);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        TreeNode treeNode = generateBinaryTree();
        pre(treeNode);
        System.out.println();
        in(treeNode);
        System.out.println();
        next(treeNode);
    }
}

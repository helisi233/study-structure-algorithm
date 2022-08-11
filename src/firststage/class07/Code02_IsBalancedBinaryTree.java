package firststage.class07;

public class Code02_IsBalancedBinaryTree {

    public static class TNode {
        int value;
        TNode left;
        TNode right;
        public TNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // 以某个节点为头的时候 是否是平衡二叉树 高度
    public static class BalancedInfo {
        boolean isBalanced;
        int height;
        public BalancedInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static BalancedInfo balancedProcess(TNode node) {
        if(node == null) {
            return new BalancedInfo(true, 0);
        }
        BalancedInfo leftInfo = balancedProcess(node.left);
        BalancedInfo rightInfo = balancedProcess(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new BalancedInfo(isBalanced, height);
    }

    public static boolean isBalanced(TNode head) {
        return balancedProcess(head).isBalanced;
    }

    public static class SearchInfo {
        int max;
        int min;
        boolean isBST;
        public SearchInfo(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public static SearchInfo searchProcess(TNode node) {
        if(node == null) {
            return null;
        }
        SearchInfo leftInfo = searchProcess(node.left);
        SearchInfo rightInfo = searchProcess(node.right);
        int max = node.value;
        int min = node.value;
        boolean isBST = true;
        if(leftInfo != null) {
            max = Math.max(node.value, leftInfo.max);
            min = Math.min(node.value, leftInfo.min);
        }
        if(rightInfo != null) {
            max = Math.max(node.value, rightInfo.max);
            min = Math.min(node.value, rightInfo.min);
        }
        if(leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if(rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        boolean leftMaxLessNode = leftInfo == null ? true : (leftInfo.max < node.value);
        boolean rightMinMoreNode = rightInfo == null ? true : (rightInfo.min > node.value);
        if(!leftMaxLessNode || !rightMinMoreNode) {
            isBST = false;
        }
        return new SearchInfo(max, min, isBST);
    }

    public static boolean isBST(TNode head) {
        return searchProcess(head).isBST;
    }

    public static void main(String[] args) {

    }
}

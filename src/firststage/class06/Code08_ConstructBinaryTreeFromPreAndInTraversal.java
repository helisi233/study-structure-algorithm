package firststage.class06;

import firststage.utils.ListUtils;

import java.util.HashMap;

public class Code08_ConstructBinaryTreeFromPreAndInTraversal {

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

    public static TreeNode buildTree(int[] pre, int[] in) {
        if(pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public static TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        if(l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if(l1 == r1) {
            return head;
        }
        int find = l2;
        while(in[find] != pre[l1]) {
            find ++;
        }
        head.left = f(pre, l1+1, l1+find-l2, in, l2, find-1);
        head.right = f(pre, l1+find-l2+1, r1, in, find+1, r2);
        return head;
    }

    public static TreeNode buildTree2(int[] pre, int[] in) {
        if(pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }
        return g(pre, 0, pre.length-1, in, 0, in.length-1, valueIndexMap);
    }

    public static TreeNode g(int[] pre, int l1, int r1, int[] in, int l2, int r2, HashMap<Integer, Integer> map) {
        if(l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if(l1 == r1) {
            return head;
        }
        int find = map.get(pre[l1]);
        head.left = g(pre, l1+1, l1+find-l2, in, l2, find-1, map);
        head.right = g(pre, l1+find-l2+1, r1, in, find+1, r2, map);
        return head;
    }

    public static void prePrint(TreeNode head) {
        if(head == null) {
            return;
        }
        System.out.print(head.val + " ");
        prePrint(head.left);
        prePrint(head.right);
    }

    public static void main(String[] args) {
        int[] preArray = {1,2,4,5,3,6,7};
        int[] inArray = {4,2,5,1,6,3,7};
        TreeNode treeNode = buildTree(preArray, inArray);
        prePrint(treeNode);
    }
}

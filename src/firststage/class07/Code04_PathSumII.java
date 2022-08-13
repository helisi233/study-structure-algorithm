package firststage.class07;

import java.util.ArrayList;
import java.util.List;

public class Code04_PathSumII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode head, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(head == null) {
            return null;
        }
        return ans;
    }

    public static void process(TreeNode node, List<Integer> path, int presum, int sum, List<List<Integer>> ans) {
        if(node.left == null && node.right == null) {
            if(node.val + presum == sum) {
                path.add(node.val);
                ans.add(copy(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(node.val);
        presum += node.val;
        if(node.left != null) {
            process(node.left, path, presum, sum, ans);
        }
        if(node.right != null) {
            process(node.right, path, presum, sum, ans);
        }
        path.remove(path.size()-1);
    }

    public static List<Integer> copy(List<Integer> path) {
        List<Integer> newpath = new ArrayList<>();
        for (Integer ele : path) {
            newpath.add(ele);
        }
        return newpath;
    }

    public static void main(String[] args) {

    }
}

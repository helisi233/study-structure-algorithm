package firststage.class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code01_BinaryTreeLevelOrderTraversalll {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     *  期望返回
     *  {
     *      {11,12},
     *      {7,8,9,10},
     *      {4,5,6},
     *      {2,3},
     *      {1}
     *  }
     * */
    public static TreeNode generateTreeNode() {
        TreeNode head = new TreeNode(1);
        // 第二层
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        // 第三层
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        // 第四层
        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(8);
        head.right.left.right = new TreeNode(9);
        head.right.right.right = new TreeNode(10);
        // 第五层
        head.right.left.right.right = new TreeNode(11);
        head.right.right.right.left = new TreeNode(12);
        return head;
    }

    public static List<List<Integer>> levelOrderTravel(TreeNode head) {
        if(head == null) {
            return null;
        }
        // 最终返回的列表
        List<List<Integer>> results = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 每一层的结果列表
            List<Integer> levelResult = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = queue.poll();
                levelResult.add(pollNode.value);
                if(pollNode.left != null) {
                    queue.add(pollNode.left);
                }
                if(pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }
            results.add(0, levelResult);
        }
        return results;
    }

    public static void printResults(List<List<Integer>> results) {
        System.out.println("{");
        for (List<Integer> list : results) {
            System.out.print("{");
            for (Integer value : list) {
                System.out.print(value + ",");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        TreeNode head = generateTreeNode();
        List<List<Integer>> lists = levelOrderTravel(head);
        printResults(lists);
    }
}

public class Tree02 {

    /**
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     * 二叉搜索树左节点比根节点小，右节点比根节点大
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("hello world");
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        node.left = node1;
        node.right = node2;

        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;
        int result = kthSmallest(node, 3);
        System.out.println("this code is::: " + result);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 先统计左边节点的个数，如果大于左边的个数，则在右边的里面查询，因为二叉搜索树的排序规则决定的。
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        int c = count(root.left);
        if (k <= c) {
            return kthSmallest(root.left, k);
        } else if (k > (c + 1)) {
            return kthSmallest(root.right, k - c - 1);
        }
        return root.val;
    }


    private static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }



}

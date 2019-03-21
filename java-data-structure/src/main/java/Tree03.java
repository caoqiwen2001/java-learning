public class Tree03 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     * @param root
     * @return 思想：采用迭代的思想，对称二叉树的左子树和右子树的值应该要相等在。
     * 需要迭代左子树左节点和右子树的右节点 +左子树的右节点和右子树的左节点
     */
    public static boolean isSymmetric(TreeNode root) {
        return mirror(root.left, root.right);
    }

    public static boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && mirror(right.left, left.right) && mirror(left.left, right.right);
    }
}

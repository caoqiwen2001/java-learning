/**
 * 二叉树测试
 *
 * @author caoqiwen
 */
public final class Tree01 {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


    /**
     * 二叉树前序遍历
     *
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("prdOrder data:" + root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 二叉树中序遍历
     * 先中序遍历左子树，再访问根结点，再后序遍历右子树
     *
     * @param root
     */
    public static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.println("midOrder data:" + root.data);
        midOrder(root.right);
    }


    /**
     * 二叉树后续遍历
     *
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("postOrder data:" + root.data);
    }


    /**
     * 求二叉树的高度
     *
     * @param root
     */
    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = getHeight(root.left);
        int j = getHeight(root.right);
        return i >= j ? i + 1 : j + 1;
    }

    /**
     * 求二叉树的度（节点数）
     *
     * @param root
     */

    public static int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getSize(root.getLeft()) + getSize(root.getRight());
        }
    }


    public static void main(String[] args) {
        TreeNode treeNodeRoot = new TreeNode();
        treeNodeRoot.setData(0);
        TreeNode treeNode1 = new TreeNode();
        treeNode1.setData(1);
        TreeNode treeNode2 = new TreeNode();
        treeNode2.setData(2);
        treeNodeRoot.left = treeNode1;
        treeNodeRoot.right = treeNode2;
        preOrder(treeNodeRoot);
        midOrder(treeNodeRoot);
        postOrder(treeNodeRoot);
    }
}

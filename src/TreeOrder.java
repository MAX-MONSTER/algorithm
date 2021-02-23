import java.util.Arrays;

public class TreeOrder {
    public static void main(String[] args) {
        TreeNode root =  new TreeNode();
        root.val = 1;
        TreeNode lef =  new TreeNode();
        lef.val = 2;
        TreeNode r =  new TreeNode();
        r.val = 3;
        root.left =lef;
        root.right = r;
        TreeNode r1 =  new TreeNode();
        r1.val = 4;
        r.right = r1;
        threeOrders(root);
        System.out.println(Arrays.toString(res[0])+Arrays.toString(res[1])+Arrays.toString(res[2]));
    }
    public static  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    private  static int[][] res;
    private static int preIndex = 0, inIndex = 0, backIndex = 0;

    public static int[][] threeOrders(TreeNode root) {
        // write code here
        int len = getTotalNum(root);
        res = new int[3][len];
        helper(root,len);
        return res;
    }

    // 获得二叉树总节点数，可以为二维数组开辟合适大小空间
    public static  int getTotalNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getTotalNum(root.left) + getTotalNum(root.right);
    }

    // 用于递归实现3种遍历
    public static void helper(TreeNode root, int tool) {
//        if(root!=null){
//            res[0][preIndex++]=root.val;
//            helper(root.left);
//            res[1][inIndex++] = root.val;
//            helper(root.right);
//            res[2][backIndex++] = root.val;
//
//        }
        int[] post = new int[tool];
        postOrder(root, post);
        int[] pre = new int[tool];
        preOrder(root, pre);
        int[] in = new int[tool];
        InOrder(root, in);
        res[0] = pre;
        res[1]= in;
        res[2] = post;
        return;
    }

    public static void postOrder(TreeNode root, int arr[]) {
        if (root != null) {
            postOrder(root.left, arr );
            postOrder(root.right, arr);
            System.out.println(root.val);
            arr[preIndex] = root.val;
            preIndex++;

        }
    }

    public static void preOrder(TreeNode root, int arr[]) {
        if (root != null) {
            System.out.println(root.val);

            arr[inIndex] = root.val;
            inIndex++;
            preOrder(root.left, arr);
            preOrder(root.right, arr);


        }
    }

    public static void InOrder(TreeNode root, int arr[]) {
        if (root != null) {
            InOrder(root.left, arr);
            System.out.println(root.val);
            arr[backIndex] = root.val;
            backIndex++;
            InOrder(root.right, arr);

        }
    }
}

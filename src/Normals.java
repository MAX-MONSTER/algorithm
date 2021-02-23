public class Normals {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        while(null!=head){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode q, TreeNode p) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        } ;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


    public int numDistinct(String s, String t) {
        char[] chars = s.toCharArray();

        char[] dis = t.toCharArray();
        int count = 0;
        int disLen= chars.length;
        for (int i = 0; i < chars.length; i++) {
            int fi = 0;
            ArrayData arrayData = new ArrayData(disLen);
            for (int j = 0; i < chars.length; i++) {
                char cur = chars[j];
                if (cur == dis[arrayData.position]) {
                    arrayData.addChar(cur);
                    if(arrayData.position == 0  ){
                        fi = j;
                    }
                    if(arrayData.position == disLen){
                      count++;
                    }
                }
            }
        }
        return count;
    }

    public class ArrayData {
        private int position;
        private char[] data;

        public ArrayData(int size) {
            position = 0;
            data = new char[size];
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public char[] getData() {
            return data;
        }

        public void setData(char[] data) {
            this.data = data;
        }

        public void addChar(char c) {
            data[position] = c;
            position++;
        }
    }

    public static void main(String[] args) {
        System.out.println("fsf".hashCode());
        System.out.println("fsf".hashCode());
        String a = "fs"+"f";
        System.out.println(a == "fsf");
        System.out.println("来".getBytes().length);
    }
}

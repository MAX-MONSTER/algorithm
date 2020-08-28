import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:monsterHan
 * @date:2020/8/28-15:01
 * @description:@TODO
 */
public class Djstl {
    public static final int N = 5999999;
    //节点名
    private char[] nodeName;
    //邻距矩阵
    private int[][] matrix;
    //已经访问的节点
    private int[] runed;
    //最短路径
    private int[] waysLenth;
    //上一个节点
    private int[] preNode;


    public boolean isRuned(int startIndex) {
        return runed[startIndex] == 1;
    }

    public int getWaysLenth(int index) {
        return waysLenth[index];
    }

    public int getPreNode(int index) {
        return preNode[index];
    }

    public void updateWaysLenth(int startIndex) {
        int len = 0;
        int[] curMatrix = this.matrix[startIndex];
        for (int i = 0; i < curMatrix.length; i++) {

            //当前下方节点到定点距离为 开始节点到顶点距离加上当前节点到下方节点距离 A>B>C  = A>B +B>C
            len = curMatrix[i] + getWaysLenth(startIndex);
            if (!isRuned(i) && len < getWaysLenth(i)) {
                waysLenth[i] = len;
                preNode[i] = startIndex;
            }

        }
    }


    public int getNewStartNode() {
        int min = N;
        int index = 0;
        for (int i = 0; i < waysLenth.length; i++) {
            if (!isRuned(i) && waysLenth[i] < min) {
                min = waysLenth[i];
                index = i;
            }
        }
        runed[index] = 1;
        return index;
    }

    void show(int start) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < waysLenth.length; i++) {
            list.clear();
            ;
            StringBuilder sb = new StringBuilder();
            sb.append("ways :  ");
            int pre = getPreNode(i);
            if (pre == start) {
                sb.append(nodeName[start]).append(" > ").append(nodeName[i]).append("    way_lenth : ").append(waysLenth[i]);
            } else {
                list.add(i);
                if (pre != start) {
                    list.add(pre);
                    pre = getPreNode(pre);
                }
                list.add(start);
                Collections.reverse(list);
                for (Integer index : list) {
                    sb.append(nodeName[index]).append(" > ");
                }
                sb.append("    way_lenth : ").append(waysLenth[i]);
            }
            System.out.println(sb.toString());
        }
    }

    public Djstl(int[][] matrix, char[] nodeName) {
        this.matrix = matrix;
        this.nodeName = nodeName;
    }

    public void run(int startIndex) {
        runed = new int[nodeName.length];
        runed[startIndex] = 1;
        waysLenth = new int[nodeName.length];
        Arrays.fill(waysLenth, N);
        waysLenth[startIndex] = 0;
        preNode = new int[nodeName.length];
        int temp = startIndex;
        for (int i = 0; i < nodeName.length; i++) {
            updateWaysLenth(startIndex);
            startIndex = getNewStartNode();
        }
        show(temp);
    }

    public static void main(String[] args) {
        char[] nodeName = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[nodeName.length][nodeName.length];
        //                A  B C D E F G
      matrix[0]=new int []{N,3,2,N,N,N,N};
      matrix[1]=new int []{3,N,N,2,N,1,N};
      matrix[2]=new int []{2,N,N,N,4,N,N};
      matrix[3]=new int []{N,2,N,N,3,N,N};
      matrix[4]=new int []{N,N,4,3,N,N,5};
      matrix[5]=new int []{N,1,N,N,N,N,4};
      matrix[6]=new int []{N,N,N,N,5,4,N};
      Djstl dj =new Djstl(matrix,nodeName);
      dj.run(1);
    }

}

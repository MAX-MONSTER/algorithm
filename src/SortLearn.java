import java.util.Arrays;

/**
 * @author:monsterHan
 * @date:2020/8/26-14:08
 * @description:@TODO
 */
public class SortLearn {

    public static void main(String[] args) {
//        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 101, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
//        chooseSort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//
//        int arr[] = {5,7, 2, 1, 9, 10, 4,6,3,8};
        int arr[] = {6,5, 8, 2, 1, 3, 4};
        quickSort1(arr,0,arr.length-1);
        System.out.println(arr);

    }

    public static void chooseSort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }

        }
    }


    public static int[] reduceSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            reduceSort(a, low, mid);
            reduceSort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中  两小块开始比较
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }



    /**
     *  @author: monsterHAN
     *  @Date: 2020/8/26 快速排序 总的思想 取第一个基准  左右以此比较 大的放右小的放左
     *  @Description:
     */

    public static void quickSort1(int[] arr, int low, int hight) {
        int i, j, temp, t;
        if (low > hight) {
            return;
        }

        temp = arr[low];
        j = hight;
        i = low;
        while (i < j) {
            //如果右边的比基准大那就留着  指针向前移动
            while (arr[j] >= temp && i < j) {
                j--;
            }
            //如果右边的比基准大那就留着  指针向后移动
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //基准调换
        arr[low] = arr[i];
        //
        arr[i] = temp;
        quickSort1(arr,low,i -1 );
        quickSort1(arr,i+1,hight );
    }


    public static  void quickSort(int []arr,int l,int h){
        int i , j,temp ,t;
        if (l > h) {
            return;
        }
        i = l ;
        j = h;
        temp = arr[l];
          while(i < j){
              while(arr[j]>=temp && i < j) j--;
              while(temp>=arr[i] && i< j) i++;
              if(i<j){
                  t = arr[j];
                  arr[j] = arr[i];
                  arr[i] = t ;
              }
          }
        arr[l] = arr[i];
        arr[i] = temp;
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,h);
    }
    static int a = 6;
static{
        a+=9;
}
static {
    a /=3;
}


}

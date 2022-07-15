import java.util.Arrays;

/**
 * 排序合集
 */

public class sort {
    /**
     * 选择排序
     *
     */
    public static void selectsort(int[] arr) {
        if(arr == null || arr.length < 2 ){
            return;
        }
        for(int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ?  j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 冒泡排序
     */

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int e = arr.length -1; e > 0 ; e-- ){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr,i,i+1);
                }
            }
        }

    }

    /**
     * 插入排序
     */

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 归并排序
     */

    public static void mergeSort(int[] arr,int l,int r){
        if(arr == null ||arr.length < 2){
            return;
        }
        int mid = l + ((r -l) >> 1);
        mergeSort(arr,0,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int[] arr,int l,int mid,int r){
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int [] help = new int[r - l +1];

        while(p1 < mid && p2 < r){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=r){
            help[i++] = arr[p2++];
        }
        for(int k = 0;i<help.length;i++){
            arr[l+k] = help[k];
        }

    }

    public int minMeetingRooms(int[][] intervals) {
        int cur = 0;
        int[][] hours = new int[intervals.length * 2][2];
        for(int i=0 , j= 0;i<intervals.length && j < intervals.length *2 ;i++,j=j+2){
            hours[j] = new int[] {intervals[i][0],0};
            hours[j+1] = new int[] {intervals[i][1],1};
        }
        for(int i = 0;i<hours.length;i++){
            if(hours[i][0]==0){
                cur += 1;
            }else{
                cur -= 1;
            }
        }
        return cur;
    }






    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int[][] help = new int[slots1.length *2 + slots2.length*2][3];
        int i = 0;
        for(int[] slot : slots1){
            help[i++] = new int[]{slot[0],1,1};
            help[i++] = new int[]{slot[1],1,-1};
        }
        for(int[] slot : slots2){
            help[i++] = new int[]{slot[0],2,1};
            help[i++] = new int[]{slot[1],2,-1};
        }
        Arrays.sort(help,(x,y) -> x[0] - y[0]);
        for(int j = 0;j<help.length-1;j++){
            int[] status1 = help[j];
            int[] status2 = help[j+1];
            if(status2[0] - status1[0] >= duration && status1[1] != status2[1] && status1[2] == status2[2]){
                return new int[]{status1[0],status1[0] + duration} ;

            }

        }
        return new int[]{};
    }




    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        int[] arr = {1,2,3,6,5};
        //selectsort(arr);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        long endMillis = System.currentTimeMillis();
        System.out.println(endMillis - startMillis);
        String s = "qwert";
        String t = "rewq";
        Arrays.sort(s.toCharArray()) ;
        Arrays.sort(t.toCharArray()) ;

        //return Arrays.sort(ss) == Arrays.sort(tt);
    }

}

package JobsAcademy.datastructure;
import java.util.Arrays;
import java.util.Scanner;
 
public class Numberbox {
    public static int n;
    public static int[] arr;
//    public static int[] sorted;
    public static int binarySearch(int a) {
        int first = 0;
        int last = n-1;
        
        
        while(first<=last) {
            int mid = (last+first)/2;
            
            if(a > arr[mid]) 
                first = mid+1;
            else if(a < arr[mid]) 
                last = mid-1;
            
            if(a == arr[mid])
                return 1;
        }
        return 0;
    }
//    public static void mergeSort(int[] arr, int m, int n) {
//        int middle;
//        if (m < n) {
//            middle = (m + n) / 2;
//            mergeSort(arr, m, middle);
//            mergeSort(arr, middle + 1, n);
//            merge(arr, m, middle, n);
//        }
//    }
//    public static void merge(int[] arr, int m, int middle, int n) {
//        int i, j, k, t;
// 
//        i = m;
//        j = middle + 1;
//        k = m;
// 
//        while (i <= middle && j <= n) {
//            if (arr[i] <= arr[j])
//                sorted[k] = arr[i++];
//            else
//                sorted[k] = arr[j++];
//            k++;
//        }
// 
//        if (i > middle) {
//            for (t = j; t <= n; t++, k++)
//                sorted[k] = arr[t];
//        } else {
//            for (t = i; t <= middle; t++, k++)
//                sorted[k] = arr[t];
//        }
// 
//        for (t = m; t <= n; t++)
//            arr[t] = sorted[t];
// 
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n];
        
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        int m = sc.nextInt();
        int[] s = new int[m];
        
        for(int i=0;i<m;i++) 
            s[i] = sc.nextInt();
        
        Arrays.sort(arr);
        
        for(int i=0;i<m;i++) {
            System.out.println(binarySearch(s[i]));
        }
    }
 
}
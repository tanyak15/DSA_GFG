package ARRAYS;
import java.util.*;
public class reverse_an_array {
    static void Swap(int arr[] ,int a ,int b){
        int temp = arr[a] ;
        arr[a] =arr[b] ;
        arr[b] = temp;
    }
    static int[] reverse(int []arr ){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            Swap(arr , low ,high);
            low++;
            high--;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] =new int[n];
        for (int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int[] AR = reverse(A);
        for(int i=0;i<n;i++){
            System.out.print(AR[i] +" ");
        }
    }
}

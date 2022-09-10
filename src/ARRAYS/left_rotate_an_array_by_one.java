package ARRAYS;
import java.util.*;
public class left_rotate_an_array_by_one {
    static void leftRotateByOne(int[] arr ,int n){
        int f = arr[0];
        for (int i=0;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = f;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] =new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        leftRotateByOne(arr , n);
    }
}

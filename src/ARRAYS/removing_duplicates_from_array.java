package ARRAYS;
import java.util.*;
public class removing_duplicates_from_array {
    static int[] reverse(int []arr ,int n){
//        create a temp array
        int []temp = new int[n];

//         as first element will always be distinct so directly add it to temp array
        temp[0] = arr[0];

//
        int res = 1;
        for(int i=1;i<n;i++){
            if (temp[res-1] != arr[i]){
                temp[res] = arr[i];
                res++;
            }

        }
        for (int i=0;i<n;i++){
            arr[i] = temp[i];
        }
        return arr;
    }
//    ******************************************************************************************************
static int[] brute(int []arr ,int n){
//        create a temp array
    int []temp = new int[n];

//         as first element will always be distinct so directly add it to temp array

    int indx=0;
    for(int i=0;i<n-1;i++){
        if (arr[i] != arr[i+1]){
            temp[indx] = arr[i];
            indx++;
        }
    }
    for (int i=0;i<n;i++){
        arr[i] = temp[i];
    }
    return arr;
}
//    ******************************************************************************************************

    static int[] remove_eff(int []arr ,int n){

        int res = 1;
        for(int i=1;i<n;i++){
            if (arr[res-1] != arr[i]){
                arr[res] = arr[i];
                res++;
            }
        }
        for (int i=0;i<n;i++){
            if(i>res){
                arr[i] =0;
            }
            System.out.print(arr[i]+" ");
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
        int[] AR = reverse(A ,n);
        for(int i=0;i<n;i++){
            System.out.print(AR[i] +" ");
        }
        System.out.println();
        remove_eff(AR , n);
    }
}

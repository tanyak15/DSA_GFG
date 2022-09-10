package ARRAYS;

import java.util.Scanner;

public class deleting_an_element_from_array {
    static int delete(int arr[],int n, int x)
    {
        for (int i=0;i<n ;i++ ){
            if (arr[i] == x){
                break;
            }
            if(i == n ){
                return n;
            }
            for(int j= i;j<n-1;j++){
                arr[j] =arr[j+1];
            }

        }
        return (n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] =new int[n];
        for (int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        delete(A,n, x);
        for (int i=0;i<A.length-1;i++){
            System.out.print(A[i] + " ");
        }
    }
}

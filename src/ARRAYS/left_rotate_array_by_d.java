package ARRAYS;

import java.util.Scanner;

public class left_rotate_array_by_d {
    static void leftRotateByD_brute(int[] arr, int d, int n) {
        int k = d % n;

        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //   ********************************************************************************************************
    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    static void reverse(int[] arr, int l, int h) {
        while (l <= h) {
            swap(arr ,l ,h);
            l++;
            h--;
        }
    }

    static void leftRotateByD_eff(int[] arr, int d, int n) {
        int k = d % n;
        reverse(arr ,0 ,k-1);
        reverse(arr ,k ,n-1);
        reverse(arr ,0 ,n-1);

        for (int i=0;i<n;i++){
            System.out.print(arr[i] +" ");
        }
    }

    //    *****************************************************************************************************
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
//        leftRotateByD_brute(arr, d, n);
        leftRotateByD_eff(arr ,d ,n);
    }
}

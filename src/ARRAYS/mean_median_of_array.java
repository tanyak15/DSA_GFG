package ARRAYS;

import java.util.*;

public class mean_median_of_array {

    static int mean(int A[], int N) {
        //Your code here
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }
        return sum / N;

    }

    static int median(int A[], int N) {
        int num = 0;
        Arrays.sort(A);
        if (N % 2 == 0) {
            num = A[((N - 1) / 2 + (N / 2)) / 2];
        } else {
            num = A[(N / 2)];
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] =new int[n];
        for (int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        System.out.print(mean(A , n)+" ");
        System.out.print(median(A , n));
    }
}

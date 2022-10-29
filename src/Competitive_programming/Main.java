package Competitive_programming;

import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/* Name of the class has to be "Main" only if the class is public. */
public class Main {
    //************************************************************************************************************//
    static Scanner sc = new Scanner(System.in);

    //************************************************************************************************************//
    static ArrayList<Long> getArrayList(Long N) {
        ArrayList<Long> arr = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            arr.add(sc.nextLong());
        }
        return arr;
    }

    static <T> void printArrayList(ArrayList<T> arr) {
        for (T ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }


    static <T> void printArray(T[] arr) {
        for (T ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    static Long[] getLongArray(int N) {
        Long arr[] = new Long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        return arr;
    }

    static Long gcd(Long a, Long b) {
        Long res = Math.min(a, b);
        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;
    }

    //************************************************************************************************************//
    static int fib(int N){
        if(N!=0 && N%5 == 0){
            return 11;
        }
        if(N==0 || N==1){
            return N;
        }
            return fib(N - 1) + fib(N - 2);

    }
    static int findNth(int n){
        int arr[] = new int[100000];
        for(int i=0;i<=n;i++){
            arr[i] = (int) (fib(n) % (Math.pow(10,9)+7));
        }
        return (int)arr[n];

    }


    //************************************************************************************************************//
    public static void main(String[] args) throws java.lang.Exception {
//        long testCase = sc.nextLong();
//        for (long i = 0; i < testCase; i++) {
//        int arr[] = {1, 2, 3};
//        System.out.println(plusOne(arr));
        findNth(2);
        System.out.println(findNth(6));
//        }
    }
}


//    static int[] plusOne(int[] digits) {
//        int Cnum =0;
//        int[] arr = new int[digits.length+1];
//
//        for(int i=0;i<digits.length-1; i++){
//            Cnum += digits[i]*Math.pow(10,digits.length-i-1);
//        }
//        int resNum = Cnum+1;
//
//        int j=0;
//        while(resNum>0){
//            int rem = resNum%10;
//            arr[j] = rem;
//            j++;
//            resNum /= 10;
//        }
//        return arr;
//    }

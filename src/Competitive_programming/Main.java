package Competitive_programming;

import java.util.*;
import java.lang.*;

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

    static void solve() {


    }

    //************************************************************************************************************//
    public static void main(String[] args) throws java.lang.Exception {
        long testCase = sc.nextLong();
        for (long i = 0; i < testCase; i++) {
            solve();
        }
    }
}


//

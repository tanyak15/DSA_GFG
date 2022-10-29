package ARRAYS;


import java.util.*;

public class leaders_in_an_array {
    static ArrayList<Integer> leaders(int arr[], int n) {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
        int res = arr[n - 1];
        al.add(res);
        for (int i = n - 2; i >= 0; i--) {
            if (res <= arr[i]) {
                res = arr[i];
                al.add(res);
            }

        }
        Collections.reverse(al);
        return al;
    }
    public static void main(String[] args) {
        int A[] = {16,17,4,3,5,2};
        int N =6;

        leaders(A , N);
        System.out.println(leaders(A , N));
    }
}

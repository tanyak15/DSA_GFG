package ARRAYS;

import java.util.ArrayList;

public class smallest_and_second_smallest_element_in_array {
    static long[] minAnd2ndMin(long a[], long n)
    {
        long[] ans = new long[2];
        long first = Long.MAX_VALUE;
        long second = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]<first ){
                second = first;
                first = a[i];
            }
            else if(a[i]<second && a[i] > first){
                second = a[i];
            }

        }
        if(first==second || first == Long.MAX_VALUE || second ==Long.MAX_VALUE){
            first =-1;
            second =-1;
        }
        ans[0] = first;
        ans[1] = second;
        return ans;
    }
    public static void main(String[] args) {
        long a[] = {2 , 3 , 4, 6,1};
        long[] arr = minAnd2ndMin(a,5);

        for(int i=0;i<2;i++){
            System.out.print(arr[i]+" ");
        }

    }
}

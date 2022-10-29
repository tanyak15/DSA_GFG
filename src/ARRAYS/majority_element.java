package ARRAYS;
import java.util.*;

public class majority_element {

    static int majorityElement(int a[], int size)
    {

        Arrays.sort(a);
        int count=1;
        int res =-1;
        int j=0;
        if(size ==1){
            return a[0];
        }
        for(int i=0;i<size-1;i++){
            if(a[i] == a[i+1]){
                count++;

            }
            else{
                count=1;
            }

            if(count > size/2){
                return a[i];
            }
        }
        return -1;


    }
    public static void main(String[] args) {
        int a[] ={2 , 2 ,4 ,3 ,3};

        System.out.println(majorityElement(a ,5));
    }
}

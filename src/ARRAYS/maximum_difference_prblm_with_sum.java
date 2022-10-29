package ARRAYS;

public class maximum_difference_prblm_with_sum {
//    Naive approach
    static int maxDiff(int arr[] , int n){
        int res = arr[1] - arr[0];
        for(int i = 0;i<n;i++){
            for(int j=i+1;j<n;j++){
                res = Math.max(res , arr[j]-arr[i]);

            }
        }
        return res;
    }
//    efficient
//this is when j> i ans arr[j] > arr[i]
    static int maxDiff_efficient(int arr[] , int n){
        int res = -1;
        int minVal = arr[0];
        for (int i=1;i<n;i++){
            res = Math.max(res , arr[i] - minVal);
            minVal = Math.min(minVal , arr[i]);
        }
        return res;
    }

    //    efficient
//this is when i > j ans arr[i] > arr[j]

    static int maxDiff_efficient2(int arr[] , int n){
        int res = -1;
        int minVal = arr[0];
        for (int i=1;i<n;i++){
            if(arr[i]>minVal){
                res = Math.max(res , arr[i] - minVal);
            }
            minVal = Math.min(minVal , arr[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int [] arr = {2 , 3, 10 ,6 ,4 ,8 ,1};
        maxDiff(arr , 7);
        System.out.println(maxDiff(arr , 7));
        System.out.println(maxDiff_efficient(arr , 7));
        System.out.println(maxDiff_efficient2(arr , 7));
    }
}

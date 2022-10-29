package ARRAYS;

public class strongest_neighbour {
    static void maximumAdjacent(int sizeOfArray, int arr[]){
        int[] a = new int[sizeOfArray-1];
        int res =0;
        for(int i=1;i<sizeOfArray;i++){
            if(arr[i-1] == arr[i]){
                a[res] = arr[i];
                res++;
            }
            else if(arr[i-1] < arr[i]){
                a[res] = arr[i];
                res++;
            }
            else if(arr[i-1] > arr[i]){
                a[res] = arr[i-1];
                res++;
            }
        }
        for(int i=0;i<a.length ;i++){
            System.out.print(a[i] +" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {5 , 8 ,2 ,1 , 1 ,4};
        maximumAdjacent(6 , arr);

    }
}

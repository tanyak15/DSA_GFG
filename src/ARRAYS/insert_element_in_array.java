package ARRAYS;

public class insert_element_in_array {
    static Integer sum(Integer a ,Integer b){
        a=20;
        b=10;
        System.out.println();
        System.out.print(a+" "+b);
        return a+b;
    }
    static public void insertAtIndex(int arr[],int sizeOfArray,int index,int element)
    {
//        step1:right shifting the elements
        for(int i=arr.length-1;i>index ;i--){
            arr[i] = arr[i-1];
        }
//        step 2:putting the element at correct position
        arr[index]= element;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,-1};
        int arr2[] = arr;

        insertAtIndex(arr2,7, 3 ,40);

        for (int i=0;i<7;i++){
            System.out.print(arr[i]+" ");
        }
        Integer a1 = 2;
        Integer b1 = 6;

        sum(a1,b1);
        System.out.println();
        System.out.println("printing a1 b1 :" +a1+" "+b1);
    }
}

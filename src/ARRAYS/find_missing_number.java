package ARRAYS;

public class find_missing_number {
    public static int missingNumber(int A[], int N)
    {
        // Your code goes here
        int sum = 0;

        for(int i=0;i<N;i++){
            sum += A[i];
        }
        int ans = (N* (N+1)) / 2;
        return ans - sum;
    }
    public static void main(String[] args) {
//        int [] A = {1 , 3 ,4 };
//        missingNumber(A  , 4);
//        System.out.println(missingNumber(A  , 4));
    }
}

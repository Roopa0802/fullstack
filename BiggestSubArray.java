import java.util.*;
public class BiggestSubArray {
    public static void main(String[] args){
        Scanner io = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = io.nextInt();
        int array[] = new int[n];
        int val;
        System.out.println("Enter" + n + "array element");
        for (int i=0; i < n; i++){
            val = io.nextInt();
            array[i] = val;
        }
        BiggestSubArray obj = new BiggestSubArray();
        obj.findTheBiggestSubArray(array, n);
    }

    public void findTheBiggestSubArray(int array[], int size){
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < size; i++){
            sum = sum + array[i];
            ans = Math.max(ans, sum);

            if (sum < 0)
            {
                sum = 0;
            }
        }
        System.out.println("Biggest sum:" + ans);
    }
}

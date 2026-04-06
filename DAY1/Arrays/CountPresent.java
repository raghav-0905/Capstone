package DAY1.Arrays;

public class CountPresent {
    static int countPresent(int[] arr){
        int count = 0;
        for(int num : arr){
            count+=num;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1};
        System.out.println(countPresent(arr));
    }
}

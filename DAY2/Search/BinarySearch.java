package DAY2.Search;

public class BinarySearch {
    public static int search(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target)return mid;

            if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12};
        int target = 10;
        System.out.println(search(arr,target));
    }
}

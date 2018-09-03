


public class BiSearch {


    public static void main(String[] args) {

        int [] a = new int[] {1,3,5,6,6};

        System.out.println(biSearch2(a,0,0,a.length-1));



    }

    public static boolean biSearch(int[] arr, int k) {

        return biSearch1(arr,k, 0,arr.length-1);
    }

    public static boolean biSearch1(int[] arr, int k, int low,int high) {
        if(low == high)
            return arr[low] == k;
        if(low > high)
            return false;
        int mid = (low +high) / 2;
        if(arr[mid] ==k) return true;
        if(arr[mid] <k)  return  biSearch1(arr, k, mid+1, high);
        else return  biSearch1(arr, k, low, mid-1);
    }

    public  static  int biSearch2(int [] arr, int k, int low , int high){
        while (low<=high){
            int mid = (low+ high) /2;
            if(arr[mid] ==k)return  mid;
            if(arr[mid] < k) low= mid +1;
            else high = mid-1;
        }



        return -1;
    }

}




public class BiSearch {


    public static void main(String[] args) {

        int [] a = new int[] {1,3,5,6,6};

        System.out.println(biSearch2(a,0,0,a.length-1));

        System.out.println(getFirstK(a,6, 3, 3));

        System.out.println(getLastK(a,6, 0, a.length-1));

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



   //递归写法
    private static int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
            // 下面的判断语句，说明array[mid] == k;
        }else if(mid-1>=start && array[mid-1] == k ){
            // 如果mid==start，直接返回.mid > start, 且array[mid-1] == k，说明在[start, mid-1]中
            return getFirstK(array, k, start, mid-1);
        }else{
            // mid == start 或者 array[mid-1] != k;
            return mid;
        }
    }

    //循环写法
    private static int getLastK(int [] array , int k, int start, int end){
        while(start <= end){
            int mid = (start + end) >> 1;
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1<=end && array[mid+1] == k ){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}

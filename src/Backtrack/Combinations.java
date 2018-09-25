import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4,2).toString());

    }


    // 不可重复使用
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), n, k, 1); // 从1开始取
        return list;
    }

    // 对于不能重复使用数字的情况
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < n+1; i++) {
                tempList.add(i);
                backtrack(list, tempList, n,k, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 可以重复使用数字
    public List<List<Integer>> combineReuseNum(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), n, k);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 1; i < n+1; i++) { //从1开始，因为题目要求
                tempList.add(i);
                backtrack(list, tempList, n,k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}

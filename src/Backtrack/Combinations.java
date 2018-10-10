import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {

        //和Subsets对比起来看！！
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[] { 1,2,3}));

        // 下面只是由Subsets变换过来的！
        System.out.println(combine(7,3).size()); // 不可重复使用数字的到的组合
        System.out.println(combine2(4, 3).size()); // 可重复使用数字得到的组合！
        System.out.println(combine3(4, 3));// 可重复使用数字得到的排列！
    }

    // 找到1到n中，能构成的所有大小为k的数组（不可重复使用数字）
    // 只需返回所有大小为k的set，即每个结果中数字顺序不重要，只关注数字集合，不关注数字之间顺序。
    // 从1到n的数字中，选k个数字，形成一个组合，所以最后结果大小为Cnk
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), n, k, 1); // 从1开始取
        return list;
    }

    // 对于不能重复使用数字的情况
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            // 筛选得到大小为k的组合
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < n + 1; i++) {
                // 当数组中有重复元素的时候，得到所有组合的条件！！
//              if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tempList.add(i);
                backtrack(list, tempList, n, k, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    // 找到了1到n中，能构成的所有大小为k的组合！！（可重复使用数字）
    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack2(list, new ArrayList<Integer>(), n, k, 1); // 从1开始取
        return list;
    }

    private static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < n + 1; i++) {
                tempList.add(i);
                backtrack2(list, tempList, n, k, i);  // 能重复使用数字，则为i，不是i+1!!!!
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 找到了1到n中，能构成的所有大小为k的数组（可重复使用数字，数字不相同!!）
    // 这里返回的是大小为k的所有排列！！！！（可重复使用数字）所有一共有n^k中排列
    public static List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack3(list, new ArrayList<Integer>(), n, k);
        return list;
    }

    private static void backtrack3(List<List<Integer>> list, List<Integer> tempList, int n, int k) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 1; i < n + 1; i++) {
                tempList.add(i);
                backtrack3(list, tempList, n, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //===========================================下面针对数组中有重复数字的情况进行讨论=====================






}

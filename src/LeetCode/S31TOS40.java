import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S31TOS40 {




    //S39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> res= new LinkedList<>();
        Arrays.sort(candidates);
        ArrayList<Integer> oneResult = new ArrayList<>();
        reachTarget(candidates,target, res, 0, 0);

    }


    public boolean reachTarget(int[] candidates, int target, LinkedList res, int currentSum, int start){

        if(currentSum > target) return false;
        int tmp = currentSum + candidates[start];
        if(tmp > currentSum) return false;
        if(tmp == currentSum) {

        }





    }


}

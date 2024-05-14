import java.util.*;
public class DiceRoll {
    public static void main(String[] args) {
        SolutionDP solution = new SolutionDP();

        int n = 2; // Number of dice
        int k = 6; // Number of faces on each die
        int target = 7; // Target sum

        int ways = solution.numRollsToTarget(n, k, target);
        System.out.println("Number of ways to roll a sum of " + target + " with " + n + " dice: " + ways);
    }
}
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        return diceRec(0, n, k, target);
    }

    int diceRec(int index, int n, int k, int target){
        if(target == 0 && index == n){
            return 1;
        }

        if(index == n || target < 0){
            return 0;
        }
        int count = 0;
        for(int i=1; i<=k && i<=target; i++){
            count += diceRec(index+1, n, k, target - i);

        }
        return count;
    }
}

class SolutionDP {
    public int numRollsToTarget(int n, int k, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return diceRec(0, n, k, target, map);
    }

    int diceRec(int index, int n, int k, int target, Map<Integer, Integer> map){
        if(target == 0 && index == n){
            return 1;
        }

        if(index == n || target < 0){
            return 0;
        }

        if(map.containsKey(target)){
            return map.get(target);
        }
        int count = 0;
        for(int i=1; i<=k && i<=target; i++){
            count += diceRec(index+1, n, k, target - i, map);

        }
        map.put(target, count);
        return count;
    }
}
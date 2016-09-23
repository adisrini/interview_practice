package leetcode;

import java.util.Arrays;

public class CoinChange {
   
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChange(coins, amount, 0, 0);
    }
    
    private int coinChange(int[] coins, int amount, int total, int count) {
        if(total == amount) {
            return count;
        }
        for(int i = coins.length - 1; i >= 0; i--) {
            coinChange(coins, amount, total + coins[i], count + 1);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[] {186,419,83,408}, 6249));
    }

}

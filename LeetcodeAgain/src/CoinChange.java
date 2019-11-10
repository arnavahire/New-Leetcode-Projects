/* The key here is the formula: T[i] = min(T[i], T[i-coins[j]]+1) where i iterates over the array which is of the length amount +1,
since we will start from 0 and T[0] will be 0 . This array will help us to understand how many coins will be required to reach any amount till we reach the final amount.
j will iterate over the coins[] array where we will calculate max coins required for each coin */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] totalCoinsRequired = new int[amount+1];
        int[] minCoinUsed = new int[amount+1];

        totalCoinsRequired[0] = 0;
        minCoinUsed[0] = -1;

        for(int i=1;i<=amount;i++)
        {
            totalCoinsRequired[i] = amount + 1; // Here amount +1 stands for Integer.MAX_VALUE, since we wont need 12 coins to create 11 rupees
            minCoinUsed[i] = -1;
        }

        for(int j=0;j<coins.length;j++)
        {
            for(int i=1;i<=amount;i++)
            {
                if(i >= coins[j])
                {
                     if((totalCoinsRequired[i-coins[j]]+1) < totalCoinsRequired[i])
                     {
                         totalCoinsRequired[i] = totalCoinsRequired[i-coins[j]] + 1;
                         minCoinUsed[i] = j;
                     }
                }
            }
        }

        return (totalCoinsRequired[amount]==(amount + 1)) ? -1: totalCoinsRequired[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1,2,5};
        int amt = 11;
        System.out.println("Answer: "+ cc.coinChange(coins, amt));
    }
}

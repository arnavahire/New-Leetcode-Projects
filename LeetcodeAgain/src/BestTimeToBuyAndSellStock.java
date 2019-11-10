import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        if(prices.length ==0 || prices.length==1)
            return 0;

        LinkedList<Integer> profits = new LinkedList<>();

        for(int i=0;i<prices.length-1;i++)
        {
            for(int j=i+1;j<prices.length;j++)
            {
                profits.add(prices[j]-prices[i]);
            }
        }

        Collections.sort(profits);

        int max = profits.getLast();

        if(max<0)
            return 0;

        return max;

    }

    /* [7, 1, 6, 3, 4] */

    /* LOGIC: For first index, maxProfit will always be 0 since you are only buying. But after that, in each iteration
    calculate the lowest stock and the stocks that give maximum positive difference
    */
    public int maxProfitOptimized(int[] prices){
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++)
        {
            minSoFar = Math.min(minSoFar, prices[i]);
            if(i==0)
                continue;
            int currentProfit = prices[i]-minSoFar;
            maxProfit = Math.max(maxProfit, currentProfit);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bttbass = new BestTimeToBuyAndSellStock();

    }
}

public class BestTimetoBuyandSellStockII {

    /* Use this example [5,1,2,3,4] */

    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=0;i<prices.length;i++)
        {
            if(i==0)
                continue;
            int current_profit = prices[i]-prices[i-1];
            if(current_profit>0)
                profit+=current_profit;
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockII bttbass = new BestTimetoBuyandSellStockII();

    }
}

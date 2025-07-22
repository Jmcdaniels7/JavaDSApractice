class stockBnS {
    public static int maxProfit(int[] prices) {
        //we want to find the maximum profit if we buy in the beginning indexes and sell at the next
        int maxProfit = 0;
        int profit;

        // we want to traverse the prices array by 
        // looking at the first index and determining 
        // the maximum profit
        for(int i = 0; i < prices.length; i++)
        {
            for(int j = i + 1; j < prices.length; j++)
            {
                if(prices[i] < prices[j])
                {
                    profit = Math.abs(prices[i] - prices[j]);

                    if(profit > maxProfit)
                    {
                        maxProfit = profit;
                    }
                }
            }
        }

        return maxProfit;
        
    }
    
    public static void main(String args[])
    {
        int[] prices = {10, 1, 5, 11, 2, 7};

        System.out.println("The max profit is:" + maxProfit(prices));
    }
}

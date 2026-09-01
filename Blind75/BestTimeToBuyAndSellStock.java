
//pass
public class BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {

        int minimumSoFar = prices[0];
        int maximumProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minimumSoFar){
                minimumSoFar = prices[i];
            }
            else{
                maximumProfit = Math.max(maximumProfit, prices[i] - minimumSoFar);
            }
        }
        return maximumProfit;
    }
}

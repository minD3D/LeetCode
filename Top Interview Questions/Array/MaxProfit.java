class MaxProfit {
    // fail case
    // int[] nums = { 3, 2, 6, 5, 0, 3 };

    public static int maxProfit(int[] prices) {

        return calculate(prices, 0);
    }

    public static int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

}

// /*
// [7,1,5,3,6,4]
// ^ ^

// greedy
// buy day1 p7
// d2 p1 d-day - from day < 0 -> don't buy
// sell price - buy price < 0 return 0
// d3 p5 result < 0 -> x
// d4 p3 result < 0 -> x .... no positive value from day1

// buy day2 p1
// d3 p5 5-1 > 0 -> 4
// d4 p3 3-1 -> 2
// d5 p6 6-1 -> 5
// d6 p4 4-1 -> 3

// ...

// 무한루프 형식으로 합이 가장 클때까지 돌려서 업데이트 하도록 만들자..!

// */
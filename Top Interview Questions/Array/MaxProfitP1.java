class MaxProfitP1 {
    // fail case
    // int[] nums = { 3, 2, 6, 5, 0, 3 };

    public static int maxProfit(int[] prices) {

        int maxSum = 0;
        for (int i = 0; i < prices.length; i++) {
            System.out.println("--------" + i);

            int maxProfit = getCurrentProfit(i, i + 1, 0, prices);
            maxSum = maxSum < maxProfit ? maxProfit : maxSum;
        }

        return maxSum;
    }

    // change it to call next sum itself
    private static int getCurrentProfit(int buyIndex, int sellIndex, int sumProfit, int[] prices) {
        if (sellIndex >= prices.length) {
            return sumProfit;
        }
        System.out.println("----separate----");
        System.out.println("bi" + buyIndex + " value" + prices[buyIndex]);
        System.out.println("si" + sellIndex + " value" + prices[sellIndex]);

        if (prices[buyIndex] > prices[sellIndex]) {
            System.out.println("sum" + (sumProfit));

            return getCurrentProfit(buyIndex, sellIndex + 1, sumProfit, prices);
        }

        System.out.println("sum case bi keep" + (sumProfit));
        System.out.println("sum cae bi next" + (sumProfit + prices[sellIndex] - prices[buyIndex]));

        return Math.max(
                getCurrentProfit(sellIndex + 1, sellIndex + 2, sumProfit + prices[sellIndex] - prices[buyIndex],
                        prices),
                getCurrentProfit(buyIndex, sellIndex + 1, sumProfit, prices));
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
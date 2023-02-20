package hu.jadloakos.solution;

import hu.jadloakos.problem.SlidingWindowProblems;

/** Solutions for problems in {@link SlidingWindowProblems}. */
public class SlidingWindowSolutions implements SlidingWindowProblems {

  @Override
  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    var maxProfit = 0;
    var maxPriceAtIndex = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; i--) {
      var price = prices[i];

      maxProfit = Math.max(maxProfit, maxPriceAtIndex - price);
      maxPriceAtIndex = Math.max(maxPriceAtIndex, price);
    }

    return maxProfit;
  }
}

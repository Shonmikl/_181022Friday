package org.example._2023_06_23.backPack;

public class Perebor {

    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 2, 4, 5,
                         15, 4, 5, 8, 2, 4, 5,
                         6, 4, 5, 8, 2, 4, 5,
                        11, 4, 5, 8, 2, 4, 5,
                        2, 4, 5, 8, 2, 4, 5,
                        8, 9, 4, 5, 8, 9, 8,
                9, 4};
        int[] prices = {10, 6, 4, 7, 6, 2, 5, 4, 6, 4, 9,
                        8, 6, 4, 6, 4, 6, 4, 6, 4, 6, 4,
                8, 6, 4, 6, 4, 6, 4, 6, 4, 6, 4,
                8, 6, 4, 6, 4, 6, 4, 6, 4, 6, 4,  };

        //
        int maxWeight = 88;
        int maxPrice = 0;
        int maxState = 0;

        long count = 1L << weights.length;

        for (int state = 1; state <= count; state++) {
            int price = statePrice(state, prices);
            int weight = stateWeight(state, weights);
            if (weight <= maxWeight && price > maxPrice) {
                maxPrice = price;
                maxState = state;
            }
        }

        System.out.println("Optimum set is : ");
        for (int i = 0; i < weights.length; i++) {
            if (((1 << i) & maxState) != 0) {
                System.out.println(i);
            }
        }
    }

    private static int stateWeight(int state, int[] weights) {
        int weight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (((1 << i) & state) != 0) {
                weight += weights[i];
            }
        }
        return weight;
    }

    private static int statePrice(int state, int[] prices) {
        int price = 0;
        for (int i = 0; i < prices.length; i++) {
            if (((1 << i) & state) != 0) {
                price += prices[i];
            }
        }
        return price;
    }
}
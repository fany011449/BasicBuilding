package com.dell.Arrays;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

public class arrays_Demo {
    public arrays_Demo() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50, 60};
        System.out.println(Arrays.toString(arr));
        int[] arr2 = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(arr3));
        int[] arr31 = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(arr31));
        final double[] price = new double[]{(double)99.0F, (double)50.0F, (double)100.0F, (double)300.0F};
        Arrays.setAll(price, new IntToDoubleFunction() {
            public double applyAsDouble(int value) {
                BigDecimal prices = BigDecimal.valueOf(price[value]);
                BigDecimal mul = BigDecimal.valueOf(0.8);
                return prices.multiply(mul).doubleValue();
            }
        });
        System.out.println(Arrays.toString(price));
        Arrays.sort(price);
        System.out.println(Arrays.toString(price));
    }
}

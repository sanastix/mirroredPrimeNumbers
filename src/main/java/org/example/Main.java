package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    private static double a = 2.3;
    private static double EPS = 1e-3;

    public static void main(String[] args) {

        int n = (int) Math.round((2.8 - 0.2) / 0.002 + 1);
        double[] x = IntStream.range(0, n).mapToDouble(i -> 0.2 + i * 0.002).toArray();
        double[] y = fillY(x);

        System.out.println(biggestYAndItsX(y, x));
        System.out.println(leastYAndItsX(y, x));

    }

    public static String biggestYAndItsX(double[] yArr, double[] xArr){
        double y = biggestY(yArr);
        double x = xArr[Arrays.binarySearch(yArr, y)];
        return String.format("Biggest y = %.3f; Its x =  %.3f", y, x);
    }

    public static String leastYAndItsX(double[] yArr, double[] xArr){
        double y = leastY(yArr);
        double x = xArr[Arrays.binarySearch(yArr, y)];
        return String.format("Least y = %.3f; Its x =  %.3f", y, x);
    }

    public static double biggestY(double[] yArr){
        Arrays.sort(yArr);
        return yArr[yArr.length - 1];
    }

    public static double leastY(double[] yArr){
        Arrays.sort(yArr);
        return yArr[0];
    }

    public static double yArraySum(double[] yArr){
        return Arrays.stream(yArr).sum();
    }

    public static double yArithmeticMean(double[] yArr){
        return yArraySum(yArr) / yArr.length;
    }

    public static double[] fillY(double[] x){
        return Arrays.stream(x).map(Main::function).toArray();
    }

    public static double function(double x){

        double y;

        if (x <= 0.3+EPS){
            y = 1.5 * a * Math.pow(Math.cos(x), 2);
        } else if (x > 0.3 && x <= 2.3+EPS) {
            y = Math.pow((x - 2), 2) + 6 * a;
        } else {
            y = 3 * a * Math.tan(x);
        }

        return y;
    }

}
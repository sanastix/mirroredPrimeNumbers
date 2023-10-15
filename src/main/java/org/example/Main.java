package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int begin = in.nextInt();
        int end = in.nextInt();

        int n = end - begin;
        int[] nums = new int[n + 1];

        for (int i = 0; begin <= end; i++) {
            nums[i] = begin;
            begin++;
        }

        List<Integer> primeNumbers = new ArrayList<>();

        for (int num : nums) {
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
        }

        int counter = 0;

        StringBuilder input = new StringBuilder();

        for (Integer l : primeNumbers) {
            input.append(l);
            if (isPrime(Integer.parseInt(String.valueOf(input.reverse())))){
                counter++;
            }
            input.delete(0, input.length());
        }

        System.out.println(counter);

    }

    public static boolean isPrime (int number){
        if (number == 1){
            return false;
        }
        for (int i = 2; i <= number / 2; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

}
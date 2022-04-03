package com.odcode.eureka;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers= new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);

        print(integers);

    }

    public static void print(List<Integer> numbers) {
        for (var no :
                numbers) {
            int count = 0;
            int noOfItemsPerBatch = 4;
            int start = 0;
            int j;
            int current = 0;
            int last = numbers.get(numbers.size() - 1);

            try {
                while (current != last) {
                    for (j = start; j <= numbers.indexOf(last) && count < noOfItemsPerBatch; j++) {
                        current = numbers.get(j);
                        System.out.println("No printed " + current);
                        count++;
                    }
                    Thread.sleep(1000);
                    start = j;
                    count = 0;
                }

            } catch (Exception exception) {
                System.out.println("Error");
            }
            System.out.println();
            System.out.println("Iterated "+ no);
        }

    }
}

package com.lucadani;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HavelHakimi {
    static boolean existsGraph(List<Integer> degreesList) {
        while (true) {
            degreesList.sort(Collections.reverseOrder());
            if (degreesList.isEmpty() || degreesList.get(0) == 0) {
                return true;
            }
            int value = degreesList.get(0);
            degreesList.remove(0);
            if (value > degreesList.size()) {
                return false;
            }
            for (int i = 0; i < value; ++i) {
                degreesList.set(i, degreesList.get(i) - 1);
                if (degreesList.get(i) < 0) {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of degrees: ");
        int degrees = scanner.nextInt();
        List<Integer> degreesList = new ArrayList<>(degrees);
        System.out.print("Enter degrees: ");
        for (int i = 0; i < degrees; ++i) {
            degreesList.add(scanner.nextInt());
        }
        var msg1 = "This degree sequence can form a graph.";
        var msg2 = "This degree sequence can not form a graph.";
        System.out.println(existsGraph(degreesList) ? msg1 : msg2);
    }
}
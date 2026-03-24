package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repository();
        List<Hardware> items = repo.getAllHardware();

        System.out.println("===== HARDWARE MASTERLIST =====");
        for (Hardware h : items) {
            h.display();
        }

        System.out.println("\n===== INVENTORY COUNT =====");

        // Dynamic maps — handles ANY spec value automatically
        Map<Integer, Integer> laptopSpecs = new LinkedHashMap<>();
        Map<Integer, Integer> phoneSpecs = new LinkedHashMap<>();

        for (Hardware h : items) {
            if (h instanceof Laptop) {
                laptopSpecs.merge(h.getSpec(), 1, Integer::sum);
            } else if (h instanceof Phone) {
                phoneSpecs.merge(h.getSpec(), 1, Integer::sum);
            }
        }

        for (Map.Entry<Integer, Integer> entry : laptopSpecs.entrySet()) {
            System.out.println(entry.getKey() + "GB Laptops: " + entry.getValue());
        }

        for (Map.Entry<Integer, Integer> entry : phoneSpecs.entrySet()) {
            System.out.println(entry.getKey() + "MP Phones: " + entry.getValue());
        }
    }
}
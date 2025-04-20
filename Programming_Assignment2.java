/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week5pa2;
import java.util.Scanner;

public class Programming_Assignment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Abby's backyard chicken egg business cost calculator!");

        while (true) {
            // Part 1: Prompt the user for variables
            System.out.print("Enter the number of chickens (0 to exit): ");
            int numChickens = scanner.nextInt();
            if (numChickens == 0) {
                break;
            }

            System.out.print("Enter the average number of eggs laid per day per chicken: ");
            int eggsPerChicken = scanner.nextInt();
            System.out.print("Enter pounds of feed per chicken per day: ");
            double feedPerChicken = scanner.nextDouble();
            System.out.print("Enter the cost per pound for feed: $");
            double feedCostPerPound = scanner.nextDouble();
            System.out.print("Enter egg carton cost: $");
            double eggCartonCost = scanner.nextDouble();
            double totalCost = (feedCostPerPound * numChickens * feedPerChicken) + (eggCartonCost * 20);
            double totalCostPerMonth = calculateTotalCost(numChickens, feedPerChicken, feedCostPerPound, eggCartonCost);
            // Part 1: Echo back entered parameters
            System.out.println("\nVariables entered:");
            System.out.println("Number of chickens: " + numChickens);
            System.out.println("Eggs laid per chicken per day: " + eggsPerChicken);
            System.out.println("Pounds of feed per chicken per day: " + feedPerChicken);
            System.out.println("Cost per pound for feed: $" + feedCostPerPound);
            System.out.println("Egg carton cost: $" + eggCartonCost + "\n");

            System.out.println("Total # of eggs: " + numChickens + eggsPerChicken * 30);
            System.out.println("Total feeding cost: $" + feedCostPerPound * numChickens);
            System.out.println("Total carton cost: $" + String.format("%.2f", totalCostPerMonth));
            System.out.println("It costs: $" + totalCost + " to produce 20 dozen eggs");

            double costPerDozenEggs = calculateCostPerDozenEggs(numChickens, eggsPerChicken, totalCostPerMonth);
            System.out.println("Cost to produce each dozen eggs: $" + String.format("%.2f", costPerDozenEggs) + "\n");

            System.out.println("Cost per dozen eggs with varied feed costs:");
            for (int percentChange = -25; percentChange <= 25; percentChange += 5) {
                double adjustedFeedCost = feedCostPerPound * (1 + percentChange / 100.0);
                double adjustedTotalCost = calculateTotalCost(numChickens, feedPerChicken, adjustedFeedCost, eggCartonCost);
                double adjustedCostPerDozen = calculateCostPerDozenEggs(numChickens, eggsPerChicken, adjustedTotalCost);
                System.out.println("Feed cost change: " + percentChange + "%, Cost per dozen eggs: $" + String.format("%.2f", adjustedCostPerDozen));
            }
        }

        System.out.println("Happy Feeding in this Economy!");
    }

    private static double calculateTotalCost(int numChickens, double feedPerChicken, double feedCostPerPound, double emptyCartonCost) {
        return numChickens * feedPerChicken * 30 * feedCostPerPound + emptyCartonCost;
    }

    private static double calculateCostPerDozenEggs(int numChickens, int eggsPerChicken, double totalCostPerMonth) {
        return totalCostPerMonth / (eggsPerChicken * 30 / 12.0);
    }
}

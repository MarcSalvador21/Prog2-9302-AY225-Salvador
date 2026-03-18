package Java;

import java.util.Scanner;

public class PrelimLabWork3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter Attendance score: ");
        double attendance = sc.nextDouble();

        System.out.print("Enter Lab Work 1 grade: ");
        double lab1 = sc.nextDouble();

        System.out.print("Enter Lab Work 2 grade: ");
        double lab2 = sc.nextDouble();

        System.out.print("Enter Lab Work 3 grade: ");
        double lab3 = sc.nextDouble();

        // Computations
        double labAverage = (lab1 + lab2 + lab3) / 3;
        double classStanding = (attendance * 0.40) + (labAverage * 0.60);

        // Required Prelim Exam Scores
        double requiredPass = (75 - (classStanding * 0.30)) / 0.70;
        double requiredExcellent = (100 - (classStanding * 0.30)) / 0.70;

        // Output
        System.out.println("\n--- RESULTS ---");
        System.out.println("Attendance: " + attendance);
        System.out.println("Lab Work 1: " + lab1);
        System.out.println("Lab Work 2: " + lab2);
        System.out.println("Lab Work 3: " + lab3);
        System.out.printf("Lab Work Average: %.2f%n", labAverage);
        System.out.printf("Class Standing: %.2f%n", classStanding);

        System.out.printf("Required Prelim Exam (Passing – 75): %.2f%n", requiredPass);
        System.out.printf("Required Prelim Exam (Excellent – 100): %.2f%n", requiredExcellent);

        sc.close();
    }
}
package firstprogram.com;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Num of subjects
        int numberOfSubjects = 5;

        // each subject
        int[] marks = new int[numberOfSubjects];

        int totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                i--;
                continue;
            }

            totalMarks += marks[i];
        }

        double percentage = (double) totalMarks / (numberOfSubjects * 100) * 100;

        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B+";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C+";
        } else if (percentage >= 40) {
            grade = "C";
        } else if (percentage >= 35) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display the results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.println("Average Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}


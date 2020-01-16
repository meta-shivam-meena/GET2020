/*
 * Test Class for Marksheet Class.
 */

package scf.assignment2;

import java.util.Scanner;

public class MarksheetTestClass {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        Marksheet marksheet = null;
        int choice = 0;
        do {
            System.out.println();
            System.out.println("1. Enter new input");
            System.out.println("2. Get Average Grade");
            System.out.println("3. Get Maximum Grade");
            System.out.println("4. Get Minimum Grade");
            System.out.println("5. Get Percentage of Students Passed");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = readInt();
            try {
                switch (choice) {
                case 1:
                    marksheet = new Marksheet(getGrades());
                    break;
                case 2:
                    System.out.println("\nAverage Grade: "
                                       + marksheet.getAverageGrade());
                    break;
                case 3:
                    System.out.println("\nMaximum Grade: "
                                       + marksheet.getMaximumGrade());
                    break;
                case 4:
                    System.out.println("\nMinimum Grade: "
                                       + marksheet.getMinimumGrade());
                    break;
                case 5:
                    System.out.println("\nPercentage of Students Passed: "
                                      + marksheet.getPercentageOfStudentsPassed());
                case 0:
                    break;
                default:
                    System.out.println("\nInvalid Choice. Try Again.");
                    break;
                }
            } catch(NullPointerException e) {
                System.out.println("Marksheet is empty");
            }
        } while (choice != 0);
    }
    
    public static int readInt() {
        int number = -1;
        while (true) {
            if (in.hasNextInt()) {
                number = in.nextInt();
                break;
            } else {
                System.out.print("Please enter a valid integer: ");
                in.next();
            }
        }
        return number;
    }
    
    public static int[] getGrades() {
        int totalStudents;
        int[] grades;
        while (true) {
            System.out.print("Enter total number of students: ");
            totalStudents = readInt();
            if (totalStudents > 0) {
                break;
            } else {
                System.out.print("Please enter a valid positive integer: ");
            }
        }
        grades = new int[totalStudents];
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Enter grade of student " + i + ": ");
            while (true) {
                grades[i] = readInt();
                if (grades[i] >= 0 && grades[i] <= 100) {
                    break;
                } else {
                    System.out.print("Grade should be between 0 and 100: ");
                }
            }
        }
        return grades;
    }
}

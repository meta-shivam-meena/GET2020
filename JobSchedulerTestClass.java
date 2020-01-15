/*
 * Test class for JobScheduler class
 */

package scf.assignment1;

import java.util.Scanner;

public class JobSchedulerTestClass {
    
    private static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        JobScheduler jobScheduler;
        int processCount;
        int[][] arrivalAndBurstTime;
        System.out.println("Enter total number of processes");
        processCount = readInt();
        arrivalAndBurstTime = new int[processCount][2];
        for (int i = 0; i < processCount; i++) {
            System.out.println();
            System.out.println("Enter arrival time of process " + i);
            arrivalAndBurstTime[i][0] = readInt();
            System.out.println("Enter burst time of process " + i);
            arrivalAndBurstTime[i][1] = readInt();
        }
        jobScheduler = new JobScheduler(arrivalAndBurstTime);
        jobScheduler.displayAllDetails();
    }
    
    public static int readInt() {
        int number = -1;
        do {
            System.out.print("Please enter a valid non-negative number: "); 
            if (in.hasNextInt()) {
                number = in.nextInt();
            } else {
                System.out.println("I need a non-negative int.");
                in.nextLine();
            }
        } while (number < 0);
        return number;
    }
}
